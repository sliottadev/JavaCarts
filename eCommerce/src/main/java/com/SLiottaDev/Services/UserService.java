package com.SLiottaDev.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SLiottaDev.DTOs.UserLoginDTO;
import com.SLiottaDev.Models.User;
import com.SLiottaDev.Repositories.IUserRepository;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private IUserRepository userRepository;

	public UserService() {
//		userRepository =  new UserRepository();
	}

	@Override
	public User Add(User user) {

		if (user != null) {
			userRepository.Add(user);
		}
		return user;

	}

	@Override
	public User Modify(User user, Long id) {

		if ((user != null) && (userRepository.UserExists(id))) {
			userRepository.Modify(user, id);
		}
		return user;
	}

	@Override
	public User Delete(Long id) {

		if (userRepository.UserExists(id)) {
			return userRepository.Delete(id);
		} else 
		{
			return null;
		}

	}

	@Override
	public User GetUserById(Long id) {

		return userRepository.GetUserById(id);

	}

	@Override
	public Long UserLogin(UserLoginDTO usrLogin) {
		return userRepository.UserLogin(usrLogin);
	}

}
