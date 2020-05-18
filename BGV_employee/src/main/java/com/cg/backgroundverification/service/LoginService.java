package com.cg.backgroundverification.service;

import com.cg.backgroundverification.entity.LoginDto;

public interface LoginService {

	LoginDto authentication(int id, String pass,int roleId);

}
