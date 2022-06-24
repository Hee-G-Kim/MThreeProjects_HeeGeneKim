package com.mthree.RestfulWebService3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.RestfulWebService3.User;
import com.mthree.RestfulWebService3.service.IService;

@RestController
public class UserResource {
	@Autowired
	private IService service;
	
	@GetMapping(path="/users")
	public List<User>  retriveAllUsers(){
		System.out.println("Inside RetriveAllUsers methdo of UserResource");
		return service.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User  retrieveUser(@PathVariable(value ="id")int id){
		System.out.println("Inside RetriveUser methdo of UserResource");
		return service.findById(id);
	}
	
	
	//@Valid User user, BindingResult result, Model model
//	@GetMapping(path="/users/{id}")
//	public User  createUser(@PathVariable(value ="id")int id){
//		System.out.println("Inside RetriveUser methdo of UserResource");
//		return service.findById(id);
//	}
	
	@DeleteMapping(path="/users/{id}")
	public User removeUser(int id) {
		System.out.println("Inside removeUser methdod of UserResource");
		return service.deleteById(id);
	}
	
	@PutMapping(path="/users/{id}")
	public User  updateUser(@PathVariable(value ="id")int id, User user){
		System.out.println("Inside updateUser method of UserResource");
		return service.updateUser(user, id);
	}
}
