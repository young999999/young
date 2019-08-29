package com.py.springcloud.dao;

import java.util.List;

import com.py.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import com.py.springcloud.entities.Dept;

@Mapper
public interface DeptDao
{
	public boolean addDept(Dept dept);

	public Dept findById(Long id);

	public List<Dept> findAll();
}