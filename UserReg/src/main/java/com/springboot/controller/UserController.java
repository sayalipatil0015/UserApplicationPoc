package com.springboot.controller;


import java.util.List;


import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.entity.User;

import com.springboot.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService userService;


	@PostMapping({"/registerNewUser"})
	public User registerNewUser(@Valid @RequestBody User user) {
		return userService.registerNewUser(user);
	}
  
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users=this.userService.getAllUsers();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	@PutMapping("/updateUser/{userMailId}")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user,@PathVariable String userMailId)
	{
		User updateUser=this.userService.updateUser(user);
		return new ResponseEntity<User>(updateUser,HttpStatus.OK);
	}
	
	@GetMapping("/getUserByEmailId/{userMailId}")
	public ResponseEntity<User> getUserByEmailId(@PathVariable(name="userMailId") String userMailId){
		User user=this.userService.getUserByEmailId(userMailId);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping("/getUserByName/{userName}")
	public ResponseEntity<User> getUserByName(@PathVariable(name="userName") String userName){
		User userinfo=this.userService.getUserByName(userName);
		return new ResponseEntity<User>(userinfo,HttpStatus.OK);
	}
	
	@GetMapping("/getUserByMobNo/{userMobNo}")
	public ResponseEntity<User> getUserMobNo(@PathVariable(name="userMobNo") String userMobNo){
		User userdata=this.userService.getUserByName(userMobNo);
		return new ResponseEntity<User>(userdata,HttpStatus.OK);
	}


	@GetMapping({"/forAdmin"})
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin(){
		return "This URL is only accessible to the admin";
	}

	@GetMapping({"/forUser"})
	@PreAuthorize("hasRole('User')")
	public String forUser(){
		return "This URL is only accessible to the user";
	}
}