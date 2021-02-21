package com.SLiottaDev.Services;

import com.SLiottaDev.DTOs.UserLoginDTO;
import com.SLiottaDev.Models.User;

public interface IUserService {
	
	public User Add(User user);
	
	public User Modify (User user, Long id);
	
	public User Delete (Long id);
	
	public User GetUserById(Long id);
	
	public Long UserLogin(UserLoginDTO usrLogin);
	
}
