package com.mthree.RestfulWebService3.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.mthree.RestfulWebService3.User;
import com.mthree.RestfulWebService3.Exceptions.UserNotFoundException;


@Repository
public class UserInMemoryRepository implements IDAO {
	
	private static List<User> users = null;
	private static int usercount =3;
	static {
		users = new ArrayList<User>();
		users.add(new User(1, "Bikin", new Date()));
		users.add(new User(2, "jin", new Date()));
		users.add(new User(3, "james", new Date()));
	}
	
	
	
	
	public UserInMemoryRepository() {
		super();
		System.out.println("inside default constructor of Userinmemoryrespositry");
		
	}

	@Override
	public List<User> findAll() {
		//in real dao selct * all
		System.out.println("inside findall method of Userinmemoryrespositr");
		return users;
	}

	@Override
	public Optional<User> findById(int id) {
		
		
		System.out.println("Inside findById of UserInMemoryRepository");
		User user =  users.stream().filter(u -> u.getId() == id).findAny().orElse(null);
		
		if(user == null) {
			throw new UserNotFoundException("No user");
		} else {
			Optional<User> opt = Optional.of(user);
			return opt;
		}

		
//		Optional<User> opt= Optional.ofNullable(user);
//		return opt;
		
		
	}

	@Override
	public User save(User user) {
		System.out.println("inside save method of Userinmemoryrepostiry");
		users.add(new User());
		return user;
	}


	@Override
	public User deleteById(int id) {
		System.out.println("Inside deleteById of UserInMemoryRepository");
		Iterator<User> iter = users.iterator();
		while(iter.hasNext()) {
			User u = iter.next();
			if(u.getId() == id) {
				iter.remove();
				return u;
			}
		}
		return null;
	}

   @Override
	public User updateUser(User user, int id) {
		System.out.println("Inside updateUser of UserInMemoryRepository");
		Iterator<User> iter = users.iterator();
		while(iter.hasNext()) {
			User u = iter.next();
			if(u.getId() == id) {
				iter.remove();
				return u;
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public User updateUser(int id) {
//		System.out.println("Inside deleteById of UserInMemoryRepository");
//		Iterator<User> iter = users.iterator();
//		while(iter.hasNext()) {
//			User u = iter.next();
//			if(u.getId() == id) {
//				iter.remove();
//				return u;
//			}
//		}
//		return null;
//	}
}
