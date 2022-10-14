package com.example.ShoppingCartRegister.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ShoppingCartRegister.entity.User;



@Repository
public interface UserRepo extends JpaRepository<User, String>{
	
	@Query("select c from Customer c where c.username=:username")
    public List<User> getAllCustomersBasedOnUsername(String username);

}