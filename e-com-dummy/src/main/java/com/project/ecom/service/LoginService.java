package com.project.ecom.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace.Response;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.project.ecom.pojo.User;
import com.project.ecom.repository.LoginMongoRepository;

@Service
public class LoginService {
	
	@Autowired
	LoginMongoRepository loginRepository;
	
	public LoginService(LoginMongoRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;
	}

	public boolean insertUser(@Valid User user) {
		if(findByUserId(user.getEmail()) == null) {
			loginRepository.save(user);
			return true;
		}
		return false;
	}

	public boolean updateUser(@Valid User user) {
		if(findByUserId(user.getEmail()) != null) {
			loginRepository.save(user);
			return true;
		}
		return false;
	}

	public User findByUserId(String userid) {
		// TODO Auto-generated method stub
		Optional<User> user = loginRepository.findById(userid);
		if(user.isPresent())return user.get();
		else return null;
	}

	public boolean removeUser(String userid) {
		loginRepository.deleteById(userid);
		if(findByUserId(userid) == null)return true;
		return false;
	}
	
}
