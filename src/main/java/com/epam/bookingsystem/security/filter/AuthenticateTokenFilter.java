package com.epam.bookingsystem.security.filter;

import com.epam.bookingsystem.dao.JWTBlacklistDAO;
import com.epam.bookingsystem.exception.JWTIsInBlacklistException;
import com.epam.bookingsystem.exception.dto.ErrorDetails;
import com.epam.bookingsystem.security.util.JwtUtils;
import com.epam.bookingsystem.services.impl.UserDetailsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

@Slf4j
public class AuthenticateTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    JWTBlacklistDAO jwtBlacklistDAO;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {
            String jwt = jwtUtils.parseJwt(request);
            if (jwt != null && jwtUtils.validateJwtToken(jwt) && !jwtBlacklistDAO.existsInBlacklist(jwt)) {
                String username = jwtUtils.getUserNameFromJwtToken(jwt);

                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null,
                                userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(request, response);
        } catch (JwtException | IllegalArgumentException | JWTIsInBlacklistException exception) {

            logger.error("Cannot set user authentication: {}" , exception);

            ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getClass().getSimpleName(),
                   exception.getMessage(), request.getServletPath());

            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            OutputStream out = response.getOutputStream();
            final ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(out, errorDetails);
            out.flush();
        }
    }
}
