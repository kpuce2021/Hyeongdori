package com.kpu.dao;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kpu.domain.FileVO;

@Repository
public class FileUploadDAOImpl implements FileUploadDAO {
	@Autowired
	private SqlSession query;
	
	public void saveImage(Map<String, Object> hmap) throws SQLException{
		query.insert("query.saveImage", hmap);
	}
	
	public List<FileVO> readList() throws Exception{
		List<FileVO> FileList = new ArrayList<FileVO>();
		FileList = query.selectList("query.selectAll");
		for(int i=0; i<FileList.size(); i++) {
			System.out.println(FileList.get(i));
		}
		return FileList;
	}
	public Map<String, Object> getByteImage(){
		return query.selectOne("query.getByteImage");
	}
}
