package com.cg.backgroundverification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.backgroundverification.entity.LoginDto;

public interface LoginDaoRepository extends JpaRepository<LoginDto,Integer> {

	@Query("select login from LoginDto login  where empId=?1 and password=?2 and roleId=?3 ")
	
	LoginDto authentication(int id, String pass,int roleId);

}
