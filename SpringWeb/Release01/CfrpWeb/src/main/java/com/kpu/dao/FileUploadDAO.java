package com.kpu.dao;

import java.sql.SQLException;


import java.util.Map;

public interface FileUploadDAO {

	public void saveImage(Map<String, Object> hmap) throws SQLException;
	
}
