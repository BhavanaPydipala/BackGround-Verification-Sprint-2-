package com.cg.backgroundverification.service;

import com.cg.backgroundverification.entity.EmployeeDocumentDto;

public interface BcgService {

	EmployeeDocumentDto getById(int id);
	
	EmployeeDocumentDto getByName(String name);
	

}
