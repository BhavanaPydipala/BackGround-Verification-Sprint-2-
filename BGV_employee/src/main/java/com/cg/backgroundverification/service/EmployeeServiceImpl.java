package com.cg.backgroundverification.service;

import java.io.IOException;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cg.backgroundverification.dao.EmployeeDaoRepository;
import com.cg.backgroundverification.dao.statusDao;
import com.cg.backgroundverification.entity.EmployeeDocumentDto;
import com.cg.backgroundverification.entity.VerificationDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {
@Autowired
EmployeeDaoRepository employeedaoobj;
@Autowired 
statusDao statusdaoobj;

@Override
public VerificationDto checkstatus(int id) {
	VerificationDto verobj= statusdaoobj.getOne(id);
	
	return verobj;
	
}

public EmployeeDocumentDto uploadFile(MultipartFile file, String user) {
		EmployeeDocumentDto  dbfile =new  EmployeeDocumentDto();
	try {
		dbfile = new ObjectMapper().readValue(user, EmployeeDocumentDto.class);
	} catch (JsonMappingException e) {
				e.printStackTrace();
	} catch (JsonProcessingException e) {
			e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		dbfile.setDocData(file.getBytes());
	} catch (IOException e) {
		e.printStackTrace();
	}
	dbfile.setDocType(file.getOriginalFilename());  	
	employeedaoobj.save(dbfile);
	VerificationDto verobj=new VerificationDto();
	verobj.setStatus("pending");
	long millis=System.currentTimeMillis();  
	Date startdate=new Date(millis); 
	verobj.setStartDate(startdate);
	verobj.getVerfId();
	dbfile.setVerificationdto(verobj);
	statusdaoobj.save(verobj);
	return dbfile;

}

	
}
