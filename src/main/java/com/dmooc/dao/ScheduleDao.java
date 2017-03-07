package com.dmooc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.dmooc.model.AppointMentModel;

public class ScheduleDao {
	
	@Autowired
	MongoOperations mongo;
	
	//find all appointments by teacher id
	public List<AppointMentModel> getAppoinmentsByTeacherName(String name) {
		return mongo.find(Query.query(Criteria.where("teacher_name").is(name)),
				AppointMentModel.class);
	}

}
