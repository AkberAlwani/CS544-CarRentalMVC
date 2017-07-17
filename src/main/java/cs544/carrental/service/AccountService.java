package cs544.carrental.service;

import cs544.carrental.domain.Account;

public interface AccountService {
	
	public void save(Account account);
	public void update(Account account);
	public void delete(long accountId);
	public Account findByUsername(String username);
	public String MD5(String md5);
	
}
