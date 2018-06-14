package com.company.dao.impl;

import java.util.List;
import com.company.bean.Pojo;
import com.company.dao.BaseDao;
import com.company.dao.PojoDao;

public class PojoDaoImpl extends BaseDao<Pojo> implements PojoDao{

	@Override
	public Pojo selectServer() {
		String sql = "select * from server where id = '1'";
		return queryForOne(sql);
	}

	
}
