package com.cg.backgroundverification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.backgroundverification.dao.LoginDaoRepository;
import com.cg.backgroundverification.entity.LoginDto;
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDaoRepository logindao;
	@Override
	public LoginDto authentication(int id, String pass,int roleId) {
		
		return logindao.authentication( id, pass,roleId);
	}

}
