package com.cg.backgroundverification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.backgroundverification.entity.VerificationDto;

public interface statusDao  extends JpaRepository<VerificationDto,Integer>{
	@Query("select e from VerificationDto e where verfId=?1")
	VerificationDto checkstatus(int id);

	
}
