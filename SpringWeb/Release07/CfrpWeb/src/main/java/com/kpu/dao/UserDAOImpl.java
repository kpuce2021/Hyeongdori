package com.kpu.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kpu.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.kpu.mapper.UserMapper";
	
	@Override
	public void add(UserVO vo) throws Exception {
		sqlSession.insert(namespace+".insert", vo);
	}

	@Override
	public List<UserVO> readList() throws Exception {
		List<UserVO> userList = new ArrayList<UserVO>();
		userList = sqlSession.selectList(namespace+".selectAll");
		return userList;
	}

	@Override
	public UserVO read(String id) throws Exception {
		UserVO vo = sqlSession.selectOne(namespace+".selectByid", id);
		
		return vo;
	}

	@Override
	public void delete(String id) throws Exception {
		sqlSession.delete(namespace+".delete", id);
	}

	@Override
	public void update(UserVO vo) throws Exception {
		sqlSession.update(namespace+".update", vo);
	}

	@Override
	public UserVO login(UserVO vo) throws Exception {
		return sqlSession.selectOne(namespace+".login", vo);
	}
	
	
	
}
