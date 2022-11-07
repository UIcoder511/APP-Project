package com.org.concordia.photoapi.service;

public interface UsersService {
	
	public int getUserIdByUsername(String username);
	public String getPasswordByUsername(String username);
	public boolean addUser(String username, String password);

}
