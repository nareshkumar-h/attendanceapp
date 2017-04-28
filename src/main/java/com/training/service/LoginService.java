package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.Model.Users;
import com.training.repository.LoginRepository;
@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;

	public List<Users> doGetFindByUserName(String userName) {
		return loginRepository.getFindByUserName(userName);
	}
}
