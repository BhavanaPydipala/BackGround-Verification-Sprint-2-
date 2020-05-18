package com.cg.backgroundverification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.backgroundverification.entity.VerificationDto;
import com.cg.backgroundverification.exception.InvalidDetailsException;
import com.cg.backgroundverification.service.BcgService;

@RestController
@RequestMapping("/BackGroundVerification")
@CrossOrigin("http://localhost:4200")
public class BackGroundVerifierController
{
    
	
	@Autowired
	BcgService bcgservice;
	
	
			/*setting the status of document */
		@PutMapping(value="/SetStatus")
		public String setstatus(@RequestBody VerificationDto verification) throws InvalidDetailsException
		{
			
			
				VerificationDto result= bcgservice.setstatus(verification);
				if(result!=null)
				{
					String res="sucessful";
					return res;
				}
				else
				{
					throw new InvalidDetailsException("Id does not exist,so we couldn't fetch details");
				}
			
				
			
			}

	
}
