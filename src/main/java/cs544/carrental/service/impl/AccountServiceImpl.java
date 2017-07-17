package cs544.carrental.service.impl;

import java.security.NoSuchAlgorithmException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs544.carrental.dao.AccountDao;
import cs544.carrental.domain.Account;

@Service
@Transactional
public class AccountServiceImpl implements cs544.carrental.service.AccountService {

	
 	@Autowired
	private AccountDao accountDao;
 	
	@Override
	public void save(Account account) {
		accountDao.save(account);
	}

	@Override
	public void update(Account account) {
		accountDao.update(account);
	}

	@Override
	public void delete(long AccountId) {
		accountDao.delete(AccountId);

	}

	@Override
	public Account findByUsername(String username) {
		return accountDao.findByUsername(username);
	}

	@Override
	public String MD5(String md5) {
		java.security.MessageDigest md;
        
        try {
            md = java.security.MessageDigest.getInstance("MD5");
            byte[] array=md.digest(md5.getBytes());
            StringBuffer sb=new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                  sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
               }
                return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null; 
	}

}
