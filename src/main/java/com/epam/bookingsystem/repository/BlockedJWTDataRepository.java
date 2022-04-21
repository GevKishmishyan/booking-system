package com.epam.bookingsystem.repository;

import com.epam.bookingsystem.entitys.BlockedJWTData;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockedJWTDataRepository extends JpaRepository<BlockedJWTData,Long> {
    @Override
    <S extends BlockedJWTData> S save(S entity);

    //@Override
   // boolean existsByJWT(String jwt);

    boolean existsByJwt(String jwt);
}
