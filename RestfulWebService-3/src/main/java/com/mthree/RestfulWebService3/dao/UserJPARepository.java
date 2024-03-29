package com.mthree.RestfulWebService3.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mthree.RestfulWebService3.User;

//public interface UserJPARepository extends IDAO, JpaRepository<T, ID> {
//
//}

public interface UserJPARepository extends IDAO, JpaRepository<User, Integer> {

	
	
	/*
	 findById : Retrieves one object based on the ID you pass it
	 findAll  :	Retrieves a list of all the objects of the type
		save  :	Used for both creating and updating an object; returns the object that was created or updated as it now exists in the database
	 deleteById : Deletes the object with the passed ID from the database
	 count : Retrieves a count of all objects of a type in the database
	 existsById : Checks if an object with the passed ID exists in the database; returns true or false
	 */

}

