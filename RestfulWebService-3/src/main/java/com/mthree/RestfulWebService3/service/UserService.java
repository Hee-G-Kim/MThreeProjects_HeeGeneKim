package com.mthree.RestfulWebService3.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mthree.RestfulWebService3.User;
import com.mthree.RestfulWebService3.dao.IDAO;


@Service
public class UserService implements IService {

	@Autowired
	private IDAO dao;
	
	
	public UserService() {
		super();
		System.out.println("In side default constructor of UserService");
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<User> findAll() {
		System.out.println("In side findAll method of UserService");
		
		return dao.findAll();
	}

	@Override
	public User findById(int id) {
		System.out.println("In side findById method of UserService");
		Optional<User> opt = dao.findById(id); 
		return opt.get();
	}

	@Override
	public User save(User user) {
		System.out.println("In side findById method of UserService");
		return dao.save(user);
	}

	@Override
	public User deleteById(int id) {
		// TODO Auto-generated method stub
		return dao.deleteById(id);
	}

	@Override
	public User updateUser(User user, int id) {
		return dao.updateUser(user, id);
	}
}
