package com.epam.bookingsystem.repository;

import com.epam.bookingsystem.model.ResortRegisterComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResortRegisterCommentRepository extends JpaRepository<ResortRegisterComment,Long> {
    @Override
    <S extends ResortRegisterComment> List<S> saveAll(Iterable<S> entities);
}
