package cs544.carrental.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cs544.carrental.domain.Member;
import cs544.carrental.domain.Product;
import cs544.carrental.rest.RestHttpHeader;
import cs544.carrental.rest.service.MemberRestService;

@Component
public class MemberRestServiceImpl implements MemberRestService {

	@Autowired
	RestHttpHeader restHttpHeader;
	
	public List<Member> findAll() {
		
		RestTemplate restTemplate = restHttpHeader.getRestTemplate();
		return Arrays.asList(restTemplate.exchange("http://localhost:8080/MemberRest/members/", HttpMethod.GET, restHttpHeader.getHttpEntity(), Member[].class).getBody());
 	}

	public Member findOne(Long index) {
		RestTemplate restTemplate = restHttpHeader.getRestTemplate();
 		return (restTemplate.exchange("http://localhost:8080/MemberRest/members/"+ index, HttpMethod.GET, restHttpHeader.getHttpEntity(), Member.class).getBody());
	}

	public Member save(Member member) {
		RestTemplate restTemplate = restHttpHeader.getRestTemplate();
		HttpEntity<Member> httpEntity = new HttpEntity<Member>(member, restHttpHeader.getHttpHeaders());
		restTemplate.postForObject("http://localhost:8080/MemberRest/members/add/", httpEntity, Member.class);
		return null;
	}

}
