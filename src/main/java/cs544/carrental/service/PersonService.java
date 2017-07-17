package cs544.carrental.service;

import java.util.List;

import cs544.carrental.domain.Account;
import cs544.carrental.domain.Person;


public interface PersonService {
	
	List<Person> findAll();
	
	void save(Person person);
	void delete(long id);
	void update(Person person);
	
	Person findOne(long id);
	Person findByIdentificationNumber(String identificationNo);
	Person getLoggedInPersonByAccount(Account account);
	Person findByUsername(String userName);
	
}
