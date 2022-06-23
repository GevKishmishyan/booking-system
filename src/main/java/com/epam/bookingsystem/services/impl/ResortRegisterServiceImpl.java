package com.epam.bookingsystem.services.impl;

import com.epam.bookingsystem.dto.request.ResortRegisterCommentRequestDTO;
import com.epam.bookingsystem.dto.request.ResortRegisterRequestDTO;
import com.epam.bookingsystem.exception.EntityNotFoundException;
import com.epam.bookingsystem.mapper.impl.ResortRegisterCommentMapper;
import com.epam.bookingsystem.mapper.impl.ResortRegisterMapper;
import com.epam.bookingsystem.model.Resort;
import com.epam.bookingsystem.model.ResortRegister;
import com.epam.bookingsystem.model.ResortRegisterComment;
import com.epam.bookingsystem.model.User;
import com.epam.bookingsystem.model.enums.ResortRegisterStatus;
import com.epam.bookingsystem.repository.ResortRegisterCommentRepository;
import com.epam.bookingsystem.repository.ResortRegisterRepository;
import com.epam.bookingsystem.repository.UserRepository;
import com.epam.bookingsystem.security.CurrentUser;
import com.epam.bookingsystem.services.ResortRegisterService;
import com.epam.bookingsystem.services.ResortService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ResortRegisterServiceImpl implements ResortRegisterService {

    private final ResortRegisterCommentRepository resortRegisterCommentRepository;
    private final UserRepository userRepository;
    private final ResortRegisterCommentMapper resortRegisterCommentMapper;
    private final ResortRegisterMapper resortRegisterMapper;
    private final ResortService resortService;
    private final ResortRegisterRepository resortRegisterRepository;

    public ResortRegisterServiceImpl(ResortService resortService, ResortRegisterMapper resortRegisterMapper, ResortRegisterRepository resortRegisterRepository, ResortRegisterCommentRepository resortRegisterCommentRepository, UserRepository userRepository, ResortRegisterCommentMapper resortRegisterCommentMapper) {
        this.resortService = resortService;
        this.resortRegisterMapper = resortRegisterMapper;
        this.resortRegisterRepository = resortRegisterRepository;
        this.resortRegisterCommentRepository = resortRegisterCommentRepository;
        this.userRepository = userRepository;
        this.resortRegisterCommentMapper = resortRegisterCommentMapper;
    }

    @Override
    public ResortRegister addNewResortRegisterRequest(ResortRegisterRequestDTO resortRegisterRequestDTO, List<MultipartFile> standard, List<MultipartFile> lux) {
        ResortRegister resortRegister = resortRegisterMapper.mapToEntity(resortRegisterRequestDTO);
        Resort savedResort = resortService.addResort(resortRegisterRequestDTO.getResortRequestDTO(), standard, lux);
        resortRegister.setResort(savedResort);
        return resortRegisterRepository.save(resortRegister);
    }

    @Override
    public List<ResortRegister> getAll(int page, int size) {
        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.getByEmail(currentUser.getUsername());
        Pageable pageable = PageRequest.of(page, size);
        Page<ResortRegister> resortRegisterList;

        switch (user.getRole()) {
            case MODERATOR:
                String moderatorCountry = user.getCountry();
                resortRegisterList = resortRegisterRepository.findAllByResort_Address_CountryAndResortRegisterStatusIsNot(moderatorCountry, ResortRegisterStatus.ACCEPTED, pageable);
                break;
            case ADMIN:
                resortRegisterList = resortRegisterRepository.findAll(pageable);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + user.getRole());
        }
        return resortRegisterList.getContent();
    }

    @Override
    public ResortRegister addComment(ResortRegisterCommentRequestDTO resortRegisterCommentRequestDTO) {
        ResortRegisterComment comment = resortRegisterCommentMapper.mapToEntity(resortRegisterCommentRequestDTO);
        ResortRegister resortRegister = resortRegisterRepository.findById(resortRegisterCommentRequestDTO
                .getResortRegisterId()).orElseThrow(() -> new EntityNotFoundException("No Entity found with given id"));
        if (resortRegister.getResortRegisterStatus() == ResortRegisterStatus.NEW) {
            resortRegister.setResortRegisterStatus(ResortRegisterStatus.UNDER_REVIEW);
        }
        List<ResortRegisterComment> resortRegisterCommentList = resortRegister.getResortRegisterCommentList();
        resortRegisterCommentList.add(comment);
        List<ResortRegisterComment> resortRegisterCommentList3 = resortRegisterCommentRepository.saveAll(resortRegisterCommentList);
        resortRegister.setResortRegisterCommentList(resortRegisterCommentList3);
        return resortRegisterRepository.save(resortRegister);
    }

    @Override
    public ResortRegister conformRegistration(Long resortRegisterId) {
        ResortRegister resortRegister = resortRegisterRepository.findById(resortRegisterId).orElseThrow(() -> new EntityNotFoundException("No Entity found with given id"));
        if (resortService.conformRegistration(resortRegister.getResort())) {
            resortRegister.setResortRegisterStatus(ResortRegisterStatus.ACCEPTED);
            resortRegisterRepository.save(resortRegister);
        }
        return resortRegister;
    }

}
