package com.org.concordia.photoapi.gateways;

public interface UserGateway {
	public int getUserIdByUsername(String username);
	public String getPasswordByUsername(String username);
	public boolean addUser(String username, String password);
}
