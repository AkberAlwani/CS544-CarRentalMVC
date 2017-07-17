package cs544.carrental.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import cs544.carrental.domain.Member;
import cs544.carrental.domain.Product;

@Component
public interface MemberRestService {

 	public List<Member> findAll();

	public Member findOne(Long index);

	public Member save(Member member);

}
