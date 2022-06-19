package com.epam.bookingsystem.dto.response;

import com.epam.bookingsystem.model.ResortRegisterComment;
import com.epam.bookingsystem.model.enums.ResortRegisterStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ResortRegisterResponseDTO extends ResponseDTO {

    private Long id;

    private ResortResponseDTO resortResponseDTO;

    private ResortRegisterStatus resortRegisterStatus;

    private List<ResortRegisterComment> resortRegisterCommentList;

    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ResortResponseDTO getResortResponseDTO() {
        return resortResponseDTO;
    }

    public void setResortResponseDTO(ResortResponseDTO resortResponseDTO) {
        this.resortResponseDTO = resortResponseDTO;
    }

    public ResortRegisterStatus getResortRegisterStatus() {
        return resortRegisterStatus;
    }

    public void setResortRegisterStatus(ResortRegisterStatus resortRegisterStatus) {
        this.resortRegisterStatus = resortRegisterStatus;
    }

    public List<ResortRegisterComment> getResortRegisterCommentList() {
        return resortRegisterCommentList;
    }

    public void setResortRegisterCommentList(List<ResortRegisterComment> resortRegisterCommentList) {
        this.resortRegisterCommentList = resortRegisterCommentList;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
