package cs544.carrental.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import cs544.carrental.domain.Account;
import cs544.carrental.domain.Person;
import cs544.carrental.rest.RestHttpHeader;
import cs544.carrental.rest.service.PersonRestService;

@Component("MVC")
public class PersonRestServiceImpl  implements PersonRestService {

	@Autowired
	RestHttpHeader remoteApi;
	
	public List<Person> findAll() {
		
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		List<Person> personList = Arrays.asList(restTemplate.exchange("http://localhost:8080/PersonRest/persons/", 
				HttpMethod.GET, remoteApi.getHttpEntity(), Person[].class).getBody());
                               //remoteApi.getHttpEntity() - get HTTP headers [Authentication; JSON ACCEPT]
		return personList;
	}

	public Person findOne(Long index) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
 		return (restTemplate.exchange("http://localhost:8080/PersonRest/persons/"+ index, 
 				HttpMethod.GET, remoteApi.getHttpEntity(), Person.class).getBody());
                                                           // Returns Product in Body HTTP Message 
	}
	
	public Person getWithCategory(Long productId) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
 		return (restTemplate.exchange("http://localhost:8080/PersonRest/persons/withCategory/"+ productId, 
 				HttpMethod.GET, remoteApi.getHttpEntity(), Person.class).getBody());
                                                           // Returns Product in Body HTTP Message 
	
	}


	public Person save(Person person) {
		try {

		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<Person> httpEntity = new HttpEntity<Person>(person, remoteApi.getHttpHeaders());
		restTemplate.postForObject("http://localhost:8080/PersonRest/person/add/", 
				        httpEntity, Person.class);
                                     // Product.class - Response type
 		}
		catch (RestClientException exce) {
			System.out.println("ERROR: " + exce.getMessage());
		}
		return null;
	}

	

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person findByIdentificationNumber(String identificationNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person getLoggedInPersonByAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person findByUsername(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> read() {
		return findAll();
	}

}
