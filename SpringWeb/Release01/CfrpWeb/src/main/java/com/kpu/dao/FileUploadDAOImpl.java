package com.kpu.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileUploadDAOImpl implements FileUploadDAO {
	@Autowired
	private SqlSession query;
	
	public void saveImage(Map<String, Object> hmap) throws SQLException{
		query.insert("query.saveImage", hmap);
	}
}
