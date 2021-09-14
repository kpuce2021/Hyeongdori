package com.kpu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kpu.dao.ResultDAO;
import com.kpu.domain.ResultDayVO;
import com.kpu.domain.ResultVO;

@Service
public class ResultServiceImpl implements ResultService{

	@Autowired
	private ResultDAO rDAO;
	
	@Transactional(propagation=Propagation.REQUIRED, timeout=10)
	public void addResultService(ResultVO rVO) throws Exception {
		rDAO.addResult(rVO);
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, readOnly=true)
	public List<ResultVO> readAllByUserId(String id) throws Exception {
		return rDAO.readAllById(id);
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, readOnly=true)
	public List<ResultVO> readAllUserList() throws Exception {
		return rDAO.readAllList();
	}

	@Override
	public void deleteResultByUserId(String id) throws Exception {
		rDAO.deleteResult(id);
	}

	@Override
	public List<String> readImgNameListByUserId(String id) throws Exception {
		return rDAO.readImgNameList(id);
	}

	// 일자별 평균 검출 결과 뽑아내는 코드
	public List<ResultDayVO> readAllImgNameByDay() throws Exception{
		return rDAO.readAllImgByDay();
	}
}
