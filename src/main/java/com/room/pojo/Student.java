package com.room.pojo;

import java.io.Serializable;

public class Student implements Serializable{
	  private Integer student_id;
	  private String student_num;
	  private String student_name;
	  private Integer student_sex;
	  private Integer major_id;
	  private String major_name;
	  private String student_phone;
	  private String student_adress;
	  private String bed_num;
	  private Integer status;
	public Student() {
		super();
	}
	
	public String getBed_num() {
		return bed_num;
	}

	public void setBed_num(String bed_num) {
		this.bed_num = bed_num;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public String getStudent_num() {
		return student_num;
	}
	public void setStudent_num(String student_num) {
		this.student_num = student_num;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public Integer getStudent_sex() {
		return student_sex;
	}
	public void setStudent_sex(Integer student_sex) {
		this.student_sex = student_sex;
	}
	public Integer getMajor_id() {
		return major_id;
	}
	public void setMajor_id(Integer major_id) {
		this.major_id = major_id;
	}
	public String getStudent_phone() {
		return student_phone;
	}
	public void setStudent_phone(String student_phone) {
		this.student_phone = student_phone;
	}
	public String getStudent_adress() {
		return student_adress;
	}
	public void setStudent_adress(String student_adress) {
		this.student_adress = student_adress;
	}
	
	
	public String getMajor_name() {
		return major_name;
	}
	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_num=" + student_num + ", student_name=" + student_name
				+ ", student_sex=" + student_sex + ", major_id=" + major_id + ", major_name=" + major_name
				+ ", student_phone=" + student_phone + ", student_adress=" + student_adress + ", bed_num=" + bed_num
				+ ", status=" + status + "]";
	}



	

	
	
	  
	  
}
