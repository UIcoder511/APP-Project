package com.org.concordia.photoapi.service;

import com.org.concordia.photoapi.dao.UserDao;
import com.org.concordia.photoapi.dao.UsersDaoImpl;

public class UsersServiceImpl implements UsersService{
	
	private UserDao usersDao = new UsersDaoImpl();
	
	@Override
	public int getUserIdByUsername(String username) {
		try {
			return usersDao.getUserIdByUsername(username);
		}
		catch(Exception ex){
			//throw photo-api custom exception here
			//log
		}
		return -1;
	}

	@Override
	public String getPasswordByUsername(String username) {
		try {
			return usersDao.getPasswordByUsername(username);
		}
		catch(Exception ex){
			//throw photo-api custom exception here
			//log
		}
		return null;
	}

	@Override
	public boolean addUser(String username, String password) {
		try {
			return usersDao.addUser(username,password);
		}
		catch(Exception ex){
			//throw photo-api custom exception here
			//log
		}
		
		return false;
	}
}
