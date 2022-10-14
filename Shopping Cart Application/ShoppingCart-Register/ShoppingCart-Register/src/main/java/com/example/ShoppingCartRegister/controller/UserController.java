package com.example.ShoppingCartRegister.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ShoppingCartRegister.entity.User;
import com.example.ShoppingCartRegister.repo.UserRepo;

@RestController
@RequestMapping("/customer")
public class UserController {

	@Autowired
	UserRepo customerRepo;

	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getCustomer() {
		return new ResponseEntity<List<User>>(customerRepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/get/{username}")
	public ResponseEntity<List<User>> getEmployees(@PathVariable String username) {
		return new ResponseEntity<List<User>>(customerRepo.getAllCustomersBasedOnUsername(username), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<User> addEmployee(@RequestBody User customer) {
		return new ResponseEntity<User>(customerRepo.save(customer), HttpStatus.OK);
	}

}
