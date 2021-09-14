package com.kpu.service;

import java.util.List;

import com.kpu.domain.ResultDayVO;
import com.kpu.domain.ResultVO;

public interface ResultService {
	public void addResultService(ResultVO rVO) throws Exception;
	public List<String> readImgNameListByUserId(String id) throws Exception;
	public List<ResultVO> readAllByUserId(String id) throws Exception;
	public List<ResultVO> readAllUserList() throws Exception;
	public void deleteResultByUserId(String id) throws Exception;
	public List<ResultDayVO> readAllImgNameByDay() throws Exception;
	
}
