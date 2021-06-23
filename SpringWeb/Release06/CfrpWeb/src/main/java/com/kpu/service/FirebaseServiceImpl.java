package com.kpu.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpu.dao.FirebaseDAO;
import com.kpu.domain.UserVO;

@Service
public class FirebaseServiceImpl implements FirebaseService {
	@Autowired
	private FirebaseDAO fBaseDAO;
	/*
	@PostConstruct
	public void initFbase() throws Exception{
		fBaseDAO.initialize();
	}
	*/
	
	public String insert(UserVO user) throws Exception{
		return fBaseDAO.insertUser(user);
	}
	public UserVO select(String id) throws Exception{
		return fBaseDAO.selectUser(id);
	}
}
