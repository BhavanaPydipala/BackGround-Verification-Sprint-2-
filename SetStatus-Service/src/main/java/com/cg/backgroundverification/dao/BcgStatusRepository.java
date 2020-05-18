package com.cg.backgroundverification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.backgroundverification.entity.VerificationDto;


public interface BcgStatusRepository extends JpaRepository<VerificationDto,Integer> {

}
