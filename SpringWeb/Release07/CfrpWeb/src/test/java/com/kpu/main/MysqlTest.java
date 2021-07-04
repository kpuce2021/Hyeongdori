package com.kpu.main;


import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MysqlTest {
	@Inject
	private DataSource dataSource;
	
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testConnection() throws Exception{
		try(Connection con = dataSource.getConnection()){
			System.out.println(con);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFactory() throws Exception{
		try(SqlSession session = sqlFactory.openSession()){
			System.out.println(session);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
