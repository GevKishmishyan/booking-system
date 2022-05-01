package com.epam.bookingsystem.mapper;

public interface Mapper<T,V>  {
    V mapToDto(T t);
}