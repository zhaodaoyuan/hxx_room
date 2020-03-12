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
import com.room.pojo.Bed;
import com.room.pojo.Build;
import com.room.pojo.Repair;
import com.room.pojo.Room;
import com.room.pojo.Student;
import com.room.pojo.Student_room;
import com.room.service.RoomService;
import com.room.service.StudentService;

@Controller
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/")
	public String roomindex() {
		
		return "room/index";
	}
	
	@RequestMapping("/add")
	public String addroom(Model model) {
		List<Build> list = roomService.buildlist();
		model.addAttribute("list", list);
		return "room/add";
	}
	@RequestMapping("/doadd")
	@ResponseBody
	public boolean doadd(Room room) {
		boolean flag=roomService.insertroom(room);
		return flag;
	}
	@RequestMapping("/list")
	public String listroom(Model model,Room room,@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum) {
		List<Build> builist = roomService.buildlist();
		PageHelper.startPage(pageNum, 10);
		List<Room> list = roomService.selectlistroom(room);
		PageInfo pageInfo = new PageInfo(list);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("list", builist);
		model.addAttribute("room", room);
		return "room/list";
	}
	@RequestMapping("/update")
	public String updateroom(Integer id,Model model) {
		Room room = roomService.selectroomById(id);
		List<Build> list = roomService.buildlist();
		model.addAttribute("list", list);
		model.addAttribute("room",room);
		return "room/update";
	}
	@RequestMapping("/doupdate")
	@ResponseBody
	public boolean doupdate(Room room) {
		boolean flag = roomService.roomupdate(room);
		return flag;
	}
	@RequestMapping("/del")
	@ResponseBody
	public boolean delroom(Integer id) {
		boolean flag = roomService.delroom(id);
		return flag;
	}
	@RequestMapping("/delinto")
	@ResponseBody
	public boolean delinto(Integer id) {
		
		boolean flag = roomService.delinto(id);
		
		
		return flag;
	}
	@RequestMapping("/details")
	public String detailsroom(Integer id,Model model) {
		List<Build> buildlist = roomService.buildlist();
		List<Student> list = roomService.details(id);
		List<Bed> bedlist = roomService.bedlist();
		model.addAttribute("bedlist", bedlist);
		model.addAttribute("list", list);
		model.addAttribute("buildlist", buildlist);
		return "room/details";
	}
	
	
	@RequestMapping("/tiaozheng")
	@ResponseBody
	public boolean tiaozheng(Student_room student_room) {
		
		boolean falg=roomService.tiaozheng(student_room);
		return falg;
	}
	
	@RequestMapping("/into/list")
	public String intoStudentList() {
		
		return "room/add";
	}
	@RequestMapping("/into/add")
	public String intoadd(Model model) {
		List<Build> list = roomService.buildlist();
		List<Bed> bedlist = roomService.bedlist();
		model.addAttribute("list", list);
		model.addAttribute("bedlist", bedlist);
		return "into/add";
	}
	//学生入住登记
	@RequestMapping("/into/doadd")
	@ResponseBody
	public boolean dointoadd(Student_room student_room) {
		
		//查寻该寝室和床位是否有人居住
		Student_room student_roomInfo = roomService.selectstudent_room(student_room);
		if(student_roomInfo!=null) {
			return false;
		}
		//执行添加
		boolean flag = roomService.insertStudent_Room(student_room);
		//改变学生状态
		Student student = studentService.selectstudentById(student_room.getStudent_id());
		student.setStatus(1);
		studentService.doupdatesutdent(student);
		System.err.println(student_room);
		//添加居住
		Room roomInfo = roomService.selectroomById(student_room.getRoom_id());
		roomInfo.setReal_size(roomInfo.getReal_size()+1);
		boolean roomupdate = roomService.roomupdate(roomInfo);
			return roomupdate;
		
		
	}
	@RequestMapping("/roomajax")
	@ResponseBody
	public List<Room> ajaxlist(Integer id) {
		System.err.println(id);
		List<Room> list = roomService.selectajax(id);
		
		return list;
	}
	@RequestMapping("/into/del")
	@ResponseBody
	public boolean intodel(Integer id) {
		boolean flag = roomService.delstudent_room(id);
		
		return flag;
		
	}
	
	@RequestMapping("/repair/")
	public String indexRepair(Repair repair) {
		return "bx/index";
	}
	
	@RequestMapping("/repair/list")
	public String repairList(@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,Repair repair,Model model) {
		PageHelper.startPage(pageNum, 10);
		List<Repair> list = roomService.selectRepair(repair);
		PageInfo pageInfo = new PageInfo(list);
		model.addAttribute("pageInfo", pageInfo);
		return "bx/list";
	}
	@RequestMapping("/repair/add")
	public String addRepair(Repair repair,Model model) {
		List<Build> list = roomService.buildlist();
		model.addAttribute("list", list);
		return "bx/add";
	}
	
	@RequestMapping("/repair/doadd")
	@ResponseBody
	public boolean doaddRepair(Repair repair) {
		boolean flag = roomService.doaddRepair(repair);
		return flag;
	}
	
	
	@RequestMapping("/repair/dodel")
	@ResponseBody
	public boolean delrepair(Integer id) {
		boolean flag = roomService.delrepair(id);
		return flag;
	}
}
