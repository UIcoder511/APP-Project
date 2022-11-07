package com.org.concordia.photoapi.dao;

public interface UserDao {
	public int getUserIdByUsername(String username);
	public String getPasswordByUsername(String username);
	public boolean addUser(String username, String password);
}
