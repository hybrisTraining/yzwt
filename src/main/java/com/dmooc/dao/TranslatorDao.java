package com.dmooc.dao;

import com.dmooc.model.TranslatorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

public class TranslatorDao {
	
	@Autowired
	MongoOperations mongo;

    /**
     * 获取所有翻译官的信息
     * @return
     */
	public List<TranslatorModel> getTranslators() {
		return mongo.findAll(TranslatorModel.class);
	}

	/**
	 * 根据条件获取翻译官
	 * @param interId
	 * @return
	 */
	public List<TranslatorModel> getTranslatorById(String interId) {
		if(interId==null){
			return null;
		}
		return mongo.find(Query.query(Criteria.where("interId").is(interId)),
					TranslatorModel.class);

	}

	/**
	 * 根据语言筛选翻译官
	 * @param language
	 * @return
	 */
	public List<TranslatorModel> getTranslatorByCondition(String language) {
		if(language==null){
			return null;
		}
		Criteria sql = new Criteria();
			List<String> subjectCondition = new ArrayList<>();
			subjectCondition.add(language);
			sql.where("languageType").in(subjectCondition);
		return mongo.find(Query.query(sql),TranslatorModel.class);
	}

}
