package com.room.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.room.dao.StudentDao;
import com.room.pojo.Major;
import com.room.pojo.Student;
import com.room.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	public List<Major> majorList() {
		// TODO Auto-generated method stub
		return studentDao.majorList();
	}

	public boolean insertstudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.insertstudent(student)>0;
	}

	public List<Student> selectstudentList(Student student) {
		// TODO Auto-generated method stub
		return studentDao.selectstudentList(student);
	}

	public boolean delstudent(Integer id) {
		// TODO Auto-generated method stub
		return studentDao.delstudent(id)>0;
	}

	public Student selectstudentById(Integer id) {
		// TODO Auto-generated method stub
		return studentDao.selectstudentById(id);
	}

	public boolean doupdatesutdent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.doupdatesutdent(student)>0;
	}

	

}
