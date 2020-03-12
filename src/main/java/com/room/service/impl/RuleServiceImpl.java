package com.room.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.room.dao.RuleDao;
import com.room.pojo.Rule;
import com.room.pojo.RuleType;
import com.room.service.RuleService;

@Service
public class RuleServiceImpl implements RuleService{

	@Autowired
	private RuleDao ruleDao;
	
	@Override
	public List<RuleType> selectTypeList() {
		// TODO Auto-generated method stub
		return ruleDao.selectTypeList();
	}

	@Override
	public boolean delrule(Integer id) {
		// TODO Auto-generated method stub
		return ruleDao.delrule(id)>0;
	}

	@Override
	public boolean doadd(Rule rule) {
		// TODO Auto-generated method stub
		return ruleDao.doadd(rule)>0;
	}

	@Override
	public List<Rule> selectrule(Rule rule) {
		// TODO Auto-generated method stub
		return ruleDao.selectrule(rule);
	}

}
