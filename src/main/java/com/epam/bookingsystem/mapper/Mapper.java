package com.epam.bookingsystem.mapper;

import com.epam.bookingsystem.dto.request.RequestDto;
import com.epam.bookingsystem.dto.response.ResponseDTO;
import com.epam.bookingsystem.model.BaseEntity;

public interface Mapper<T extends BaseEntity,V extends RequestDto,K extends ResponseDTO>  {
    T mapToEntity(V v);
    K mapToResponseDto(T t);

}