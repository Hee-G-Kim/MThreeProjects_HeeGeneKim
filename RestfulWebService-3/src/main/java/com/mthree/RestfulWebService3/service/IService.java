package com.mthree.RestfulWebService3.service;

import java.util.List;

import com.mthree.RestfulWebService3.User;

public interface IService {
	
	
	public  List<User> findAll();
	User findById(int id);
	
	public User save(User user);
	
	public User  deleteById(int id);
	
	public User updateUser(User user, int id);
	

}
