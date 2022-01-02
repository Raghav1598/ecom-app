package com.project.ecom.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecom.error.ErrorMessage;
import com.project.ecom.pojo.User;
import com.project.ecom.service.LoginService;

@RestController
@RequestMapping("/signup")
@CrossOrigin(origins="http://localhost:3000")
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("")
	public ResponseEntity<ErrorMessage> addUser(@Valid @RequestBody User user) {
		if(loginService.insertUser(user)) {
			logger.debug("Added user : " + user.toString());
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.badRequest().body(new ErrorMessage("The email id is already present. Try logging in."));
	}
	
//	@PutMapping("/{userid}")
//	public ResponseEntity<ErrorMessage> updateUser(@RequestBody @Valid User user, @PathVariable String userid) {
//		if(loginService.updateUser(user)) {
//			logger.debug("Updated user : " + user.toString());
//			return ResponseEntity.noContent().build();
//		}
//		return ResponseEntity.badRequest().body(new ErrorMessage("The requested user details are not present."));
//	}
	
	@GetMapping("/{userid}")
	public ResponseEntity<Object> getUser(@PathVariable String userid) {
		
		@Valid
		User user = loginService.findByUserId(userid);
		
		if(user==null) {
			return ResponseEntity.badRequest().body(new ErrorMessage("The requested user is not present."));
		}
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/{userid}")
	public ResponseEntity<ErrorMessage> deleteUser(@PathVariable String userid) {
		if(loginService.removeUser(userid)) {
			return ResponseEntity.noContent().build();
		}else return ResponseEntity.badRequest().body(new ErrorMessage("The requested user is not present."));
	}
	
//	@PutMapping("")
//	public ResponseEntity<ErrorMessage> changePassword(@RequestParam String userid,@RequestParam String password) {
//		
//		@Valid
//		User user = loginService.findByUserId(userid);
//		
//		if(user==null) {
//			return ResponseEntity.badRequest().body(new ErrorMessage("The requested user is not present."));
//		}
//		user.setPassword(password);
//		loginService.updateUser(user);
//		return ResponseEntity.noContent().build();
//	}
	
}
