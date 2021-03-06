package com.core.extend.base.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.core.extend.base.entity.BaseEntity;
import com.core.extend.base.service.BaseService;
import com.core.extend.vo.AjaxResult;
import com.github.pagehelper.PageInfo;

public class BaseController<T extends BaseEntity, S extends BaseService<T>> {

	@Autowired
	protected S service;
	
	@RequestMapping(value = "/insertSelective.do",method={RequestMethod.POST})
	@ResponseBody
	public AjaxResult<T> insertSelective(@RequestBody T record){
		AjaxResult<T> ajax = new AjaxResult<T>();
		BaseEntity baseEntity = (BaseEntity)record;
		baseEntity.setId(UUID.randomUUID().toString());
		int flag = service.insertSelective(record);
		if(flag == 0){
			ajax.setStatus("500");
			ajax.setMessage("插入失败");
		}else{
			ajax.setStatus("200");
			ajax.setMessage("插入成功");
			ajax.setObject(service.selectByPrimaryKey(baseEntity.getId()));
		}
		return ajax;
	}
	
	@RequestMapping(value = "/insert.do",method={RequestMethod.POST})
	@ResponseBody
	public AjaxResult<T> insert(@RequestBody T record){
		AjaxResult<T> ajax = new AjaxResult<T>();
		BaseEntity baseEntity = (BaseEntity)record;
		baseEntity.setId(UUID.randomUUID().toString());
		int flag = service.insert(record);
		if(flag == 0){
			ajax.setStatus("500");
			ajax.setMessage("插入失败");
		}else{
			ajax.setStatus("200");
			ajax.setMessage("插入成功");
			ajax.setObject(service.selectByPrimaryKey(baseEntity.getId()));
		}
		return ajax;
	}
	
	@RequestMapping(value = "/selectOne.do",method={RequestMethod.POST})
	@ResponseBody
	public T selectOne(@RequestBody T record){
		List<T> records = service.select(record);
		if(null == records || records.size() == 0 ){
			return null;
		}
		return records.get(0);
	}
	
	@RequestMapping(value = "/updateSelective.do",method={RequestMethod.POST})
	@ResponseBody
	public AjaxResult<T> updateSelective(@RequestBody T record){
		BaseEntity baseEntity = (BaseEntity) record;
		AjaxResult<T> ajax = new AjaxResult<T>();
		int flag = service.updateByPrimaryKeySelective(record);
		if(flag == 0){
			ajax.setStatus("500");
			ajax.setMessage("更新失败");
		}else{
			ajax.setStatus("200");
			ajax.setMessage("更新成功");
			ajax.setObject(service.selectByPrimaryKey(baseEntity.getId()));
		}
		return ajax;
	}
	
	@RequestMapping(value = "/update.do",method={RequestMethod.POST})
	@ResponseBody
	public AjaxResult<T> update(@RequestBody T record){
		BaseEntity baseEntity = (BaseEntity) record;
		AjaxResult<T> ajax = new AjaxResult<T>();
		int flag = service.updateByPrimaryKey(record);
		if(flag == 0){
			ajax.setStatus("500");
			ajax.setMessage("更新失败");
		}else{
			ajax.setStatus("200");
			ajax.setMessage("更新成功");
			ajax.setObject(service.selectByPrimaryKey(baseEntity.getId()));
		}
		return ajax;
	}
	
	@RequestMapping(value = "/delete.do",method={RequestMethod.GET})
	@ResponseBody
	public AjaxResult<T> delete(T record){
		AjaxResult<T> ajax = new AjaxResult<T>();
		int flag = service.deleteByPrimaryKey(record);
		if(flag == 0){
			ajax.setStatus("500");
			ajax.setMessage("删除失败");
		}else{
			ajax.setStatus("200");
			ajax.setMessage("删除成功");
		}
		return ajax;
	}
	
	@RequestMapping(value = "/getQueryByPage.do")
	@ResponseBody
	public PageInfo<T> getQueryByPage(T record, PageInfo<T> page){
		return service.getQueryByPage(record, page);
	}

	@RequestMapping(value = "/getLists.do")
	@ResponseBody
	public List<T> getList(T record){
		return service.select(record);
	}
}
