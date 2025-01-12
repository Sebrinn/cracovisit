package com.cracovisit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.cracovisit.models.UserModel;

public interface UserServiceInterface extends UserDetailsService{

	public UserModel getByID(long id);
	public Optional<UserModel> getUserByEmail(String email);
	public List<UserModel> getUsers();
	public List<UserModel> searchUsers(String searchTerm);
	public long addUser(UserModel e);
	public boolean deleteUser(long id);
	public UserModel updateUser(UserModel e, long id);
	
	public void init();
	public void destroy();
	
}
