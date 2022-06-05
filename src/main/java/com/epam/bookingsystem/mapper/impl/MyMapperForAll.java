//package com.epam.bookingsystem.mapper.impl;
//
//import com.epam.bookingsystem.dto.response.*;
//import com.epam.bookingsystem.model.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MyMapperForAll {
//
//    public static List<ResortRegisterRequestResponseDTO> resortRegisterRequestList_To_responseDTOList
//            (List<ResortRegisterRequest> resortRegisterRequestList) {
//
//        List<ResortRegisterRequestResponseDTO> responseDTOList = new ArrayList<>();
//        for (ResortRegisterRequest request : resortRegisterRequestList) {
//            ResortRegisterRequestResponseDTO response = MyMapperForAll.resortRegisterRequest_To_responseDTO(request);
//            responseDTOList.add(response);
//        }
//        return responseDTOList;
//    }
//
//    public static ResortRegisterRequestResponseDTO resortRegisterRequest_To_responseDTO(ResortRegisterRequest resortRegisterRequest) {
//        System.out.println("resortRegisterRequest_To_responseDTO");
//        ResortRegisterRequestResponseDTO responseDTO = new ResortRegisterRequestResponseDTO();
//        responseDTO.setResortResponseDTO(resort_To_responseDTO(resortRegisterRequest.getResort()));
//        responseDTO.setRequestStatus(resortRegisterRequest.getRegisterStatus());
//        // todo also add the comments
//
//        return responseDTO;
//    }
//
//    public static ResortResponseDTO resort_To_responseDTO(Resort resort) {
//        ResortResponseDTO resortResponseDTO = new ResortResponseDTO();
//        resortResponseDTO.setName(resort.getName());
//        resortResponseDTO.setStar(resort.getStar());
//        resortResponseDTO.setEmail(resort.getEmail());
//        resortResponseDTO.setTelephone(resort.getTelephone());
//        resortResponseDTO.setResortType(resort.getResortType());
//        resortResponseDTO.setAddressResponseDTO(address_To_responseDTO(resort.getAddress()));
//        resortResponseDTO.setResortDetailsResponseDTO(resortDetails_To_responseDTO(resort.getResortDetails()));
//        resortResponseDTO.setRooms(roomList_To_responseDTOList(resort.getRoom()));
//        resortResponseDTO.setTinResponseDTO(tin_To_responseDTO(resort.getTin()));
//
//        return resortResponseDTO;
//    }
//
//    public static TinResponseDTO tin_To_responseDTO(Tin tin) {
//
//        TinResponseDTO tinResponseDTO = new TinResponseDTO();
//        tinResponseDTO.setSerialNumber(tin.getSerialNumber());
//        tinResponseDTO.setDocument(tin.getDocument());
//        return tinResponseDTO;
//    }
//
//    public static AddressResponseDTO address_To_responseDTO(Address address) {
//
//        AddressResponseDTO addressResponseDTO = new AddressResponseDTO();
//        addressResponseDTO.setCountry(address.getCountry());
//        addressResponseDTO.setRegion(address.getRegion());
//        addressResponseDTO.setSection(address.getSection());
//        addressResponseDTO.setAddress(address.getAddress());
//
//        return addressResponseDTO;
//    }
//
//    public static ResortDetailsResponseDTO resortDetails_To_responseDTO(ResortDetails resortDetails) {
//        ResortDetailsResponseDTO resortDetailsResponseDTO = new ResortDetailsResponseDTO();
//        resortDetailsResponseDTO.setAirportShuttle(resortDetails.isAirportShuttle());
//        resortDetailsResponseDTO.setFreeWiFi(resortDetails.isFreeWiFi());
//        resortDetailsResponseDTO.setBar(resortDetails.isBar());
//        resortDetailsResponseDTO.setBreakfast(resortDetails.isBreakfast());
//        resortDetailsResponseDTO.setTeaCoffeeMaker(resortDetails.isTeaCoffeeMaker());
//        resortDetailsResponseDTO.setNonSmokingRooms(resortDetails.isNonSmokingRooms());
//        resortDetailsResponseDTO.setSpaAndWellness(resortDetails.isSpaAndWellness());
//        resortDetailsResponseDTO.setFitnessCenter(resortDetails.isFitnessCenter());
//        resortDetailsResponseDTO.setFacilitiesForDisabledGuests(resortDetails.isFacilitiesForDisabledGuests());
//        resortDetailsResponseDTO.setRestaurant(resortDetails.isRestaurant());
//        resortDetailsResponseDTO.setPrivateParking(resortDetails.isPrivateParking());
//
//        return resortDetailsResponseDTO;
//    }
//
//    public static List<RoomResponseDTO> roomList_To_responseDTOList(List<Room> roomList) {
//        List<RoomResponseDTO> roomResponseDTOList = new ArrayList<>();
//
//        for (Room room : roomList) {
//            RoomResponseDTO roomResponseDTO = room_To_responseDTO(room);
//            roomResponseDTOList.add(roomResponseDTO);
//        }
//
//        return roomResponseDTOList;
//    }
//
//    public static RoomResponseDTO room_To_responseDTO(Room room) {
//        RoomResponseDTO roomResponseDTO = new RoomResponseDTO();
//        roomResponseDTO.setRoomNumber(room.getRoomNumber());
//        roomResponseDTO.setResortNumberResponseDTO(resortNumber_To_responseDTO(room.getResortNumber()));
//
//        return roomResponseDTO;
//    }
//
//    public static ResortNumberResponseDTO resortNumber_To_responseDTO(ResortNumber resortNumber) {
//        ResortNumberResponseDTO resortNumberResponseDTO = new ResortNumberResponseDTO();
//        resortNumberResponseDTO.setRoomType(resortNumber.getRoomType());
//        resortNumberResponseDTO.setAvailableCount(resortNumber.getAvailableCount());
//        resortNumberResponseDTO.setPerNightPrice(resortNumber.getPerNightPrice());
//        resortNumberResponseDTO.setRoomDetailsResponseDTO(roomDetails_To_ResponseDTO(resortNumber.getRoomDetails()));
//        resortNumberResponseDTO.setRoomPictureResponseDTOS(roomPictureList_To_ResponseDTOList(resortNumber.getRoomPictures()));
//
//        return resortNumberResponseDTO;
//    }
//
//    public static RoomDetailsResponseDTO roomDetails_To_ResponseDTO(RoomDetails roomDetails) {
//        RoomDetailsResponseDTO roomDetailsResponseDTO = new RoomDetailsResponseDTO();
//        roomDetailsResponseDTO.setAirConditioner(roomDetails.isAirConditioner());
//        roomDetailsResponseDTO.setTelevision(roomDetails.isTelevision());
//        roomDetailsResponseDTO.setSofa(roomDetails.isSofa());
//        roomDetailsResponseDTO.setTeaTable(roomDetails.isTeaTable());
//        roomDetailsResponseDTO.setShower(roomDetails.isShower());
//        roomDetailsResponseDTO.setBathtub(roomDetails.isBathtub());
//        roomDetailsResponseDTO.setBathAccessories(roomDetails.isBathAccessories());
//        roomDetailsResponseDTO.setHairdryer(roomDetails.isHairdryer());
//        roomDetailsResponseDTO.setMinibar(roomDetails.isMinibar());
//        roomDetailsResponseDTO.setFridge(roomDetails.isFridge());
//        roomDetailsResponseDTO.setDishes(roomDetails.isDishes());
//        roomDetailsResponseDTO.setElectricKettle(roomDetails.isElectricKettle());
//
//        return roomDetailsResponseDTO;
//    }
//
//    public static List<RoomPictureResponseDTO> roomPictureList_To_ResponseDTOList(List<RoomPicture> roomPictureList) {
//
//        List<RoomPictureResponseDTO> roomPictureResponseDTOList = new ArrayList<>();
//
//        for (RoomPicture roomPicture : roomPictureList) {
//            RoomPictureResponseDTO roomPictureResponseDTO = roomPicture_To_ResponseDTO(roomPicture);
//            roomPictureResponseDTOList.add(roomPictureResponseDTO);
//        }
//        return roomPictureResponseDTOList;
//    }
//
//    public static RoomPictureResponseDTO roomPicture_To_ResponseDTO(RoomPicture roomPicture) {
//        RoomPictureResponseDTO roomPictureResponseDTO = new RoomPictureResponseDTO();
//        roomPictureResponseDTO.setPicUrl(roomPicture.getPicUrl());
//        return roomPictureResponseDTO;
//    }
//
//}
