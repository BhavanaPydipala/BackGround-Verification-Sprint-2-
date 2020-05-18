package com.cg.backgroundverification.service;

import org.springframework.web.multipart.MultipartFile;

import com.cg.backgroundverification.entity.EmployeeDocumentDto;
import com.cg.backgroundverification.entity.VerificationDto;


public interface EmployeeService {

	EmployeeDocumentDto uploadFile(MultipartFile file, String user);
	VerificationDto checkstatus(int id);	

}
