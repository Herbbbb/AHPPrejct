package com.company.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.company.bean.Bean;
import com.company.bean.Pojo;
import com.company.dao.impl.AHQImpl;
import com.company.dao.impl.PojoDaoImpl;

public class aph_select {

	
	public static AHQImpl impl = new AHQImpl();
	public static PojoDaoImpl pojoImpl = new PojoDaoImpl();
	public static List<Bean> bean;
	public static Pojo pojo = pojoImpl.selectServer();
	
	
	
	public static void main(String[] args) {
		
		//25-60之间的元素是获取之前存储在数据库的各项权重
		Map<Object, Object> map1 = getAPH3();
		ArrayList<Double> list1 =  (ArrayList<Double>) map1.get("list1");
		//获取从数据库里查出来的四行数据里的三个w1
		//第三行被第四个表格占据，数据不奏效，不用获取
		double w11 = list1.get(0);
		double w21 = list1.get(1);
		double w41 = list1.get(3);
		System.out.println(list1);
		//获取w2
		ArrayList<Double> list2 =  (ArrayList<Double>) map1.get("list2");
		//获取从数据库里查出来的四行数据里的三个w2
		//第三行被第四个表格占据，数据不奏效，不用获取
		double w12 = list2.get(0);
		double w22 = list2.get(1);
		double w42 = list2.get(3);
		//获取w3
		ArrayList<Double> list3 =  (ArrayList<Double>) map1.get("list3");
		//获取从数据库里查出来的四行数据里的三个w3
		//第三行被第四个表格占据，数据不奏效，不用获取
		double w13 = list2.get(0);
		double w23 = list2.get(1);
		double w43 = list2.get(3);
		
		Map<Object, Object> map2 = getAPH9();
		ArrayList<Double> list5 =  (ArrayList<Double>) map2.get("list4");
		//对应第三张表--数据库第三行的4-12个元素
		double w34 = list5.get(0);
		double w35 = list5.get(0);
		double w36 = list5.get(0);
		double w37 = list5.get(0);
		double w38 = list5.get(0);
		double w39 = list5.get(0);
		double w310 = list5.get(0);
		double w311 = list5.get(0);
		double w312 = list5.get(0);
		
		
		//进行总分的计算
		//Step-1 计算商务标得分
		
		//Step-2 计算技术标得分
		
		//Step-3 计算信誉标得分
	}
	
	
	
	//获取aph_3的各项数据
	public static Map<Object, Object> getAPH3(){
		
		List<Double> list1 = new ArrayList<Double>();
		List<Double> list2 = new ArrayList<Double>();
		List<Double> list3 = new ArrayList<Double>();
		Map<Object, Object> map = new HashMap<>();
		bean = impl.select();
		for(int i = 0; i < bean.size(); i++){
			double w1 = bean.get(i).getW1();
			double w2 = bean.get(i).getW2();
			double w3 = bean.get(i).getW3();
			System.out.println(w1+"==="+w2+"==="+w3);
			list1.add(w1);
			list2.add(w2);
			list3.add(w3);
		}
		map.put("list1", list1);
		map.put("list2", list2);
		map.put("list3", list3);
		return map;
		
	}
	
	//获取aph_9的各项数据
//	@Test
	public static Map<Object, Object> getAPH9(){
		
		List<Double> list1 = new ArrayList<Double>();
		
		Map<Object, Object> map = new HashMap<>();
		
		bean = impl.select();
		
			double w4 = bean.get(2).getW4();
			double w5 = bean.get(2).getW5();
			double w6 = bean.get(2).getW6();
			double w7 = bean.get(2).getW7();
			double w8 = bean.get(2).getW8();
			double w9 = bean.get(2).getW9();
			double w10 = bean.get(2).getW10();
			double w11 = bean.get(2).getW11();
			double w12 = bean.get(2).getW12();
			
			list1.add(w4);
			list1.add(w5);
			list1.add(w6);
			list1.add(w7);
			list1.add(w8);
			list1.add(w9);
			list1.add(w10);
			list1.add(w11);
			list1.add(w12);
			
			map.put("list4", list1);
		
		return map;
		
	}
	
	//投标价格评分
//	@Test
	public static  int judgeScore(){
		//定义最优评价因素值1-2
		int judge1 = 0;
		int judge2 = 0;
		int totalJudge = 0;
//		System.out.println("===================");
		
		int business_price = pojo.getBusiness_price();
		int amount = pojo.getBusiness_times();
//		System.out.println(business_price);
		//存在预判价格
		if(!"0.0".equals(business_price)){
			judge1 = business_price;
		
			//报价数组长度是偶数
			if(("0").equals(amount/2)){
				//最优评价因素值2=报价数组（几家公司投标的数量）[数组长度/2]
				judge2 = amount/2;
			}
			else{
				//最优评价因素值2=(报价数组[(数组长度+1)/2]+ 报价数组[(数组长度-1)/2])/2
				judge2 = ((amount+1)/2+(amount-1)/2)/2;
			}
		}
		
		return totalJudge =(1-Math.abs(((business_price - judge1)/judge2)))*100;
	}
	
	//投标时间--评分
	public int getTime(){
		return pojo.getBusiness_time();
	}
	
	//评价次数--评分
	public int getJudgeTimes(){
		int times = pojo.getBusiness_times();
		int score = times*times;
		if(score>100){
			return 100;
		}else{
			return score;
		}
		
	}
	
	//服务半径--评分、
	public int getRadius(){
		//半径
		int radius = pojo.getTech_radius();
		//距离
		int distance = pojo.getTech_distance();
		int score = 0;
		//标书信息[项目地点]与供应商[服务半径]为空
		if(radius==0.0 && distance == 0.0){
			score = 0;
		}
		//标书信息[项目地点]不处于供应商[服务半径]之内
		else if(distance > radius){
			score = 0;
		}else{
			score = 100;
		}
		return score;
	}
	
	//服务质量--评分
//	@Test
	public int getServerQuan(){
		
		//获取服务质量值
		int serverQuan = pojo.getTech_server_quan();
		int score = 0;
		if(serverQuan<1){
			score = 0;
		}else if(serverQuan<2){
			score = 10;
		}else if(serverQuan<3){
			score = 30;
		}else if(serverQuan<4){
			score = 60;
		}else if(serverQuan<5){
			score = 80;
		}else if(serverQuan==5){
			score = 100;
		}
		return score;
	}
	
	//产品质量--评分
	public int getProductQuan(){
		
		int productQuan = pojo.getTech_product_quan();
		int score = 0;
		if(productQuan<1){
			score = 0;
		}else if(productQuan<2){
			score = 10;
		}else if(productQuan<3){
			score = 30;
		}else if(productQuan<4){
			score = 60;
		}else if(productQuan<5){
			score = 80;
		}else if(productQuan==5){
			score = 100;
		}
		return score;
		
	}
	
	//交货时间--评分
		public int getTechTime(){
			
			int time = pojo.getTech_time();
			int score = 0;
			if(time<1){
				score = 0;
			}else if(time < 2){
				score = 10;
			}else if(time<3){
				score = 30;
			}else if(time<4){
				score = 60;
			}else if(time<5){
				score = 80;
			}
			else if(time==5){
				score = 100;
			}
			return score;
			
		}
	
	//企业类型--评分--直接读取
	public int getTechType(){
		return pojo.getTech_type();
	}
	
	//资质证书--评分
	public int getTechdiploma(){
		
		int amount = pojo.getTech_diploma();
		
		int score = 0;
		
		score = amount * 5;
		
		if(score > 100){
			return 100;
		}
		else
			return score;
	}
	
	//注册资金--评分
	public int getTechMoney(){
		
		int money = pojo.getTech_money();
		
		int score = 0;
		
		if(money < 50){
			score = 10;
		}else if(money<100){
			score = 20;
		}else{
			//大于一百万，每多一百万加五分。当评分超过此项评价值最优情况100分（百分制）时，统一视为评价值最优情况
			score = 20 + ((money-100)/100)*5;
			if(score <100){
				return score;
			}else 
				return score;
		}
		return score;
	}
	
	//成立年份--评分
	public int getTechYear(){
		
		int techYeay = pojo.getTech_year();
		
		int score = 0;
		
		if(techYeay<10){
			score = 10;
		}else if(techYeay<20){
			score = 20;
		}else{
			//超过二十年的公司，每多十年则加五分。如果评价值超过了此项的最优评价值则统一视为最优情况，得到最优评价。
			score = 20 + ((techYeay-20)/10)*5;
			if(score < 100){
				return score;
			}else
				return 100;
		}
		return score;
	}
	
	//中标次数--评分
	public int getTechProportion(){
		return pojo.getTech_proportion();
	}
	
	//合同履约率--评分
	public int getCreditAppoint(){
		return pojo.getCredit_appoint();
	}
	//资信评级
	public int getCreditLevel(){
		
		String level = pojo.getCredit_level();
		int score = 0;
		switch(level){
		
			case "AAA":
				score = 100;
				break;
				
			case "AA":
				score = 90;
				break;
				
			case "A":
				score = 80;
				break;
				
			case "BBB":
				score = 70;
				break;
				
			case "BB":
				score = 60;
				break;
				
			case "B":
				score = 50;
				break;
				
			case "CCC":
				score = 40;
				break;
				
			case "CC":
				score = 30;
				break;
				
			case "C":
				score = 20;
				break;
				
			case "D":
				score = 10;
				break;
		}
		return score;
		
	}
	
	//纠纷率--评分
	public int getCreditDisputis(){
		
		int disputis = pojo.getCredit_disputes();
		int score = 0;
		
		if(disputis==0){
			score = 100;
		}else{
			score = 1/disputis;
		}
		return score;
	}
}
