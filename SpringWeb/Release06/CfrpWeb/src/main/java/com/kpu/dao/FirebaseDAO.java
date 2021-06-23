package com.kpu.dao;

import com.kpu.domain.UserVO;

public interface FirebaseDAO {
	//public void initialize() throws Exception;
	public String insertUser(UserVO user) throws Exception;
	public UserVO selectUser(String id) throws Exception;
}
