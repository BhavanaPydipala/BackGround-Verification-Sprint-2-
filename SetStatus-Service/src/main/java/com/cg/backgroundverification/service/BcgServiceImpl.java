package com.cg.backgroundverification.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.backgroundverification.dao.BcgStatusRepository;
import com.cg.backgroundverification.entity.VerificationDto;


@Service
public class BcgServiceImpl implements BcgService {

	@Autowired
	BcgStatusRepository bcgstatusdao;

	
		@Override
	public VerificationDto setstatus(VerificationDto verification) 
	{
		long millis=System.currentTimeMillis();  
		Date enddate=new Date(millis); 
		VerificationDto verobj = bcgstatusdao.findOne(verification.getVerfId());
		if(verobj==null)
		{
			return verobj;
		}
		else 
        {
		verobj.setEndDate(enddate);
		verobj.setStatus(verification.getStatus());
		bcgstatusdao.save(verobj);
        return verobj;
        }
	}
}
