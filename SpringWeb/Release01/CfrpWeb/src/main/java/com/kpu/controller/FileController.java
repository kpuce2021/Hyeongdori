package com.kpu.controller;

import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kpu.domain.FileVO;
import com.kpu.dao.FileUploadDAO;

@Controller
public class FileController {
	@Autowired
	private FileUploadDAO dao;
	
	@RequestMapping(value="/formFile")
	public String formFile() {
		return "formFile";
	}
	
	
	@RequestMapping(value="/saveImage")
	public String saveImage(FileVO vo) {
		try {
			Map<String, Object> hmap = new HashMap<String, Object>();
			hmap.put("img", vo.getImgFile().getBytes());
			dao.saveImage(hmap);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/formFile";
	}
}
