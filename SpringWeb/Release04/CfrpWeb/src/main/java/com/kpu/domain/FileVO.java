package com.kpu.domain;

import org.springframework.web.multipart.MultipartFile;

public class FileVO {
	private MultipartFile img;
	
	public MultipartFile getImgFile() {
		return img;
	}
	
	public void setImgFile(MultipartFile img) {
		this.img = img;
	}
}
