package com.room.pojo;

public class Room {
	private Integer room_id;
	private String room_num;
	private Integer build_id;
	private String build_name;
	private Integer room_size;
	private Integer real_size;
	private String student_name;
	public Room() {
		super();
	}
	
	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public Integer getRoom_id() {
		return room_id;
	}
	public void setRoom_id(Integer room_id) {
		this.room_id = room_id;
	}
	public String getRoom_num() {
		return room_num;
	}
	public void setRoom_num(String room_num) {
		this.room_num = room_num;
	}
	
	public Integer getBuild_id() {
		return build_id;
	}
	public void setBuild_id(Integer build_id) {
		this.build_id = build_id;
	}
	public String getBuild_name() {
		return build_name;
	}
	public void setBuild_name(String build_name) {
		this.build_name = build_name;
	}
	public Integer getRoom_size() {
		return room_size;
	}
	public void setRoom_size(Integer room_size) {
		this.room_size = room_size;
	}
	
	public Integer getReal_size() {
		return real_size;
	}
	public void setReal_size(Integer real_size) {
		this.real_size = real_size;
	}
	@Override
	public String toString() {
		return "Room [room_id=" + room_id + ", room_num=" + room_num + ", build_id=" + build_id + ", build_name="
				+ build_name + ", room_size=" + room_size + ", real_size=" + real_size + "]";
	}
	
	
	
	
	
	
}
