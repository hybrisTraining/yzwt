package com.dmooc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AppointMentModel {
	@Id
	private String id;
	private String student_id;//学生id
    private String student_name;//学生姓名
    private String teacher_id;//教师id
    private String teacher_name;//教师姓名
    private String submit_time;//订单提交时间（时间戳）
    private String subject;//所选科目
    private String is_paid;//是否已经支付（0表示未支付，1表示已支付）
    private String class_time;//所预约的时间，数组（每一项的格式为“2016-9-13 14:00-14:55”）
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getSubmit_time() {
		return submit_time;
	}
	public void setSubmit_time(String submit_time) {
		this.submit_time = submit_time;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getIs_paid() {
		return is_paid;
	}
	public void setIs_paid(String is_paid) {
		this.is_paid = is_paid;
	}
	public String getClass_time() {
		return class_time;
	}
	public void setClass_time(String class_time) {
		this.class_time = class_time;
	}
	public String getId(){
		return id;
	}
    
}
