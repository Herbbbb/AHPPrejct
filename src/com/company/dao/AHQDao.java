package com.company.dao;

import java.util.List;

import com.company.bean.Bean;
import com.company.bean.Pojo;

public interface AHQDao{
	
	//增加
	void insert(Bean bean);
	//查询
	List<Bean> select();
	
}
