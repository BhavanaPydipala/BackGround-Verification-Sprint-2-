package com.cg.backgroundverification.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cg.backgroundverification.entity.EmployeeDocumentDto;
import com.cg.backgroundverification.entity.LoginDto;
import com.cg.backgroundverification.entity.Response;
import com.cg.backgroundverification.entity.VerificationDto;
import com.cg.backgroundverification.exception.InvalidDetailsException;
import com.cg.backgroundverification.service.EmployeeService;
import com.cg.backgroundverification.service.LoginService;


@RestController
@RequestMapping("/BackgroundVerification-EmployeePortal")
@CrossOrigin("http://localhost:4200")

public class EmployeeController 
{

	@Autowired
	LoginService loginserviceobj;
	@Autowired 
	EmployeeService bcgserviceobj;

	/*Login using credentials*/
	@GetMapping(value="/Login/{enter-userid}/{password}/{roleid}")
	public LoginDto auhentication(@PathVariable("enter-userid") int id,@PathVariable("password") String pass,@PathVariable("roleid") int roleId) throws InvalidDetailsException
	{
		LoginDto loginobj=loginserviceobj.authentication(id,pass,roleId);
			if(loginobj==null) {
				throw new InvalidDetailsException("user not found");
		}
			return loginobj;	
	}
	
	@ExceptionHandler(InvalidDetailsException.class)
	public ResponseEntity<String> usernotfound(InvalidDetailsException e)
	{
		return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
	}
	
	
	/*Uploading the document*/
	@PostMapping(value="/UploadDocument",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    public 		EmployeeDocumentDto  uploadFile(@RequestParam("file") MultipartFile file,
    		@RequestParam("user") String user ) throws IOException, InvalidDetailsException
    {
    	EmployeeDocumentDto dbperson=bcgserviceobj.uploadFile(file,user);
    	if(dbperson!=null)
    	{
    		return dbperson;
    	}
    	else
    	{
    		throw new InvalidDetailsException("Document Not uploaded");
    	}
    }

	@ExceptionHandler(InvalidDetailsException.class)
	public ResponseEntity<Response> usernotfound1(InvalidDetailsException e)
	{
		return new ResponseEntity<>(new Response(e.getMessage()),HttpStatus.OK);
	}

	
	
	/*checking the status*/
	@GetMapping(value="/ViewStatus/{enter-verfid}")
   	public VerificationDto checkstatus(@PathVariable("enter-verfid") int id) throws InvalidDetailsException
   	{
   	     	return  bcgserviceobj.checkstatus(id);	
   	     	
   	}
	
	
}

