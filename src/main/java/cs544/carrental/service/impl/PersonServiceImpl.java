package cs544.carrental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonServiceImpl implements PersonService{

	@Autowired 
	PersonDao personDAO;
	@Override
	public void save(Person person) {
		// TODO Auto-generated method stub
		personDAO.save(person);
	}

	@Override
	public List<Person> getAll() {
		// TODO Auto-generated method stub
		return personDAO.findAll();
	}

	@Override
	public void delete(Person person) {
		// TODO Auto-generated method stub
		personDAO.delete(person);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		personDAO.delete(id);
	}

	@Override
	public Person findById(int id) {
		// TODO Auto-generated method stub
		return personDAO.findOne(id);
	}

}
