package cs544.carrental.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import cs544.carrental.domain.UserCredentials;
import cs544.carrental.rest.RestHttpHeader;
import cs544.carrental.rest.service.UserCredentialsRestService;

@Component
public class UserCredentialsRestServiceImpl implements UserCredentialsRestService {

	@Autowired
	RestHttpHeader remoteApi;
	
	public List<UserCredentials> findAll() {
		
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		return Arrays.asList(restTemplate.exchange("http://localhost:8080/MemberRest/userCredentials/", HttpMethod.GET, remoteApi.getHttpEntity(), UserCredentials[].class).getBody());
	}

	public UserCredentials findOne(String index) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		UserCredentials uc =  (restTemplate.exchange("http://localhost:8080/MemberRest/userCredentials/"+ index, HttpMethod.GET, remoteApi.getHttpEntity(), UserCredentials.class).getBody());
		return uc;
	}

	public UserCredentials save(UserCredentials product) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<UserCredentials> httpEntity = new HttpEntity<UserCredentials>(product, remoteApi.getHttpHeaders());
		restTemplate.postForObject("http://localhost:8080/MemberRest/userCredentials/", httpEntity, UserCredentials.class);
		return null;
	}

}
