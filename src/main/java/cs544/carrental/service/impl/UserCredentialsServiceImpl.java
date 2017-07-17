package cs544.carrental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs544.carrental.domain.UserCredentials;
import cs544.carrental.rest.service.UserCredentialsRestService;

@Service
public class UserCredentialsServiceImpl implements cs544.carrental.service.UserCredentialsService {
	
 	@Autowired
	private UserCredentialsRestService userCredentialsRestService;

 	
    public void save( UserCredentials userCredentials) {  		
 		userCredentialsRestService.save(userCredentials);
	}
 	
   	
	public List<UserCredentials> findAll() {
		return (List<UserCredentials>)userCredentialsRestService.findAll();
	}
	
	public UserCredentials findOne(String id){
		return userCredentialsRestService.findOne(id);
	}

 

 
 
}
