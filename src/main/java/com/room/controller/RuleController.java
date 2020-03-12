package com.room.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.room.pojo.Rule;
import com.room.pojo.RuleType;
import com.room.service.RuleService;


@Controller
@RequestMapping("/rule")
public class RuleController {
	
	@Autowired
	private RuleService ruleService;
	
	
	@RequestMapping("/")
	public String ruleindex() {
		return "rule/index";
	}
	
	@RequestMapping("/list")
	public String rulelist(Rule rule,Model model,@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum) {
		PageHelper.startPage(pageNum, 10);
		List<Rule> list = ruleService.selectrule(rule);
		PageInfo pageInfo = new PageInfo(list);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("rule", rule);
		return "rule/list";
	}
	@RequestMapping("/add")
	public String ruleadd(Model model) {
		
		List<RuleType> list = ruleService.selectTypeList();
		model.addAttribute("list", list);
		return "rule/add";
	}
	
	@RequestMapping("/doadd")
	@ResponseBody
	public boolean doadd(Rule rule) {
		boolean flag = ruleService.doadd(rule);
		return flag;
	}
	@RequestMapping("/del")
	@ResponseBody
	public boolean ruledel(Integer id) {
		boolean flag=ruleService.delrule(id);
		return flag;
	}
}
