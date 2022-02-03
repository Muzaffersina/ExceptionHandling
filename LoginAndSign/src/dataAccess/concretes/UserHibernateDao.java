package dataAccess.concretes;

import java.util.ArrayList;

import dataAccess.abstracts.UserDao;
import entities.concrete.User;


public class UserHibernateDao implements UserDao{

	ArrayList<User> userList = new ArrayList<User>();
	
	@Override
	public void add(User entity) {
		userList.add(entity);
		System.out.println("Kullanýcý Hibernate ile sisteme eklendi.");	
		
	}

	@Override
	public void update(User entity) {
		
		System.out.println("Kullanýcý Hibernate sisteminde güncellendi.");	
		
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<User> getAll() {
		
		return this.userList;
	}

}