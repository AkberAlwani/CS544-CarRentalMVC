package cs544.carrental.service;

import java.util.List;

import cs544.carrental.domain.Person;


public interface PersonService {
	void save(Person person);
	List<Person> getAll();
	void delete(Person person);
	void delete(int id);
	Person findById(int id);
	
}
