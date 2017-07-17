package cs544.carrental.service;

import java.util.List;

import cs544.carrental.domain.UserCredentials;

public interface UserCredentialsService {

	void save(UserCredentials userCredentials);
	List<UserCredentials> findAll();

}
