package cs544.carrental.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import cs544.carrental.domain.Account;
import cs544.carrental.domain.Person;

@Component
public interface PersonRestService {

 	public List<Person> findAll();

	Person save(Person person);
	void delete(long id);
	void update(Person person);
	
	Person findOne(long id);
	Person findByIdentificationNumber(String identificationNo);
	Person getLoggedInPersonByAccount(Account account);
	Person findByUsername(String userName);

	public List<Person> read();
	
	


}
