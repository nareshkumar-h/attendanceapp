package com.training.repository;

import java.util.List;

import com.training.Model.Users;

public interface LoginRepository {

	List<Users> getFindByUserName(String userName);

}
