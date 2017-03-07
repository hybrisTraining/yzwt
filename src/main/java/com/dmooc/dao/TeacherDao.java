package com.dmooc.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.dmooc.data.TeacherLoginAndRegisterData;
import com.dmooc.model.AppointMentModel;
import com.dmooc.model.TeacherModel;

public class TeacherDao {

	@Autowired
	MongoOperations mongo;
	
	//find all teacherModel by teacher id
	public List<TeacherModel> getTeacherByUsername(String username) {
		return mongo.find(Query.query(Criteria.where("username").is(username)),
				TeacherModel.class);
	}

	/**
	 * 新增新老师
	 * @param registerData
	 * @return
	 */
	public boolean addNewTeacher(TeacherLoginAndRegisterData registerData) {
		TeacherModel teacher = new TeacherModel();
		try {
			BeanUtils.copyProperties(teacher, registerData);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		mongo.save(teacher, "teacherModel");
		return true;
	}

	public List<TeacherModel> findTeacher(String name) {
		return mongo.find(Query.query(Criteria.where("username").is(name)),
				TeacherModel.class);
	}
	
	
	/**
	 * @return 教师列表
	 */
	public List<TeacherModel> getTeachers(){
		return mongo.find(null,TeacherModel.class);
	}

	/**
	 * @param teacherId
	 * @return 教师信息
	 */
	public List<TeacherModel> getTeacherByTeacherId(String teacherId) {
		return mongo.find(Query.query(Criteria.where("mobile").is(teacherId)),
				TeacherModel.class);
	}

    /**
     * @param grade
     * @param subject
     * @return 返回符合搜索条件的教师信息
     */
	public List<TeacherModel> getTeacherByCondition(String grade, String subject) {
		Criteria sql = new Criteria();
		if(subject!=null){
			List<String> subjectCondition = new ArrayList<>();
			subjectCondition.add(subject);
			sql.where("grade").in(subjectCondition);
		}
		if(grade!=null && "高中".equals(grade)){
			List<String> gradeCondition = new ArrayList<>();
			gradeCondition.add("高一");
			gradeCondition.add("高二");
			gradeCondition.add("高三");
			sql.where("grade").in(gradeCondition);
		}
		if(grade!=null && "初中".equals(grade)){
			List<String> gradeCondition = new ArrayList<>();
			gradeCondition.add("初一");
			gradeCondition.add("初二");
			gradeCondition.add("初三");
			sql.where("grade").in(gradeCondition);
		}
		return mongo.find(Query.query(sql),
				TeacherModel.class);
	}
	
	public void addData() {
		mongo.dropCollection(AppointMentModel.class);
		AppointMentModel app1 = new AppointMentModel();
		app1.setStudent_id("123456");
		app1.setStudent_name("李浩");
		app1.setSubject("数学");
		app1.setClass_time("2017-02-23 14:00-14:59");
		app1.setTeacher_id("58a503cbbe8ef1502e3d80de");
		app1.setTeacher_name("u1");
		mongo.save(app1);
		AppointMentModel app2 = new AppointMentModel();
		app2.setStudent_id("123456");
		app2.setStudent_name("李浩");
		app2.setSubject("数学");
		app2.setClass_time("2017-02-22 14:00-14:59");
		app2.setTeacher_id("58a503cbbe8ef1502e3d80de");
		app2.setTeacher_name("u1");
		mongo.save(app2);
		AppointMentModel app3 = new AppointMentModel();
		app3.setStudent_id("123456");
		app3.setStudent_name("李浩");
		app3.setSubject("数学");
		app3.setClass_time("2017-02-21 14:00-14:59");
		app3.setTeacher_id("58a503cbbe8ef1502e3d80de");
		app3.setTeacher_name("u1");
		mongo.save(app3);
		
		TeacherModel t1 = new TeacherModel();
		t1.setReal_name("lch");
		List<String> l1 = new ArrayList<>();
		l1.add("英语");
		l1.add("数学");
		t1.setSubjects(l1);
		mongo.save(t1);
		TeacherModel t2 = new TeacherModel();
		t2.setReal_name("lwj");
		List<String> l2 = new ArrayList<>();
		l2.add("化学");
		l2.add("数学");
		t2.setSubjects(l2);
		mongo.save(t2);
		
		//try query test
		System.out.println("test1...|| try to find lch and 化学");
		Criteria sql = new Criteria();
			List<String> subjectCondition = new ArrayList<>();
			subjectCondition.add("化学");
			sql.where("subjects").in(subjectCondition);
			sql.where("real_name").is("lch");
			List<TeacherModel> result1 = mongo.find(Query.query(sql),TeacherModel.class);
			if(result1!=null && result1.size()>0){
				System.out.println("find test1");
			}
			else{
				System.out.println("not find test1");
			}
			
			System.out.println("test2...|| try to find  数学");
			Criteria sql2 = new Criteria();
				List<String> subjectCondition2 = new ArrayList<>();
				subjectCondition2.add("数学");
				sql.where("subjects").in(subjectCondition2);
				List<TeacherModel> result2 = mongo.find(Query.query(sql2),TeacherModel.class);
				if(result2!=null && result2.size()>0){
					System.out.println("find test2");
				}
				else{
					System.out.println("not find test2");
				}
		
	}
}
