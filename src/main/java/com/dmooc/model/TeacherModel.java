package com.dmooc.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TeacherModel {
	@Id
	private String id;
	private String username;//用户名
	private String mobile;//电话号码
    private String password;//注册密码
    private String real_name;//真实姓名
    private String icon;//头像
    private String type;//教师类型（分为“大学生教师”、“专职教师”两种）
    private String sex;//性别（“female”、“male”）
    private String id_number;//身份证号
    private String province;//省份
    private String city;//城市
    private List<String> grades;//授课年级（数组：“初一”、“初二”、“初三”、“高一”、“高二”、“高三”）
    private List<String> subjects;//授课科目（数组：“语文”、“数学”、“英语”、“物理”、“化学”、“生物”、“历史”、“政治”、“地理”）
    private String intro;//自我介绍
    private String score;//平无得分（0-5分，可以是小数）
    private String total_time;//总授课时长int
    private String honor;//曾获奖励（数组）
    private String authentication;//认证照片
    private String academy;//（仅在大学生教师类型中存在）所在学校
    private String major;//（仅在大学生教师类型中存在）所在专业
    private String degree;//（仅在大学生教师类型中存在）最高学历
    
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return real_name;
	}
	public void setRealName(String real_name) {
		this.real_name = real_name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getId_number() {
		return id_number;
	}
	public void setId_number(String id_number) {
		this.id_number = id_number;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getTotal_time() {
		return total_time;
	}
	public void setTotal_time(String total_time) {
		this.total_time = total_time;
	}
	public String getHonor() {
		return honor;
	}
	public void setHonor(String honor) {
		this.honor = honor;
	}
	public String getAuthentication() {
		return authentication;
	}
	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}
	public String getAcademy() {
		return academy;
	}
	public void setAcademy(String academy) {
		this.academy = academy;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getId() {
		return id;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public List<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	public List<String> getGrades() {
		return grades;
	}
	public void setGrades(List<String> grades) {
		this.grades = grades;
	}
	
}
