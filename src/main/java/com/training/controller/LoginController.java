package com.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.Model.Users;
import com.training.service.LoginService;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@GetMapping("/logbyname")
	public List<Users> findByUserName(@RequestParam(value = "userName") String userName) {
		return loginService.doGetFindByUserName(userName);
	}

}
