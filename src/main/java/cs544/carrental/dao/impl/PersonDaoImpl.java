package cs544.carrental.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cs544.carrental.dao.PersonDao;
import cs544.carrental.domain.Account;
import cs544.carrental.domain.Person;

@SuppressWarnings("unchecked")
@Repository
public class PersonDaoImpl extends GenericDaoImpl<Person> implements PersonDao {
	
	public PersonDaoImpl() {
		super.setDaoType(Person.class );
	}
	
	@Override
	public List<Person> findByNameIgnoringCase(String name) {
		Query query = entityManager.createQuery("select p from Person p  where p.name =:name");
		return query.setParameter("name", name).getResultList();
	}

	@Override
	public Person findByIdentificationNumber(String identificationNumber) {
		Query query = entityManager.createQuery("select p from Person p  where p.identificationNumber =:identificationNumber");
		return (Person) query.setParameter("identificationNumber", identificationNumber).getSingleResult();
	}

	@Override
	public Person findByName(String name) {
		Query query = entityManager.createQuery("select p from Person p  where where p.name =:name");
		return (Person) query.setParameter("name", name).getSingleResult();
	}

	@Override
	public Person findByAccount(Account account) {
		Query query = entityManager.createQuery("select p from Person p  where where p.Account =:account");
		return (Person) query.setParameter("account", account).getSingleResult();
	}

	@Override
	public Person getLoggedInPersonByAccount(Account account) {
		Query query = entityManager.createQuery("select p from Person p  where where p.Account =:account");
		return (Person) query.setParameter("account", account).getSingleResult();
	}

	

	@Override
	public Person getLoggedInPersonByName(String name) {
		Query query = entityManager.createQuery("select p from Person p  where where p.name =:name");
		return (Person) query.setParameter("name", name).getSingleResult();
	}

	@Override
	public Person findByUsername(String userName) {
		Query query = entityManager.createQuery("select p from Person p  where where p.username =:userName");
		return (Person) query.setParameter("userName", userName).getSingleResult();
	}

}
