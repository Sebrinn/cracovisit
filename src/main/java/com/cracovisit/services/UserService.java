package com.cracovisit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cracovisit.data.DataAccessInterface;

import com.cracovisit.models.UserModel;

public class UserService implements UserServiceInterface {
	
	@Autowired
	private DataAccessInterface<UserModel, String> userDao;

	@Override
	public UserModel getByID(long id) {

		return userDao.getByID(id);
	}


	@Override
	public List<UserModel> getUsers() {

		return userDao.getAll();
	}

	@Override
	public List<UserModel> searchUsers(String searchTerm) {
		
		return userDao.search(searchTerm);
	}

	@Override
	public long addUser(UserModel e) {
		
		Optional<UserModel> user = userDao.getByUniqueValue(e.getUserEmail());
		if(user.isPresent())
		{
			return -1;
		}
		return userDao.addNew(e);
	}

	@Override
	public boolean deleteUser(long id) {
		
		return userDao.deleteByID(id);
	}

	@Override
	public UserModel updateUser(UserModel e, long id) {

		return userDao.updateByID(e, id);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<UserModel> user = userDao.getByUniqueValue(email);
		if(user.isPresent())
		{
			var userObj = user.get();
			return User.builder()
					.username(userObj.getUserEmail())
					.password(userObj.getUserPassword())
					.build();
		}
		else {
			throw new UsernameNotFoundException(email);
		}
	}


	@Override
	public Optional<UserModel> getUserByEmail(String email) {

		return userDao.getByUniqueValue(email);
	}

}
