package cs544.carrental.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import cs544.carrental.domain.UserCredentials;

@Component
public interface UserCredentialsRestService {

 	public List<UserCredentials> findAll();

	public UserCredentials findOne(String index);

	public UserCredentials save(UserCredentials member);

}
