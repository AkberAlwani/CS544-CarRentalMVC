package cs544.carrental.dao;


import cs544.carrental.domain.Account;
import cs544.carrental.domain.AccountType;

public interface AccountDao extends GenericDao<Account> {

	public abstract Account findByUsername(String username);
	
//	@Modifying
//	@Query("update Account a set a.username = ?1, a.password = ?2, a.active = ?3, a.accountType = ?4  where accountId =?5")
	void setAccountByAccountId(String username, String password, Boolean active, AccountType accountType, Integer accountId);
	 
}
