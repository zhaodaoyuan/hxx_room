package com.room.service;

import java.util.List;

import com.room.pojo.Bed;
import com.room.pojo.Build;
import com.room.pojo.Repair;
import com.room.pojo.Room;
import com.room.pojo.Student;
import com.room.pojo.Student_room;

public interface RoomService {

	List<Build> buildlist();

	boolean insertroom(Room room);

	List<Room> selectlistroom(Room room);

	Room selectroomById(Integer id);

	boolean roomupdate(Room room);

	boolean delroom(Integer id);

	List<Room> selectajax(Integer id);

	List<Bed> bedlist();

	boolean insertStudent_Room(Student_room student_room);

	boolean delstudent_room(Integer id);

	List<Student> details(Integer id);

	boolean delinto(Integer id);

	Student_room selectstudent_room(Student_room student_room);

	Room selectintoById(Integer id);

	boolean tiaozheng(Student_room student_room);

	boolean doaddRepair(Repair repair);

	boolean delrepair(Integer id);

	List<Repair> selectRepair(Repair repair);

}
