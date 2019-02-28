package com.core.extend.base.mapper;

import java.util.List;

import tk.mybatis.mapper.common.Mapper;


public interface BaseMapper<E> extends Mapper<E>{
	public List<E> selectList(E entity);
}
