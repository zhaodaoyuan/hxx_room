	package com.room.pojo;


public class Student_room {
	private int bed_id;
	private String bed_num;
	private int room_id;
	private String room_num;
	private int build_id;
	private String build_name;
	private int student_id;
	private String student_name;
	private String major_name;
	public Student_room() {
		super();
	}
	public int getBed_id() {
		return bed_id;
	}
	public void setBed_id(int bed_id) {
		this.bed_id = bed_id;
	}
	
	public String getMajor_name() {
		return major_name;
	}
	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}
	public String getBed_num() {
		return bed_num;
	}
	public void setBed_num(String bed_num) {
		this.bed_num = bed_num;
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getBuild_id() {
		return build_id;
	}
	public void setBuild_id(int build_id) {
		this.build_id = build_id;
	}
	public String getBuild_name() {
		return build_name;
	}
	public void setBuild_name(String build_name) {
		this.build_name = build_name;
	}
	public String getRoom_num() {
		return room_num;
	}
	public void setRoom_num(String room_num) {
		this.room_num = room_num;
	}
	
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	@Override
	public String toString() {
		return "Student_room [bed_id=" + bed_id + ", bed_num=" + bed_num + ", room_id=" + room_id + ", room_num="
				+ room_num + ", build_id=" + build_id + ", build_name=" + build_name + ", student_id=" + student_id
				+ ", student_name=" + student_name + ", major_name=" + major_name + "]";
	}
	
		
	
	
	
}
