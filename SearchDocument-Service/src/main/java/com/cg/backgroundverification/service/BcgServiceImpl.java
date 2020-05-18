package com.cg.backgroundverification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.backgroundverification.dao.BcgDaoRepository;
import com.cg.backgroundverification.entity.EmployeeDocumentDto;


@Service
public class BcgServiceImpl implements BcgService {

	@Autowired
	BcgDaoRepository  bcgdao;
	
	
	
	@Override
	public EmployeeDocumentDto getById(int id) 
	{
		EmployeeDocumentDto list =bcgdao.getById(id);
		return list;
	}
	
	@Override
	public EmployeeDocumentDto getByName(String name)
	{
		return  bcgdao.getByName(name);
	}

	
	}
