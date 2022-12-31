package com.SoloProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SoloProject.model.User;
/**
 * UserRepository contains CRUD functions linked to the database
 * 
 * @author Power.Tam
 * @version 2.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{



	User findByUsernameAndPassword(String username, String password);

	User findByUsername(String username);

}
