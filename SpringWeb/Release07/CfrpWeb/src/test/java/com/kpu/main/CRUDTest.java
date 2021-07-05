package com.kpu.main;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kpu.dao.UserDAO;
import com.kpu.domain.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CRUDTest {
	@Autowired
	private UserDAO dao;
	
	@Test
	public void testReadByid() throws Exception{
		System.out.println("[[read by id Test]]");
		UserVO vo;
		vo = dao.read("kim1234");
		System.out.println(vo.toString());
	}
	
	@Test
	public void testReadList() throws Exception{
		System.out.println("[[read all Test]]");
		List<UserVO> voList = null;
		voList = dao.readList();
		
		for(UserVO vo : voList) {
			System.out.println(vo.toString());
		}
	}
	
	
	@Test
	public void testAddUser() throws Exception{
		System.out.println("[[add Test]]");
		UserVO uvo = new UserVO();
		uvo.setId("kea7109");
		uvo.setPasswd("jjhh0515");
		uvo.setEmail("kea7109@naver.com");
		uvo.setMobile("010-3623-1762");
		
		try {
			dao.add(uvo);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	@Test
	public void deleteUser() throws Exception{
		System.out.println("[[delete test]]");
		dao.delete("kea7109");
	}
	
}
