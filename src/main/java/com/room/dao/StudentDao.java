package com.room.dao;

import java.util.List;

import com.room.pojo.Major;
import com.room.pojo.Student;

public interface StudentDao {

	List<Major> majorList();

	int insertstudent(Student student);

	List<Student> selectstudentList(Student student);

	int delstudent(Integer id);

	Student selectstudentById(Integer id);

	int doupdatesutdent(Student student);

	List<Student> selectstudentByroomId(Integer id);
}
