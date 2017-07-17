package cs544.carrental.main;

 import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cs544.carrental.domain.Person;
import cs544.carrental.rest.RestHttpHeader;
import cs544.carrental.rest.service.PersonRestService;


@Component
public class RestClient
{
	@Autowired
	RestHttpHeader remoteApi;

	@Autowired
	PersonRestService personService;
	

	public static void main(String[] args)
	{
 	    final ApplicationContext applicationContext =
	            new ClassPathXmlApplicationContext("context/applicationContext.xml");
 	 
		applicationContext.getBean(RestClient.class).mainInternal(applicationContext);
	      }
	
	        private void mainInternal(ApplicationContext applicationContext) {
 
	  	   		Person person= personService.findOne(1L);
	   	   		System.out.println();
	  	   		System.out.println("single Product " + person.getName()); 
	  	   		System.out.println(); 


  	   		List<Person> persons= personService.read();
 	        for (Person personTemp : persons) {
	    		System.out.println("Product " + personTemp.getName());
//	    		for (Category category : personTemp.getCategories()) {
//		    		System.out.println("       Category " + category.getName());
//
//	    		}
	        }
  	   		System.out.println(); 
	        
  	   		
  		    
  		    
	}
}
