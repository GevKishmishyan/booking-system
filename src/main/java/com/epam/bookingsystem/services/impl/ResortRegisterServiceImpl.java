package com.epam.bookingsystem.services.impl;

import com.epam.bookingsystem.dto.request.ResortRegisterCommentRequestDTO;
import com.epam.bookingsystem.dto.request.ResortRegisterRequestDTO;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ResortRegisterServiceImpl implements ResortRegisterService {

    @Autowired
    ResortRegisterCommentRepository resortRegisterCommentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ResortRegisterCommentMapper resortRegisterCommentMapper;

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

    @Override
    public ResortRegister addComment(Long id, ResortRegisterCommentRequestDTO resortRegisterCommentRequestDTO) {

        ResortRegisterComment comment = resortRegisterCommentMapper.mapToEntity(resortRegisterCommentRequestDTO);
        // todo replace the getById by findById
        ResortRegister resortRegister = resortRegisterRepository.getById(id);
        if (resortRegister.getResortRegisterStatus() == ResortRegisterStatus.NEW) {
            resortRegister.setResortRegisterStatus(ResortRegisterStatus.UNDER_REVIEW);
        }

        List<ResortRegisterComment> resortRegisterCommentList = resortRegister.getResortRegisterCommentList();
        resortRegisterCommentList.add(comment);

        List<ResortRegisterComment> resortRegisterCommentList3 = resortRegisterCommentRepository.saveAll(resortRegisterCommentList);
        resortRegister.setResortRegisterCommentList(resortRegisterCommentList3);
        // resortService.addResort(resortRegister.getResort());

        return resortRegisterRepository.save(resortRegister);
    }

    @Override
    public ResortRegister conformRegistration(Long resortRegisterId) {
        // todo change get with find
        ResortRegister resortRegister = resortRegisterRepository.getById(resortRegisterId);
        System.out.println("point 3 " + resortRegister);
        // todo ask about this tactic
        if( resortService.acceptRegistration(resortRegister.getResort().getId()) ){
            resortRegister.setResortRegisterStatus(ResortRegisterStatus.ACCEPTED);
        }


        return resortRegister;
    }

}
