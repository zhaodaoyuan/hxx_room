package com.room.service;

import java.util.List;

import com.room.pojo.Major;
import com.room.pojo.Student;

public interface StudentService {

	List<Major> majorList();

	boolean insertstudent(Student student);

	List<Student> selectstudentList(Student student);

	boolean delstudent(Integer id);

	Student selectstudentById(Integer id);
	
	boolean doupdatesutdent(Student student);

	

}
