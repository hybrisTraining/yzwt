package com.dmooc.model;

import java.util.List;
import org.springframework.data.annotation.Id;

public class TranslatorModel {

	@Id
    private String interId;
    private String organizationId;
    private String name;
    private List<String> languageType;
    private int price;
    private String score;
    private int times;
    private String details;
    private String mobile;
	public String getInterId() {
		return interId;
	}
	public void setInterId(String interId) {
		this.interId = interId;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getLanguageType() {
		return languageType;
	}
	public void setLanguageType(List<String> languageType) {
		this.languageType = languageType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

    
}
