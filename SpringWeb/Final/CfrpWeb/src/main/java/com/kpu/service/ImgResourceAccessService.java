package com.kpu.service;

import java.util.List;

public interface ImgResourceAccessService {
	public List<String> ImgAccessService(String uploadPath) throws Exception;
	public List<String> detectImgAccessService(String detectPath) throws Exception;
}
