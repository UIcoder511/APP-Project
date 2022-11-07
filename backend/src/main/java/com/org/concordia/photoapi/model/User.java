package com.org.concordia.photoapi.model;

import java.util.ArrayList;

public class User {

	private int userId;
	private String username;
	private String password;
	private ArrayList<Integer> favourite;
	private ArrayList<Integer> like;

	public User(int userId, String username, ArrayList<Integer> favourite,ArrayList<Integer> like) {
		this.userId = userId;
		this.username = username;
		this.favourite=favourite;
		this.like=like;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public int getUserId() {
		return userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ArrayList<Integer> getFavourite() {
		return favourite;
	}

	public void setFavourite(ArrayList<Integer> favourite) {
		this.favourite = favourite;
	}

	public ArrayList<Integer> getLike() {
		return like;
	}

	public void setLike(ArrayList<Integer> like) {
		this.like = like;
	}


}
