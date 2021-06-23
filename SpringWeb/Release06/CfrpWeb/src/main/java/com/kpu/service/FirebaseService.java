package com.kpu.service;

import com.kpu.domain.UserVO;

public interface FirebaseService {
	//public void initFbase() throws Exception;
	public String insert(UserVO user) throws Exception;
	public UserVO select(String id) throws Exception;
}
