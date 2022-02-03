package business.concretes;

import java.util.ArrayList;

import business.abstracts.UserService;
import core.exceptions.BusinessException;
import dataAccess.abstracts.UserDao;
import entities.concrete.User;

public class UserManager implements UserService {
	
	
	private UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void add(User users) throws BusinessException  {
		if(checkEmail(users) && checkPassword(users) && checkName(users) && checkOverlapMail(users)) {			
			this.userDao.add(users);
		}			
	}		

	@Override
	public void update(User users) throws BusinessException {
		if(checkEmail(users) && checkPassword(users) && checkName(users) && checkOverlapMail(users)) {			
			this.userDao.update(users);
		}

	}

	@Override
	public void delete(User users)  {
		// TODO Auto-generated method stub

	}
	@Override
	public ArrayList<User> getAll() {
		
		return this.userDao.getAll();
	}
	
	private boolean checkEmail(User users) throws BusinessException {
		if (!users.geteMail().contains("@")) {
			throw new BusinessException("Mail @ içermek zorundadýr");
		} 
		return true;		
	}
	private boolean checkPassword(User users) throws BusinessException {
		if (users.getPassword().length() < 6) {
			throw new BusinessException("Paralo 6 karakterden kýsa olamaz.");
		}
		return true;		
	}
	private boolean checkName(User users) throws BusinessException {
		if (users.getFirstName().length() < 2 || users.getLastName().length() < 2) {
			throw new BusinessException(users.getFirstName()+" "+users.getLastName()+", isim/soyisim 2 karakterden kýsa olamaz.");
		}
		return true;		
	}
	private boolean checkOverlapMail(User users) throws BusinessException {
		for (int i = 0; i < getAll().size(); i++) {
			if (users.geteMail() == getAll().get(i).geteMail()) {
				throw new BusinessException(users.geteMail()+", bu e-mail daha önce kullanýlmýþtýr.");
			}
		}			
		return true;		
	}
}

	