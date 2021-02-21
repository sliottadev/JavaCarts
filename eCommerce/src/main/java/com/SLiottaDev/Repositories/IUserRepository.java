package com.SLiottaDev.Repositories;

import com.SLiottaDev.DTOs.UserLoginDTO;
import com.SLiottaDev.Models.User;

public interface IUserRepository {
	
	public User Add (User user);

	public User Modify (User user, Long id);
	
	public User Delete (Long id);
	
	public User GetUserById(Long id);
	
	public Boolean UserExists (Long id);
	
	public Long UserLogin (UserLoginDTO usrLogin);

}
