package com.kpu.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kpu.domain.ResultDayVO;
import com.kpu.domain.ResultVO;

@Repository
public class ResultDAOImpl implements ResultDAO{
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.kpu.mapper.ImgMapper";
	
	@Override
	public void addResult(ResultVO rVO) throws Exception {
		sqlSession.insert(namespace+".insert", rVO);
	}

	@Override
	public List<ResultVO> readAllById(String id) throws Exception {
		List<ResultVO> rVO = new ArrayList<ResultVO>();
		rVO = sqlSession.selectList(namespace+".selectAllByid", id);
		return rVO;
	}

	@Override
	public List<ResultVO> readAllList() throws Exception {
		List<ResultVO> rVoList = new ArrayList<ResultVO>();
		rVoList = sqlSession.selectList(namespace+".selectAll");
		return rVoList;
	}

	@Override
	public void deleteResult(String id) throws Exception {
		sqlSession.delete(namespace+".delete", id);
	}

	@Override
	public List<String> readImgNameList(String id) throws Exception {
		List<String> imgNameList = new ArrayList<String>();
		imgNameList = sqlSession.selectList(namespace+".selectImgName", id);
		return imgNameList;
	}

	public List<ResultDayVO> readAllImgByDay() throws Exception{
		List<ResultDayVO> dayResultList = new ArrayList<ResultDayVO>();
		dayResultList = sqlSession.selectList(namespace+".selectAllImgDay");
		return dayResultList;
	}
	
	public List<ResultDayVO> readAllImgByMonth() throws Exception{
		List<ResultDayVO> dayResultList = new ArrayList<ResultDayVO>();
		dayResultList = sqlSession.selectList(namespace+".selectImgMonth");
		return dayResultList;
	}
}
