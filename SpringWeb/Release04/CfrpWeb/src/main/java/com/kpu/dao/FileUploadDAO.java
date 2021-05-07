package com.kpu.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.kpu.domain.FileVO;

public interface FileUploadDAO {

	public void saveImage(Map<String, Object> hmap) throws SQLException;
	public List<FileVO> readList() throws Exception;
	public Map<String, Object> getByteImage();
}
