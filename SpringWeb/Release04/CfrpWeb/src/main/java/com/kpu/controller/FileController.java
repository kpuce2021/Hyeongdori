package com.kpu.controller;

import java.util.ArrayList;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

	// Server에 클라이언트 로컬 이미지를 전송하기 위해 formFile View를 호출하는 컨트롤러 메서드
	@RequestMapping(value="/formFile")
	public String formFile() {
		return "formFile";
	}
	
}
