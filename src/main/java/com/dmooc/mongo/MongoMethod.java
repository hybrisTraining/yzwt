package com.dmooc.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.dmooc.model.AppointMentModel;

public class MongoMethod {

	@Autowired
	MongoOperations mongo;
	
	public void mongoMethod(){
		
		/*
		 * also support below method==>
		 * delete
		 * deleteAll
		 * exists(Object)
		 * exists(Id)
		 * findAll()
		 * findAll(sort)
		 * findOne(Id)
		 * save
		 * ============================>
		 */
	}
	
	public void testGetCollection(){
		//get Collection
		mongo.getCollection("appointment");
		//get Collection's count
		mongo.getCollection("appointment").count();
	}
	
	public void testFind(){
		String id = "123456";
		AppointMentModel model = mongo.findById(id, AppointMentModel.class);
		System.out.println(model==null);
	}
	
	public void testFindByCondition(){
		List<AppointMentModel> appoints = mongo.find(
				Query.query(Criteria.where("id").is("123456").and("teacher_id").is("654321")),
					AppointMentModel.class);
		System.out.println(appoints.isEmpty());
	}
	
	public void testSaveModel(){
		//save model
		mongo.save(new AppointMentModel(),"appointment");
	}
	
	public void testModel(){
		AppointMentModel appointment = new AppointMentModel();
		mongo.remove(appointment);
	}
	public void addAppointment(){
		mongo.dropCollection(AppointMentModel.class);
		AppointMentModel app1 = new AppointMentModel();
		app1.setStudent_id("123456");
		app1.setStudent_name("李浩");
		app1.setSubject("数学");
		app1.setClass_time("2017-02-23 14:00-14:59");
		app1.setTeacher_id("58a503cbbe8ef1502e3d80de");
		app1.setTeacher_name("u1");
		mongo.save(app1);
	}
}
