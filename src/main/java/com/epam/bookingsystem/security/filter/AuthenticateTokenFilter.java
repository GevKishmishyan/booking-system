package com.epam.bookingsystem.security.filter;

import com.epam.bookingsystem.repository.BlockedJWTDataRepository;
import com.epam.bookingsystem.repository.JWTBlacklistDAO;
import com.epam.bookingsystem.security.util.JwtUtils;
import com.epam.bookingsystem.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticateTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private BlockedJWTDataRepository blockedJWTDataRepository;
    @Autowired
    JWTBlacklistDAO jwtBlacklistDAO;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {
            String jwt = parseJwt(request);
            System.out.println("doFilterInternal " + "jwt is in blacklist = " + jwtBlacklistDAO.existsInBlacklist(jwt));
            //if (jwt != null && jwtUtils.validateJwtToken(jwt) && !blockedJWTDataRepository.existsByJwt(jwt)) {
            if (jwt != null && jwtUtils.validateJwtToken(jwt) && !jwtBlacklistDAO.existsInBlacklist(jwt)) {
                System.out.println("doFilterInternal , block if");
                String username = jwtUtils.getUserNameFromJwtToken(jwt);

                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                // todo this has to be replaced , see other examples in the web
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null,
                                userDetails.getAuthorities());
                System.out.println("doFilterInternal in block if , after thrown exception ");

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            System.out.println("doFilterInternal in ckach block " + e);
        }

        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }

        return null;
    }
}
