package cs544.carrental.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cs544.carrental.dao.AccountDao;
import cs544.carrental.domain.Account;
import cs544.carrental.domain.AccountType;

@Repository
public class AccountDaoImpl extends GenericDaoImpl<Account> implements AccountDao{

	
	public AccountDaoImpl() {
		super.setDaoType(Account.class );
	}
	
	@Override
	public Account findByUsername(String username) {
		Query query = entityManager.createQuery("select a from Account a  where a.username =:username");
		return (Account) query.setParameter("number", username).getSingleResult();
	}

	@Override
	public void setAccountByAccountId(String username, String password, Boolean active, AccountType accountType,
			Integer accountId) {
//		@Query("update Account a set a.username = ?1, a.password = ?2, a.active = ?3, a.accountType = ?4  where accountId =?5")
		Query query = entityManager.createQuery("update Account a set a.username = ?1, a.password = ?2, a.active = ?3, a.accountType = ?4  where accountId =?5");
		query.setParameter(1, username);
		query.setParameter(2,password);
		query.setParameter(3, active);
		query.setParameter(4, accountType);
		query.setParameter(5, accountId);
	}

	
}
