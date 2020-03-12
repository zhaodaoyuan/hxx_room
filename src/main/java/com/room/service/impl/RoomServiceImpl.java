package com.room.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.room.dao.RoomDao;
import com.room.dao.StudentDao;
import com.room.pojo.Bed;
import com.room.pojo.Build;
import com.room.pojo.Repair;
import com.room.pojo.Room;
import com.room.pojo.Student;
import com.room.pojo.Student_room;
import com.room.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomDao roomDao; 
	
	@Autowired
	private StudentDao studentDao;
	
	public List<Build> buildlist() {
		// TODO Auto-generated method stub
		return roomDao.buildlist();
	}
	public boolean insertroom(Room room) {
		// TODO Auto-generated method stub
		return roomDao.insertroom(room)>0;
	}
	public List<Room> selectlistroom(Room room) {
		// TODO Auto-generated method stub
		return roomDao.selectlistroom(room);
	}
	public Room selectroomById(Integer id) {
		// TODO Auto-generated method stub
		return roomDao.selectroomById(id);
	}
	public boolean roomupdate(Room room) {
		// TODO Auto-generated method stub
		return roomDao.roomupdate(room)>0;
	}
	public boolean delroom(Integer id) {
		// TODO Auto-generated method stub
		return roomDao.delroom(id)>0;
	}
	@Override
	public List<Room> selectajax(Integer id) {
		// TODO Auto-generated method stub
		return roomDao.selectajax(id);
	}
	@Override
	public List<Bed> bedlist() {
		// TODO Auto-generated method stub
		return roomDao.bedlist();
	}
	@Override
	public boolean insertStudent_Room(Student_room student_room) {
		// TODO Auto-generated method stub
		return roomDao.insertStudent_Room(student_room)>0;
	}
	@Override
	public boolean delstudent_room(Integer id) {
		// TODO Auto-generated method stub
		return roomDao.delstudent_room(id)>0;
	}
	@Override
	public List<Student> details(Integer id) {
		// TODO Auto-generated method stub
		return studentDao.selectstudentByroomId(id);
	}
	@Override
	public boolean delinto(Integer id) {
		// TODO Auto-generated method stub‘
		Room room = roomDao.selectintoById(id);
		Student student = studentDao.selectstudentById(id);
		student.setStatus(2);
		roomDao.delinto(id);
		studentDao.doupdatesutdent(student);
		int downstudent = roomDao.downstudent(room.getRoom_id());
		return downstudent>0;
	}
	@Override
	public Student_room selectstudent_room(Student_room student_room) {
		// TODO Auto-generated method stub
		return roomDao.selectstudent_room(student_room);
	}
	@Override
	public Room selectintoById(Integer id) {
		// TODO Auto-generated method stub
		return roomDao.selectintoById(id);
	}
	@Override
	public boolean tiaozheng(Student_room student_room) {
		System.err.println("进入service");
		// TODO Auto-generated method stub
		System.err.println("开始查询学生所属寝室");
		Room room = roomDao.selectintoById(student_room.getStudent_id());
		//删除入住信息
		System.err.println("清空该学生的入住信息");
		roomDao.delinto(student_room.getStudent_id());
		//原寝室人数-1
		System.err.println("原寝室人数调整");
		roomDao.downstudent(room.getRoom_id());
		//入住新寝室
		System.err.println("入住新寝室");
		roomDao.insertStudent_Room(student_room);
		//新寝室人数+1
		System.err.println("新寝室人数调整");
		Room newRoom = roomDao.selectintoById(student_room.getStudent_id());
		roomDao.upstudent(newRoom.getRoom_id());
		return true;
	}
	@Override
	public boolean doaddRepair(Repair repair) {
		// TODO Auto-generated method stub
		return roomDao.doaddRepair(repair)>0;
	}
	@Override
	public boolean delrepair(Integer id) {
		// TODO Auto-generated method stub
		return roomDao.delrepair(id)>0;
	}
	@Override
	public List<Repair> selectRepair(Repair repair) {
		// TODO Auto-generated method stub
		return roomDao.selectRepair(repair);
	}

}
