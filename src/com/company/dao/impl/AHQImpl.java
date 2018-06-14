package com.company.dao.impl;

import java.sql.Date;
import java.util.List;

import com.company.bean.Bean;
import com.company.bean.Pojo;
import com.company.dao.AHQDao;
import com.company.dao.BaseDao;

public class AHQImpl extends BaseDao<Bean> implements AHQDao{

	Date date = new java.sql.Date(new java.util.Date().getTime());
	@Override
	public void insert(Bean bean) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO bean("
				+ "w1,w2,w3,w4,w5,w6,w7,w8,w9,w10,w11,w12,w13,w14,w15,w16,w17,w18,"
				+ "scorew1,scorew2,scorew3,scorew4,scorew5,scorew6,scorew7,scorew8,scorew9,scorew10,scorew11,scorew12,scorew13,scorew14,scorew15,"
				+ "totalScore,cr,time) "
				+ "VALUES"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		update(sql,
				bean.getW1(),bean.getW2(),bean.getW3(),bean.getW4(),bean.getW5(),
				bean.getW6(),bean.getW7(),bean.getW8(),bean.getW9(),bean.getW10(),
				bean.getW11(),bean.getW12(),bean.getW13(),bean.getW14(),bean.getW15(),
				bean.getW16(),bean.getW17(),bean.getW18(),
				bean.getScorew1(),bean.getScorew2(),bean.getScorew3(),bean.getScorew4(),
				bean.getScorew5(),bean.getScorew6(),bean.getScorew7(),bean.getScorew8(),
				bean.getScorew9(),bean.getScorew10(),bean.getScorew11(),bean.getScorew12(),
				bean.getScorew13(),bean.getScorew14(),bean.getScorew15(),
				bean.getTotalScore(),bean.getCR(),date);
	}

	@Override
	public List<Bean> select() {
		String sql = "select * from bean";
		return  queryForAll(sql);
	}

	
}
