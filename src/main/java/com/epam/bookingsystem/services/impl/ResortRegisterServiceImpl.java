package com.epam.bookingsystem.services.impl;

import com.epam.bookingsystem.dto.request.ResortRegisterRequestDTO;
import com.epam.bookingsystem.mapper.impl.ResortRegisterMapper;
import com.epam.bookingsystem.model.Resort;
import com.epam.bookingsystem.model.ResortRegister;
import com.epam.bookingsystem.model.User;
import com.epam.bookingsystem.repository.ResortRegisterRepository;
import com.epam.bookingsystem.repository.UserRepository;
import com.epam.bookingsystem.security.CurrentUser;
import com.epam.bookingsystem.services.ResortRegisterService;
import com.epam.bookingsystem.services.ResortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ResortRegisterServiceImpl implements ResortRegisterService {

    @Autowired
    UserRepository userRepository;

    private final ResortRegisterMapper resortRegisterMapper;
    private final ResortService resortService;
    private final ResortRegisterRepository resortRegisterRepository;

    public ResortRegisterServiceImpl(ResortService resortService, ResortRegisterMapper resortRegisterMapper, ResortRegisterRepository resortRegisterRepository) {
        this.resortService = resortService;
        this.resortRegisterMapper = resortRegisterMapper;
        this.resortRegisterRepository = resortRegisterRepository;
    }

    @Override
    public ResortRegister save(ResortRegisterRequestDTO resortRegisterRequestDTO, List<MultipartFile> standard, List<MultipartFile> lux) {

        ResortRegister resortRegister = resortRegisterMapper.mapToEntity(resortRegisterRequestDTO);

        Resort savedResort = resortService.addResort(resortRegisterRequestDTO.getResortRequestDTO(), standard, lux);

        resortRegister.setResort(savedResort);

        return resortRegisterRepository.save(resortRegister);
    }

    @Override
    public List<ResortRegister> getAll() {

        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.getByEmail(currentUser.getUsername());
        List<ResortRegister> resortRegisterList;

        switch (user.getRole()) {
            case MODERATOR:
                String moderatorCountry = user.getCountry();
                resortRegisterList = resortRegisterRepository.findAllByResort_Address_Country(moderatorCountry);
                break;
            case ADMIN:
                resortRegisterList = resortRegisterRepository.findAll();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + user.getRole());
        }

        return resortRegisterList;

    }
}
