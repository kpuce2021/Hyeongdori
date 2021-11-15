package com.kpu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

	// REQUIRED : 기존 트랜잭션 존재 시 해당 트랜잭션에 포함되서 실행, 없으면 새로운 트랜잭션 생성
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout=10)
	public void addUser(UserVO vo) throws Exception {
		userDAO.add(vo);
	}

	@Override
	public void deleteUser(String id) throws Exception {
		userDAO.delete(id);
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout=10)
	public void updateUser(UserVO vo) throws Exception {
		userDAO.update(vo);
	}

	// NESTED : 기존 트랜잭션 존재 시 포함되서 실행, 없으면 새로 생성하여 실행
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, readOnly=true)
	public UserVO loginUser(UserVO vo) throws Exception {	
		return userDAO.login(vo);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, readOnly=true)
	public int userIdCheck(UserVO vo) throws Exception {
		int result = userDAO.idChk(vo);
		return result;
	}

}
