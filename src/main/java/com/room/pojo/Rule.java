package com.room.pojo;

import java.util.Date;

public class Rule {
	private Integer rule_id;
	private Integer student_id;
	private String student_name;
	private Integer type_id;
	private String type_name;
	private String created;
	public Rule() {
		super();
	}
	public Integer getRule_id() {
		return rule_id;
	}
	public void setRule_id(Integer rule_id) {
		this.rule_id = rule_id;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	@Override
	public String toString() {
		return "Rule [rule_id=" + rule_id + ", student_id=" + student_id + ", type_id=" + type_id + ", type_name="
				+ type_name + ", created=" + created + "]";
	}
	
	
}
