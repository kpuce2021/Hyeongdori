package com.kpu.dao;

import java.util.List;

import com.kpu.domain.UserVO;

public interface UserDAO {
	public void add(UserVO vo) throws Exception;
	public List<UserVO> readList() throws Exception;
	public UserVO read(String id) throws Exception;
	public void delete(String id) throws Exception;
	public void update(UserVO vo) throws Exception;
	public UserVO login(UserVO vo) throws Exception;
}
