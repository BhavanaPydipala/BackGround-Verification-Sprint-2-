package com.cg.backgroundverification;

import java.net.URI;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.cg.backgroundverification.entity.VerificationDto;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=BackGroundVerifierServiceApplication.class)
public class BackGroundVerifierServiceApplicationTests
{
		@SuppressWarnings("unused")
	@Test
	 public void setStatusTest2() throws Exception
	 {


      RestTemplate restTemplate = new RestTemplate();
      
	    final String baseUrl = "http://localhost:" + 8015 + "/BackGroundVerification/SetStatus";
	    URI uri = new URI(baseUrl);
		VerificationDto ver=new VerificationDto();		
		ver.setVerfId(364);
		ver.setStatus("accepeted");
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "successful");
		 HttpEntity<VerificationDto> request = new HttpEntity<>(ver, headers);
		 ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.PUT,request,String.class);
		 Assert.assertEquals(200, result.getStatusCodeValue());
	        Assert.assertNotNull(ver);
	 }
			
}