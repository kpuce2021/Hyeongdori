package com.kpu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpu.dao.FileUploadDAO;
import com.kpu.domain.FileVO;

@Service
public class FileServiceImpl implements FileService {
	@Autowired
	private FileUploadDAO fileDAO;
	
	public void addFile(Map<String, Object> hmap) throws Exception{
		fileDAO.saveImage(hmap);
		
	}
	public List<FileVO> readFileList() throws Exception{
		return fileDAO.readList();
	}
	public Map<String, Object> getByte(){
		return fileDAO.getByteImage();
	}
}
