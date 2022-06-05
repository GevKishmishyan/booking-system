//package com.epam.bookingsystem.services.impl;
//
//
//import com.epam.bookingsystem.dto.request.SignupUserRequestDTO;
//import com.epam.bookingsystem.dto.response.MessageResponse;
//import com.epam.bookingsystem.dto.response.UserResponseDTO;
//import com.epam.bookingsystem.mapper.Mapper;
//import com.epam.bookingsystem.mapper.impl.SignupMapper;
//import com.epam.bookingsystem.model.AccessCode;
//import com.epam.bookingsystem.model.User;
//import com.epam.bookingsystem.model.enums.Role;
//import com.epam.bookingsystem.repository.AccessCodeRepository;
//import com.epam.bookingsystem.repository.UserRepository;
//import com.epam.bookingsystem.services.MailService;
//import com.epam.bookingsystem.services.SignupService;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//import org.webjars.NotFoundException;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//import java.util.UUID;
//
//@Service
//public class SignupServiceImpl implements SignupService {
//
//    private final AccessCodeRepository accessCodeRepository;
//    private final UserRepository userRepository;
//    private final PasswordEncoder encoder;
//    private final MailService mailService;
//    private final Mapper<User, SignupUserRequestDTO, UserResponseDTO> signupMapper;
//
//    @Value("${spring.mail.confirmLinkIP}")
//    private String confirmLinkIP;
//
//
//    public SignupServiceImpl(AccessCodeRepository accessCodeRepository, UserRepository userRepository, PasswordEncoder encoder,
//                             MailService mailService, SignupMapper signupMapper) {
//        this.accessCodeRepository = accessCodeRepository;
//        this.userRepository = userRepository;
//        this.encoder = encoder;
//        this.mailService = mailService;
//
//
//        this.signupMapper = signupMapper;
//    }
//
//    @Override
//    public Optional<User> findByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    @Override
//    @Transactional
//    public MessageResponse confirmEmail(String code) {
//        AccessCode accesscode = accessCodeRepository.findByCode(code).orElseThrow(() -> new NotFoundException("Wrong code"));
//        User user = userRepository.findByAccessCodeId(accesscode.getId()).orElseThrow(() -> new NotFoundException("Code does not exist"));
//        if (user.getAccessCode().getCreatedAt().isBefore(LocalDateTime.now().minusMinutes(15))) {
//            throw new RuntimeException("The deadline for providing information by mail has expired");
//        }
//        user.setEnabled(true);
//        user.setAccessCode(null);
//        userRepository.save(user);
//        accessCodeRepository.deleteById(accesscode.getId());
//        return new MessageResponse("Your email has been successfully confirmed, now you can login to your account");
//    }
//
//    @Override
//    public User saveUser(SignupUserRequestDTO signupUserRequestDTO) {
//
//        if (!signupUserRequestDTO.getPassword().equals(signupUserRequestDTO.getConfirmPassword())) {
//            throw new RuntimeException("Wrong password confirmation");
//        }
//        User user = signupMapper.mapToEntity(signupUserRequestDTO);
//        user.setPassword(encoder.encode(user.getPassword()));
//        String code = mailService.generatePassword();
//        user.setAccessCode(generateAccessCode(user,code));
//        User userResp = userRepository.save(user);
//        sendEmail(user.getEmail(), code);
//
//        return userResp;
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public User saveModerator(String email) {
//        Optional<User> byEmail = userRepository.findByEmail(email);
//        if (byEmail.isPresent()) {
//            throw new RuntimeException("Email is present");
//        }
//        User moderator = createModerator(email);
//        User saveUser = userRepository.save(moderator);
//        sendUsernamePasswordToEmail(email, moderator.getPassword());
//        return saveUser;
//    }
//
//    public void sendNewAccessCode(String email) {
//        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Email does not exist "));
//        String code = mailService.generatePassword();
//        user.setAccessCode(generateAccessCode(user,code));
//        userRepository.save(user);
//        sendEmail(email, code);
//    }
//
//
//    private void sendEmail(String email, String code) {
//        String subject = "Here is your verification code";
//        String confirmLink = confirmLinkIP + "signup/confirm-email/" + code;
//        String mailText = "Please click on this link to confirm your email \n" + confirmLink;
//        mailService.send(email, subject, mailText);
//    }
//
//    private void sendUsernamePasswordToEmail(String email, String password) {
//        String subject = "Here is your username and password.Please change your password,firstname,lastname, after logging in ";
//        String mailText = "this is your username and password  \n" + "Your username: " + email + "\n" + "Your password: " + password;
//        mailService.send(email, subject, mailText);
//    }
//
//    private AccessCode generateAccessCode(User user, String code) {
//
//        AccessCode accessCode = user.getAccessCode();
//        if (accessCode != null) {
//            AccessCode byId = accessCodeRepository.findById(accessCode.getId()).orElseThrow(()->new NotFoundException("Code does not exist"));
//            byId.setCode(code);
//            byId.setCreatedAt(LocalDateTime.now());
//            return accessCodeRepository.save(byId);
//        } else {
//            accessCode = new AccessCode();
//            accessCode.setCode(code);
//        }
//        accessCode.setCreatedAt(LocalDateTime.now());
//        accessCodeRepository.save(accessCode);
//        return accessCode;
//    }
//
//    private User createModerator(String email) {
//        User user = new User();
//        user.setEmail(email);
//        user.setFirstName("Moderator");
//        user.setLastName("Moderator");
//        String password = String.valueOf(UUID.randomUUID()).substring(0, 8);
//        user.setPassword(encoder.encode(password));
//        user.setEnabled(true);
//        user.setRole(Role.MODERATOR);
//        user.setCreatedAt(LocalDateTime.now());
//        return user;
//    }
//}
