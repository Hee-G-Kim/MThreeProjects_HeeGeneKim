package com.mthree.RestfulWebService3.dao;

import java.util.List;
import java.util.Optional;

import com.mthree.RestfulWebService3.User;

public interface IDAO {

	
	public List<User> findAll();
	Optional<User> findById(int id);
	public User save(User user);
	public User deleteById(int id);
	public User updateUser(User user, int id);
	
	
}
