package com.company.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import com.company.db.JDBCTools;


public class BaseDao<T> {
	
	QueryRunner queryRunner = null;
	Class<T> cls = null;
	public BaseDao(){
		queryRunner = new QueryRunner();
		Type type = this.getClass().getGenericSuperclass();
		if(type instanceof ParameterizedType){
			ParameterizedType parameterizedType = (ParameterizedType)type;
			Type[] types = parameterizedType.getActualTypeArguments();
			if(types[0] instanceof Class){
				cls = (Class<T>) types[0];
			}
		}
	}	
	//insert/delete/update
	public  void update(String sql,Object...objs){
		Connection conn = JDBCTools.getConnection();
		try {
			queryRunner.update(conn, sql, objs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// find
	public T queryForOne(String sql,Object...objs) {
		T t = null;
		Connection conn = JDBCTools.getConnection();
		try {
			t = queryRunner.query(conn, sql, new BeanHandler<>(cls), objs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	
	//findAll
	public List<T> queryForAll(String sql,Object...objs) {
		List<T> list = null;
		Connection conn = JDBCTools.getConnection();
		try {
			list = queryRunner.query(conn, sql,new BeanListHandler<>(cls),objs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//添加一个查找字段方法
	public T queryForColum(String sql,Object...objs){
		T t = null;
		Connection conn = JDBCTools.getConnection();
		try {
			t = (T) queryRunner.query(conn, sql,new ScalarHandler(),objs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
}
