package com.cg.backgroundverification.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.backgroundverification.entity.EmployeeDocumentDto;
import com.cg.backgroundverification.exception.InvalidDetailsException;
import com.cg.backgroundverification.service.BcgService;

@RestController
@RequestMapping("/BackGroundVerification")
@CrossOrigin("http://localhost:4200")
public class BackGroundVerifierController
{
    
	
	@Autowired
	BcgService bcgservice;
	
	
		/*getting the employee document by id*/
		@GetMapping(value="/GetDocumentById/{enter-id}")
		public List<EmployeeDocumentDto>getById(@PathVariable("enter-id")  int id) throws InvalidDetailsException
		{
		
			EmployeeDocumentDto docobj= bcgservice.getById(id);
			List<EmployeeDocumentDto>list =new ArrayList<EmployeeDocumentDto>();
			list.add(docobj);
			if(docobj!=null)
			{
				return list;
			}
			else
			{
				throw new InvalidDetailsException("No records found with the given employeeId!!!");

			}
			
		}
		
		/*getting the employee document by name*/
		@GetMapping(value="/GetDocumentByName/{enter-name}")
		public List<EmployeeDocumentDto>getById(@PathVariable("enter-name")  String name) throws InvalidDetailsException
		{
			EmployeeDocumentDto employeedocumentdtoobj=bcgservice.getByName(name);
			List<EmployeeDocumentDto>list1 =new ArrayList<EmployeeDocumentDto>();
			list1.add(employeedocumentdtoobj);
			if (employeedocumentdtoobj == null) {
				throw new InvalidDetailsException("Id does not exist,so we couldn't fetch details");
			} 
			else {
				return list1;
			}
			
			
		}
		
	}
