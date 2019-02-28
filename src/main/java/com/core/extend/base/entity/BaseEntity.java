package com.core.extend.base.entity;

import javax.persistence.Id;

import com.core.extend.base.annotation.EnableExample;

public class BaseEntity {

	@EnableExample
	@Id
	protected String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		 this.id = id == null ? null : id.trim();
	}
}
