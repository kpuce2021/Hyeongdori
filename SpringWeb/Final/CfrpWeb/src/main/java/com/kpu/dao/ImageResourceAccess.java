package com.kpu.dao;

import java.util.List;

public interface ImageResourceAccess {
	public List<String> fileListMethod(String uploadPath) throws Exception;
	public List<String> detectFileListMethod(String detectPath) throws Exception;
}
