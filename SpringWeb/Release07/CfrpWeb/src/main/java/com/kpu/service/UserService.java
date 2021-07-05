package com.kpu.service;

import java.util.List;

import com.kpu.domain.UserVO;

public interface UserService {
	public UserVO readUser(String id) throws Exception;
	public List<UserVO> readUserList() throws Exception;
	public void addUser(UserVO vo) throws Exception;
	public void deleteUser(String id) throws Exception;
	public void updateUser(UserVO vo) throws Exception;
	public UserVO loginUser(UserVO vo) throws Exception;
}
