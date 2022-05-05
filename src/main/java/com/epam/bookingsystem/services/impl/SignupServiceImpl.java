package com.epam.bookingsystem.services.impl;


import com.epam.bookingsystem.dto.response.UserResponseDTO;
import com.epam.bookingsystem.mapper.impl.UserMapper;
import com.epam.bookingsystem.model.AccessCode;
import com.epam.bookingsystem.model.User;
import com.epam.bookingsystem.repository.AccessCodeRepository;
import com.epam.bookingsystem.repository.UserRepository;
import com.epam.bookingsystem.services.MailService;
import com.epam.bookingsystem.services.SignupService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SignupServiceImpl implements SignupService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final MailService mailService;
    private final AccessCodeRepository accessCodeRepository;


    public SignupServiceImpl(UserRepository userRepository, PasswordEncoder encoder, MailService mailService, AccessCodeRepository accessCodeRepository) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.mailService = mailService;
        this.accessCodeRepository = accessCodeRepository;

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void confirmEmail(String code) {
        Optional<AccessCode> byCode = accessCodeRepository.findByCode(code);
        if (byCode.isEmpty()) {
          throw new RuntimeException("Code does not exist");
        }

        Optional<User> byId = userRepository.findById(byCode.get().getUser().getId());
        if (byId.isEmpty()){
            throw new RuntimeException("User does not exist");
        }
        byId.get().setEnabled(true);
        userRepository.save(byId.get());
        accessCodeRepository.deleteById(byCode.get().getId());


    }

    @Override
    public UserResponseDTO save(User user) {
        String subject = "Your verification link and code";
        String code = mailService.generatePassword();
        String confirmLink="http://localhost:8080/signup/confirm-email/"+code;
        String mailText="Please click on this link to confirm your email \n"+confirmLink;
        user.setPassword(encoder.encode(user.getPassword()));

        UserResponseDTO userResponse = UserMapper.userToDto(userRepository.save(user));

        mailService.send(user.getEmail(),subject,mailText);

        AccessCode accessCode = new AccessCode();
        accessCode.setCode(code);
        accessCode.setUser(user);
        accessCode.setCreatedDate(LocalDateTime.now());

        accessCodeRepository.save(accessCode);
        return userResponse;
    }


}
