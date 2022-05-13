package com.epam.bookingsystem.dto.request;

public class ResortGeneralRequestDTO {

    ResortRequestDTO resortRequestDTO;
    TinRequestDTO tinRequestDTO;
    AddressRequestDTO addressRequestDTO;
    ResortDetailsRequestDTO resortDetailsRequestDTO;
    RoomRequestDTO roomRequestDTO;
    RoomDetailsRequestDTO roomDetailsRequestDTO;
    ResortNumberRequestDTO resortNumberRequestDTO;
    RoomPicturesRequestDTO roomPicturesRequestDTO;

    public ResortRequestDTO getResortRequestDTO() {
        return resortRequestDTO;
    }

    public void setResortRequestDTO(ResortRequestDTO resortRequestDTO) {
        this.resortRequestDTO = resortRequestDTO;
    }

    public TinRequestDTO getTinRequestDTO() {
        return tinRequestDTO;
    }

    public void setTinRequestDTO(TinRequestDTO tinRequestDTO) {
        this.tinRequestDTO = tinRequestDTO;
    }

    public AddressRequestDTO getAddressRequestDTO() {
        return addressRequestDTO;
    }

    public void setAddressRequestDTO(AddressRequestDTO addressRequestDTO) {
        this.addressRequestDTO = addressRequestDTO;
    }

    public ResortDetailsRequestDTO getResortDetailsRequestDTO() {
        return resortDetailsRequestDTO;
    }

    public void setResortDetailsRequestDTO(ResortDetailsRequestDTO resortDetailsRequestDTO) {
        this.resortDetailsRequestDTO = resortDetailsRequestDTO;
    }

    public RoomRequestDTO getRoomRequestDTO() {
        return roomRequestDTO;
    }

    public void setRoomRequestDTO(RoomRequestDTO roomRequestDTO) {
        this.roomRequestDTO = roomRequestDTO;
    }

    public RoomDetailsRequestDTO getRoomDetailsRequestDTO() {
        return roomDetailsRequestDTO;
    }

    public void setRoomDetailsRequestDTO(RoomDetailsRequestDTO roomDetailsRequestDTO) {
        this.roomDetailsRequestDTO = roomDetailsRequestDTO;
    }

    public ResortNumberRequestDTO getResortNumberRequestDTO() {
        return resortNumberRequestDTO;
    }

    public void setResortNumberRequestDTO(ResortNumberRequestDTO resortNumberRequestDTO) {
        this.resortNumberRequestDTO = resortNumberRequestDTO;
    }

    public RoomPicturesRequestDTO getRoomPicturesRequestDTO() {
        return roomPicturesRequestDTO;
    }

    public void setRoomPicturesRequestDTO(RoomPicturesRequestDTO roomPicturesRequestDTO) {
        this.roomPicturesRequestDTO = roomPicturesRequestDTO;
    }
}
