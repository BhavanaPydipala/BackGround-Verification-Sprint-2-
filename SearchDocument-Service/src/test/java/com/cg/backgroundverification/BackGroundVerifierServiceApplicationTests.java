package com.cg.backgroundverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.File;
import java.io.FileInputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.backgroundverification.dao.BcgDaoRepository;
import com.cg.backgroundverification.entity.EmployeeDocumentDto;
import com.cg.backgroundverification.entity.VerificationDto;
import com.cg.backgroundverification.service.BcgService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=BackGroundVerifierServiceApplication.class)
public class BackGroundVerifierServiceApplicationTests
{
	@Autowired
	BcgService bcgservice;
	
    @MockBean
    BcgDaoRepository repository;
    @Test
    public void test1()
    {
    	
    	File file = new File("C:\\Users\\PYDIPALA BHAVANA\\Pictures\\Saved Pictures\\btech-memo.jpg");
    	byte[] imageData = new byte[(int) file.length()];
    	 
    	try {
    	    FileInputStream fileInputStream = new FileInputStream(file);
    	    fileInputStream.read(imageData);
    	    fileInputStream.close();
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
 
    	EmployeeDocumentDto obj=new EmployeeDocumentDto();
    	obj.setDocId(270);
    	obj.setDocData(imageData);
    	obj.setDocType("btech-memo.jpg");
    	obj.setEmpId(100);
    	obj.setEmpName("bhanu");
    	VerificationDto verificationdto=new VerificationDto();
    	verificationdto.setVerfId(271);
    	obj.setVerificationdto(verificationdto);
    	Mockito.when(repository.getById(100)).thenReturn(obj);
    	assertEquals(obj,repository.getById(100));
    }
    
    @Test
    public void test2()
    {
    	
    	File file = new File("C:\\Users\\PYDIPALA BHAVANA\\Pictures\\Saved Pictures\\btech-memo.jpg");
    	byte[] imageData = new byte[(int) file.length()];
    	 
    	try {
    	    FileInputStream fileInputStream = new FileInputStream(file);
    	    fileInputStream.read(imageData);
    	    fileInputStream.close();
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
 
    	EmployeeDocumentDto obj=new EmployeeDocumentDto();
    	obj.setDocId(270);
    	obj.setDocData(imageData);
    	obj.setDocType("btech-memo.jpg");
    	obj.setEmpId(100);
    	obj.setEmpName("bhanu");
    	VerificationDto verificationdto=new VerificationDto();
    	verificationdto.setVerfId(271);
    	obj.setVerificationdto(verificationdto);
    	Mockito.when(repository.getById(100)).thenReturn(obj);
    	assertNotEquals(obj,repository.getById(200));
    }
  
    @Test
    public void docbyname()
    {
    	
    	File file = new File("C:\\Users\\PYDIPALA BHAVANA\\Pictures\\Saved Pictures\\btech-memo.jpg");
    	byte[] imageData = new byte[(int) file.length()];
    	 
    	try {
    	    FileInputStream fileInputStream = new FileInputStream(file);
    	    fileInputStream.read(imageData);
    	    fileInputStream.close();
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
 
    	EmployeeDocumentDto obj=new EmployeeDocumentDto();
    	obj.setDocId(270);
    	obj.setDocData(imageData);
    	obj.setDocType("btech-memo.jpg");
    	obj.setEmpId(100);
    	obj.setEmpName("bhanu");
    	VerificationDto verificationdto=new VerificationDto();
    	verificationdto.setVerfId(271);
    	obj.setVerificationdto(verificationdto);
    	Mockito.when(repository.getByName("bhanu")).thenReturn(obj);
    	assertEquals(obj,repository.getByName("bhanu"));
    }
 
    @Test
    public void docbynametest()
    {
    	
    	File file = new File("C:\\Users\\PYDIPALA BHAVANA\\Pictures\\Saved Pictures\\btech-memo.jpg");
    	byte[] imageData = new byte[(int) file.length()];
    	 
    	try {
    	    FileInputStream fileInputStream = new FileInputStream(file);
    	    fileInputStream.read(imageData);
    	    fileInputStream.close();
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
 
    	EmployeeDocumentDto obj=new EmployeeDocumentDto();
    	obj.setDocId(270);
    	obj.setDocData(imageData);
    	obj.setDocType("btech-memo.jpg");
    	obj.setEmpId(100);
    	obj.setEmpName("bhanu");
    	VerificationDto verificationdto=new VerificationDto();
    	verificationdto.setVerfId(271);
    	obj.setVerificationdto(verificationdto);
    	Mockito.when(repository.getByName("bhanu")).thenReturn(obj);
    	assertNotEquals(obj,repository.getByName("anu"));
    }
 

	}




