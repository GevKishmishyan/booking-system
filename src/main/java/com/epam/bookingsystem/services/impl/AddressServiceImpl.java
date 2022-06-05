//package com.epam.bookingsystem.services.impl;
//
//import com.epam.bookingsystem.dto.request.AddressRequestDTO;
//import com.epam.bookingsystem.mapper.impl.requestDTO.AddressRequestDTOMapper;
//import com.epam.bookingsystem.model.Address;
//import com.epam.bookingsystem.model.Resort;
//import com.epam.bookingsystem.repository.AddressRepository;
//import com.epam.bookingsystem.services.AddressService;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AddressServiceImpl implements AddressService {
//    private  final AddressRepository addressRepository;
//
//    public AddressServiceImpl(AddressRepository addressRepository) {
//        this.addressRepository = addressRepository;
//    }
//
//    @Override
//    public Address addAddress(AddressRequestDTO addressRequestDTO, Resort resort) {
//           Address address = AddressRequestDTOMapper.addressRequestDTOtoAddress(addressRequestDTO);
//           address.setResort(resort);
//           addressRepository.save(address);
//        return address;
//    }
//}
