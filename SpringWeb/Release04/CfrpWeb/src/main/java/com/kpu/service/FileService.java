package com.kpu.service;

import java.util.List;
import java.util.Map;

import com.kpu.domain.FileVO;

public interface FileService {
	public void addFile(Map<String, Object> hmap) throws Exception;
	public List<FileVO> readFileList() throws Exception;
	public Map<String, Object> getByte();
}
