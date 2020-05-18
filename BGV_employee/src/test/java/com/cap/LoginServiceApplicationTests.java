package com.cap;

import org.junit.runner.RunWith;
//import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.backgroundverification.BackgroundVerificationEmployeeApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= BackgroundVerificationEmployeeApplication.class)
public class LoginServiceApplicationTests {

}/*@Autowired
    LoginServiceImpl service;
	
	EmployeeServiceImpl service1;
	@MockBean
	 LoginDaoRepository repository;*/
	// statusDao repository1;
	
	
	/*@Test
	public void getUsersTest() {
		
		//when(repository.findAll()).thenReturn(Value);
		LoginDto log=new LoginDto(51678, "pradhan");
		Mockito.when(repository.authentication(51678, "pradhan")).thenReturn(log);
		
		assertEquals(log,repository.authentication(51678, "pradhan"));
		
	}
	
	@Test
	public void getUsersTest1() {
		
		//when(repository.findAll()).thenReturn(Value);
		LoginDto log=new LoginDto(51678, "pradhan");
		Mockito.when(repository.authentication(51677, "pradhan")).thenReturn(log);
		
		assertNotEquals(log,repository.authentication(51677, "pradhann"));
		
	}
	
	@Test
	 public void statustest() throws Exception
	 {

		RestTemplate restTemplate = new RestTemplate();
	    int verfId=328;
	    final String baseUrl = "http://localhost:" + 1001 + "/emp/checkStatus/"+verfId;;
	    URI uri = new URI(baseUrl);
      
	    ResponseEntity<VerificationDto> result = restTemplate.getForEntity(uri, VerificationDto.class);
	    VerificationDto login=result.getBody();
	    System.out.println(login);
	    Assert.assertNotEquals(200, result.getStatusCodeValue());
	    System.out.println(result);
	      
	 }

}
*/