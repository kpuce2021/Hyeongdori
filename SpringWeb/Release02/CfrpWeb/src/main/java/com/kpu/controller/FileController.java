package com.kpu.controller;

import java.util.ArrayList;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kpu.domain.FileVO;
import com.kpu.service.FileService;
import com.kpu.dao.FileUploadDAO;


@Controller
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	// private FileUploadDAO dao;
	
	@RequestMapping(value="/formFile")
	public String formFile() {
		return "formFile";
	}
	
	
	@RequestMapping(value="/saveImage")
	public String saveImage(FileVO vo) {
		try {
			Map<String, Object> hmap = new HashMap<String, Object>();
			hmap.put("img", vo.getImgFile().getBytes());
			fileService.addFile(hmap);
			//dao.saveImage(hmap);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/formFile";
	}
	/*
	
	@RequestMapping(value= {"/fileList"}, method=RequestMethod.GET)
	public String FileList(Model model) throws Exception{
		List<FileVO> fileVO = fileService.readFileList();
		
		model.addAttribute("fileVO", fileVO);
		return "NewFile";
	}
	
	
	@RequestMapping(value="/view")
	public String view() {
		return "view";
	}
	
	@RequestMapping(value="/getByteImage")
	public ResponseEntity<byte[]> getByteImage(){
		Map<String, Object> map = fileService.getByte();
		byte[] imageContent = (byte[])map.get("img");
		final HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value="/NewFile")
	public String NewFile() {
		return "NewFile";
	}
	
	@RequestMapping(value="/getByteImages")
	public ResponseEntity<List<byte[]>> getByteImages() throws Exception{
		List<FileVO> list = fileService.readFileList();
		List<byte[]> list_bytes = new ArrayList<>();
		
		if(list.isEmpty())
			System.out.println("list is null");
		for(int i=0; i<list.size(); i++) {
			byte[] encoded = list.get(i).getImgFile().getBytes();
			list_bytes.add(encoded);
		}
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<List<byte[]>>(list_bytes, headers, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/NewFile")
	public ModelAndView NewFile() throws Exception {
		List<String> paramList = new ArrayList<String>();
		ModelAndView model = new ModelAndView("NewFile");
		
		List<FileVO> list = fileService.readFileList();
		
		for(int i=0; i<list.size(); i++) {
			byte[] encoded = (list.get(i).getImgFile().getBytes());
			String encodedString = new String(encoded);
			paramList.add(encodedString);
			model.addObject("image", paramList);
		}
		return model;
	}
	*/
	
}
