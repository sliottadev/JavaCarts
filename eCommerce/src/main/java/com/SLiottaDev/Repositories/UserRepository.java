package com.SLiottaDev.Repositories;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;

import com.SLiottaDev.DTOs.UserLoginDTO;
import com.SLiottaDev.Models.User;

@Repository
public class UserRepository implements IUserRepository{

	private EntityManagerFactory emf;
	private EntityManager manager;

	public UserRepository() {
		this.emf = Persistence.createEntityManagerFactory("Persistencia");
		this.manager = emf.createEntityManager();
	}
	
	@Override
	public User Add(User user) {
		
		try {
			
			this.manager.getTransaction().begin();
			this.manager.merge(user);
			this.manager.getTransaction().commit();
			
		} catch (Exception e) {
			
			System.out.println(e.getStackTrace());
			
		} 
		
		return user;
	}

	@Override
	public User Modify(User user, Long id) {
		
		User usr = new User();
		try {
			
			this.manager.getTransaction().begin();
			usr = this.manager.find(User.class, id);
			usr = user;
			this.manager.getTransaction().commit();
			
		} catch (Exception e) {
			
			System.out.println(e.getStackTrace());
			
		} 
		
		return usr;
	}

	@Override
	public User Delete(Long id) {
		
		User usr = new User();
		try {
			
			this.manager.getTransaction().begin();
			usr = this.manager.find(User.class, id);
			this.manager.remove(usr);
			this.manager.getTransaction().commit();
			
		} catch (Exception e) {
			
			System.out.println(e.getStackTrace());
			
		} 
		
		return usr;
		
	}

	@Override
	public User GetUserById(Long id) {
		
		User usr = new User();
		try {
			
			this.manager.getTransaction().begin();
			usr = this.manager.find(User.class, id);
			this.manager.getTransaction().commit();
			
		} catch (Exception e) {
			
			System.out.println(e.getStackTrace());
			
		} 
		
		return usr;
	}

	@Override
	public Boolean UserExists(Long id) {

		Boolean result = false;
		try {
			
			this.manager.getTransaction().begin();
			if (this.manager.find(User.class, id) != null)
				result = true;
			this.manager.getTransaction().commit();
			
		} catch (Exception e) {
			
			System.out.println(e.getStackTrace());
			
		} 
		
		return result;	
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long UserLogin(UserLoginDTO usrLogin) {
		try {
			
			this.manager.getTransaction().begin();
			String q = "FROM User u WHERE ((u.userName = '"+usrLogin.getUserLogin()+"' OR u.mail = '"+usrLogin.getUserLogin()+"') AND u.password = '"+usrLogin.getPassWord()+"')";
			
			List<User> usrs = this.manager.createQuery(q).getResultList();
			Long id = usrs.get(0).getUserId();
			
			this.manager.getTransaction().commit();
			return id;
			
		} catch (Exception e) {
			
			System.out.println(e.getStackTrace());
			
		}
		
		return null;	
	}

}
