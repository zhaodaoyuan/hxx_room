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
import com.room.pojo.Build;
import com.room.pojo.Major;
import com.room.pojo.Student;
import com.room.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/")
	public String roomindex() {
		return "student/index";
	}
	
	@RequestMapping("/add")
	public String addstudent(Model model) {
		List<Major> majorlist = studentService.majorList();
		model.addAttribute("list", majorlist);
		return "student/add";
	}
	
	@RequestMapping("/doadd")
	@ResponseBody
	public boolean doadd(Student student) {
		boolean flag = studentService.insertstudent(student);
		return flag;
	}
	@RequestMapping("/list")
	public String liststudent(Student student,Model model,@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum) {
		PageHelper.startPage(pageNum,10);
		List<Student> list = studentService.selectstudentList(student);
		PageInfo pageInfo = new PageInfo(list);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("student", student);
		return "student/list";
	}
	@RequestMapping("/ajax")
	@ResponseBody
	public List<Student> ajaxlist(Student student){
		List<Student> list = studentService.selectstudentList(student);
		return list;
	}
	@RequestMapping("/ajaxByid")
	@ResponseBody
	public Student ajaxByid(Integer id) {
		
		Student student = studentService.selectstudentById(id);
		return student;
	}
	@RequestMapping("/update")
	public String updatestudent(Integer id,Model model) {
		Student student = studentService.selectstudentById(id);
		List<Major> majorlist = studentService.majorList();
		model.addAttribute("list", majorlist);
		model.addAttribute("student", student);
		return "student/update";
	}
	
	@RequestMapping("/doupdate")
	@ResponseBody
	public boolean doupdatesutdent(Student student) {
		boolean flag = studentService.doupdatesutdent(student);
		return flag;
	}
	@RequestMapping("/del")
	@ResponseBody
	public boolean delstudent(Integer id) {
		boolean flag = studentService.delstudent(id);
		return flag;
	}
}
