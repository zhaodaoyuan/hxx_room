package com.room.pojo;

public class Bed {
	private int bed_id;
	private String bed_num;
	public Bed() {
		super();
	}
	public int getBed_id() {
		return bed_id;
	}
	public void setBed_id(int bed_id) {
		this.bed_id = bed_id;
	}
	public String getBed_num() {
		return bed_num;
	}
	public void setBed_num(String bed_num) {
		this.bed_num = bed_num;
	}
	@Override
	public String toString() {
		return "Bed [bed_id=" + bed_id + ", bed_num=" + bed_num + "]";
	}
	
	
}
