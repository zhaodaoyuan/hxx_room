package com.room.pojo;

public class Build {
	private int build_id;
	private String build_name;
	public Build() {
		super();
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
	@Override
	public String toString() {
		return "Build [build_id=" + build_id + ", build_name=" + build_name + "]";
	}
	
	
}
