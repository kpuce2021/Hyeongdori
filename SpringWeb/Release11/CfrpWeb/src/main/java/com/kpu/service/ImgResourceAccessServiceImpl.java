package com.kpu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpu.dao.ImageResourceAccess;

@Service
public class ImgResourceAccessServiceImpl implements ImgResourceAccessService{
	
	@Autowired
	private ImageResourceAccess imgAC;
	
	@Override
	public List<String> ImgAccessService(String uploadPath) throws Exception {
		return imgAC.fileListMethod(uploadPath);
	}

	@Override
	public List<String> detectImgAccessService(String detectPath) throws Exception {
		return imgAC.detectFileListMethod(detectPath);
	}

}
