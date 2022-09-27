package com.springboot.service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.dao.RoleDao;
import com.springboot.dao.UserDao;
import com.springboot.entity.Role;
import com.springboot.entity.User;

@Service

public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private PasswordEncoder passwordEncoder;


	public User registerNewUser(User user) {
		Role role = roleDao.findById("User").get();
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(role);
		user.setRole(userRoles);
		user.setUserPassword(getEncodedPassword(user.getUserPassword()));

		return userDao.save(user);
	}

	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}



	public List<User> getAllUsers() {
		List<User> studentList=this.userDao.findAll();
		return studentList;
	}
	
	public User updateUser(User user ) {
		User update=this.userDao.findById(user.getUserMailId()).orElse(null);
		update.setUserName(user.getUserName());
		update.setUserCity(user.getUserCity());
		update.setUserContry(user.getUserContry());
		update.setUserDistrict(user.getUserDistrict());
		update.setUserMobNo(user.getUserMobNo());
		update.setUserPanCardNo(user.getUserPanCardNo());
		update.setUserPassword(user.getUserPassword());
		update.setUserStatus(user.getUserStatus());
		update.setUserState(user.getUserState());
		update.setUserAadharCardNo(user.getUserAadharCardNo());
		update.setUserType(user.getUserType());
		update.setUserPassword(user.getUserConfirmPassword());
		userDao.save(update);
		return update ;
	}
	public User getUserByEmailId(String userMailid) {
		User userFound=this.userDao.findById(userMailid).orElse(null);
		return userFound;
	}

	public User getUserByName(String userName) {
		User foundUser=this.userDao.findById(userName).orElse(null);
		return foundUser;
	}

	public User getUserByMobNo(String userMobNo) {
		User foundUser=this.userDao.findById(userMobNo).orElse(null);
		return foundUser;
	}
}