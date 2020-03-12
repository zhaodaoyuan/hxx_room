package com.room.dao;

import java.util.List;

import com.room.pojo.Bed;
import com.room.pojo.Build;
import com.room.pojo.Major;
import com.room.pojo.Repair;
import com.room.pojo.Room;
import com.room.pojo.Student_room;

public interface RoomDao {
	
	List<Major> majorList();

	List<Build> buildlist();

	int insertroom(Room room);

	List<Room> selectlistroom(Room room);

	Room selectroomById(Integer id);

	int roomupdate(Room room);

	int delroom(Integer id);

	List<Room> selectajax(Integer id);

	List<Bed> bedlist();

	int insertStudent_Room(Student_room student_room);

	int delstudent_room(Integer id);

	int delinto(Integer id);

	Student_room selectstudent_room(Student_room student_room);

	Room selectintoById(Integer id);

	int doaddRepair(Repair repair);
	
	int delrepair(Integer id);
	
	int upstudent(Integer id);
	
	int downstudent(Integer id);

	List<Repair> selectRepair(Repair repair);
	
}
