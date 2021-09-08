package com.kpu.dao;

import java.util.List;

import com.kpu.domain.ResultVO;

public interface ResultDAO {
	public void addResult(ResultVO rVO) throws Exception;
	public List<String> readImgNameList(String id) throws Exception;
	public List<ResultVO> readAllById(String id) throws Exception;
	public List<ResultVO> readAllList() throws Exception;
	public void deleteResult(String id) throws Exception;
	
}
