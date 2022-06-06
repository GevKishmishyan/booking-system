//package com.epam.bookingsystem.services.impl;
//
//import com.epam.bookingsystem.dto.request.ResortDetailsRequestDTO;
//import com.epam.bookingsystem.dto.requestDTO.ResortDetailsRequestDTOMapper;
//import com.epam.bookingsystem.model.Resort;
//import com.epam.bookingsystem.model.ResortDetails;
//import com.epam.bookingsystem.repository.ResortDetailsRepository;
//import com.epam.bookingsystem.services.ResortDetailsService;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ResortDetailsServiceImpl implements ResortDetailsService {
//    private final ResortDetailsRepository resortDetailsRepository;
//
//    public ResortDetailsServiceImpl(ResortDetailsRepository resortDetailsRepository) {
//         this.resortDetailsRepository = resortDetailsRepository;
//    }
//
//    @Override
//    public ResortDetails addResortDetails(ResortDetailsRequestDTO resortDetailsRequestDTO, Resort resort) {
//        ResortDetails resortDetails = ResortDetailsRequestDTOMapper.ResortDetailsRequestDTOtoResortDetail(resortDetailsRequestDTO);
//        resortDetails.setResort(resort);
//        resortDetailsRepository.save(resortDetails);
//        return resortDetails;
//    }
//}
