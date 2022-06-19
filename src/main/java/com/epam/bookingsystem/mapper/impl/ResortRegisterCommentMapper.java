package com.epam.bookingsystem.mapper.impl;

import com.epam.bookingsystem.dto.request.ResortRegisterCommentRequestDTO;
import com.epam.bookingsystem.dto.response.ResortRegisterCommentResponseDTO;
import com.epam.bookingsystem.mapper.Mapper;
import com.epam.bookingsystem.model.ResortRegisterComment;
import org.springframework.stereotype.Component;

@Component
public class ResortRegisterCommentMapper
        implements Mapper<ResortRegisterComment, ResortRegisterCommentRequestDTO, ResortRegisterCommentResponseDTO> {

    @Override
    public ResortRegisterComment mapToEntity(ResortRegisterCommentRequestDTO resortRegisterCommentRequestDTO) {
        ResortRegisterComment resortRegisterComment = new ResortRegisterComment();
        resortRegisterComment.setComment(resortRegisterCommentRequestDTO.getComment());
        return resortRegisterComment;
    }

    @Override
    public ResortRegisterCommentResponseDTO mapToResponseDto(ResortRegisterComment resortRegisterComment) {
        ResortRegisterCommentResponseDTO resortRegisterCommentResponseDTO = new ResortRegisterCommentResponseDTO();
        resortRegisterCommentResponseDTO.setId(resortRegisterComment.getId());
        resortRegisterCommentResponseDTO.setComment(resortRegisterComment.getComment());
        return resortRegisterCommentResponseDTO;
    }
}
