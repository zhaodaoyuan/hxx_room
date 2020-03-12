package com.room.pojo;

public class Repair {
	private Integer repair_id;
	private String build_name;
	private Integer room_id;
	private String room_num;
	private String repair_message;
	
	
	public String getRoom_num() {
		return room_num;
	}
	public void setRoom_num(String room_num) {
		this.room_num = room_num;
	}
	public Integer getRepair_id() {
		return repair_id;
	}
	public void setRepair_id(Integer repair_id) {
		this.repair_id = repair_id;
	}
	
	public String getBuild_name() {
		return build_name;
	}
	public void setBuild_name(String build_name) {
		this.build_name = build_name;
	}
	public Integer getRoom_id() {
		return room_id;
	}
	public void setRoom_id(Integer room_id) {
		this.room_id = room_id;
	}
	public String getRepair_message() {
		return repair_message;
	}
	public void setRepair_message(String repair_message) {
		this.repair_message = repair_message;
	}
	public Repair() {
		super();
	}
	@Override
	public String toString() {
		return "Repair [repair_id=" + repair_id + ", build_name=" + build_name + ", room_id=" + room_id + ", room_num="
				+ room_num + ", repair_message=" + repair_message + "]";
	}
	
	
	
}
