package com.me.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.mapper.LoverMapper;
import com.me.pojo.Lover;
import com.me.pojo.LoverExample;
import com.me.pojo.LoverExample.Criteria;

@Service
public class LoverServiece {
	@Autowired
	private LoverMapper loverMapper;
	
	public List<Lover> selectAllByUserId(Integer userid){
		LoverExample loverExample=new LoverExample();
		Criteria criteria=loverExample.createCriteria();
		criteria.andUseridEqualTo(userid);
		List<Lover> aList=loverMapper.selectByExample(loverExample);
		return aList;
	}
	
	public void deleteLoverById(Integer id) {
		loverMapper.deleteByPrimaryKey(id);
	}
}
