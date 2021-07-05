package com.kpu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpu.dao.UserDAO;
import com.kpu.domain.UserVO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserVO readUser(String id) throws Exception {
		
		return userDAO.read(id);
	}

	@Override
	public List<UserVO> readUserList() throws Exception {
		
		return userDAO.readList();
	}

	@Override
	public void addUser(UserVO vo) throws Exception {
		userDAO.add(vo);
	}

	@Override
	public void deleteUser(String id) throws Exception {
		userDAO.delete(id);
	}

	@Override
	public void updateUser(UserVO vo) throws Exception {
		userDAO.update(vo);
	}

}
