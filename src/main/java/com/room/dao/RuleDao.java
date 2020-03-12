package com.room.dao;

import java.util.List;

import com.room.pojo.Rule;
import com.room.pojo.RuleType;

public interface RuleDao {

	List<RuleType> selectTypeList();

	int delrule(Integer id);

	int doadd(Rule rule);

	List<Rule> selectrule(Rule rule);

}
