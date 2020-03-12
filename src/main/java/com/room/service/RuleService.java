package com.room.service;

import java.util.List;

import com.room.pojo.Rule;
import com.room.pojo.RuleType;

public interface RuleService {

	List<RuleType> selectTypeList();

	boolean delrule(Integer id);

	boolean doadd(Rule rule);

	List<Rule> selectrule(Rule rule);

}
