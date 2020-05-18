package com.cg.backgroundverification;

import java.net.URI;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import com.cg.backgroundverification.entity.LoginDto;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=BackGroundVerifierServiceApplication.class)
public class BackGroundVerifierServiceApplicationTests
{
		@Test
	 public void LoginTest1() throws Exception
	 {

			 RestTemplate restTemplate = new RestTemplate();
			    int empId=51678;
			    String password="nikhil";
			    int roleId=18018;
			    final String baseUrl = "http://localhost:" + 8017 + "/BackGroundVerification/Login/"+empId+"/"+password+"/"+roleId;
			    URI uri = new URI(baseUrl);
	          
			    ResponseEntity<LoginDto> result = restTemplate.getForEntity(uri, LoginDto.class);
			  		    Assert.assertEquals(200, result.getStatusCodeValue());
		   
	 }
     
	
	@Test
	 public void LoginTest2() throws Exception
	 {


		    RestTemplate restTemplate = new RestTemplate();
		    int empId=51678;
		    String password="nikhil";
		    int roleId=18018;
		    final String baseUrl = "http://localhost:" + 8017 + "/BackGroundVerification/Login/"+empId+"/"+password+"/"+roleId;
		    URI uri = new URI(baseUrl);
          
		    ResponseEntity<LoginDto> result = restTemplate.getForEntity(uri, LoginDto.class);
		    LoginDto login=result.getBody();
		    System.out.println(login);
		    Assert.assertNotEquals(400, result.getStatusCodeValue());
		    System.out.println(result);
		   // System.out.println(result.getBody());
		    //Assert.assertEquals(false, result.getBody().contains("BackgroundVerifierLogin/"+empId+"/"+password));
		}
	
	
	
}