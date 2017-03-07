package com.dmooc.service.android;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dmooc.dao.TranslatorDao;
import com.dmooc.model.TranslatorModel;

public class TranslatorService {
	
	@Autowired
	TranslatorDao translatorDao;
	
	
    /**
     * 获取翻译官的信息
     */
    public List<TranslatorModel> getTranslators(){
        return translatorDao.getTranslators();
    }

    /**
     * 根据id筛选翻译官
     * @param interId
     * @return
     */
    public TranslatorModel getTranslatorById(String interId) {
    	List<TranslatorModel> result = translatorDao.getTranslatorById(interId);
    	if(result!=null && result.size()>0)
    		return result.get(0);
    	else
    		return null;
	}

    /**
     * 根据语言获取翻译官信息
     * @param language
     * @return
     */
	public List<TranslatorModel> getTranslatorsByCondition(String language) {
		return translatorDao.getTranslatorByCondition(language);
	}

}
