package com.company.bean;

public class Pojo {

	//商务部
	private int business_price;
	private int business_time;
	private int business_times;
	//技术部
	private int tech_radius;
	private int tech_distance;
	private int tech_server_quan;
	private int tech_product_quan;
	private int tech_time;
	private int tech_type;
	private int tech_diploma;
	private int tech_money;
	private int tech_year;
	private int tech_proportion;
	//信誉部
	private String credit_level;
	private int credit_disputes;
	private int credit_appoint;
	
	public Pojo() {
		// TODO Auto-generated constructor stub
	}

	
	public Pojo(int business_price, int business_time, int business_times,
			int tech_radius, int tech_distance, int tech_server_quan,
			int tech_product_quan, int tech_time, int tech_type,
			int tech_diploma, int tech_money, int tech_year,
			int tech_proportion, String credit_level, int credit_disputes,
			int credit_appoint) {
		super();
		this.business_price = business_price;
		this.business_time = business_time;
		this.business_times = business_times;
		this.tech_radius = tech_radius;
		this.tech_distance = tech_distance;
		this.tech_server_quan = tech_server_quan;
		this.tech_product_quan = tech_product_quan;
		this.tech_time = tech_time;
		this.tech_type = tech_type;
		this.tech_diploma = tech_diploma;
		this.tech_money = tech_money;
		this.tech_year = tech_year;
		this.tech_proportion = tech_proportion;
		this.credit_level = credit_level;
		this.credit_disputes = credit_disputes;
		this.credit_appoint = credit_appoint;
	}


	public int getBusiness_price() {
		return business_price;
	}

	public void setBusiness_price(int business_price) {
		this.business_price = business_price;
	}

	public int getBusiness_time() {
		return business_time;
	}

	public void setBusiness_time(int business_time) {
		this.business_time = business_time;
	}

	public int getBusiness_times() {
		return business_times;
	}

	public void setBusiness_times(int business_times) {
		this.business_times = business_times;
	}

	public int getTech_radius() {
		return tech_radius;
	}

	public void setTech_radius(int tech_radius) {
		this.tech_radius = tech_radius;
	}

	public int getTech_distance() {
		return tech_distance;
	}

	public void setTech_distance(int tech_distance) {
		this.tech_distance = tech_distance;
	}

	public int getTech_server_quan() {
		return tech_server_quan;
	}

	public void setTech_server_quan(int tech_server_quan) {
		this.tech_server_quan = tech_server_quan;
	}

	public int getTech_product_quan() {
		return tech_product_quan;
	}

	public void setTech_product_quan(int tech_product_quan) {
		this.tech_product_quan = tech_product_quan;
	}

	public int getTech_time() {
		return tech_time;
	}

	public void setTech_time(int tech_time) {
		this.tech_time = tech_time;
	}

	public int getTech_type() {
		return tech_type;
	}

	public void setTech_type(int tech_type) {
		this.tech_type = tech_type;
	}

	public int getTech_diploma() {
		return tech_diploma;
	}

	public void setTech_diploma(int tech_diploma) {
		this.tech_diploma = tech_diploma;
	}

	public int getTech_money() {
		return tech_money;
	}

	public void setTech_money(int tech_money) {
		this.tech_money = tech_money;
	}

	public int getTech_year() {
		return tech_year;
	}

	public void setTech_year(int tech_year) {
		this.tech_year = tech_year;
	}

	public int getTech_proportion() {
		return tech_proportion;
	}

	public void setTech_proportion(int tech_proportion) {
		this.tech_proportion = tech_proportion;
	}

	public String getCredit_level() {
		return credit_level;
	}

	public void setCredit_level(String credit_level) {
		this.credit_level = credit_level;
	}

	public int getCredit_disputes() {
		return credit_disputes;
	}

	public void setCredit_disputes(int credit_disputes) {
		this.credit_disputes = credit_disputes;
	}

	public int getCredit_appoint() {
		return credit_appoint;
	}

	public void setCredit_appoint(int credit_appoint) {
		this.credit_appoint = credit_appoint;
	}

	@Override
	public String toString() {
		return "Pojo [business_price=" + business_price + ", business_time="
				+ business_time + ", business_times=" + business_times
				+ ", tech_radius=" + tech_radius + ", tech_distance="
				+ tech_distance + ", tech_server_quan=" + tech_server_quan
				+ ", tech_product_quan=" + tech_product_quan + ", tech_time="
				+ tech_time + ", tech_type=" + tech_type + ", tech_diploma="
				+ tech_diploma + ", tech_money=" + tech_money + ", tech_year="
				+ tech_year + ", tech_proportion=" + tech_proportion
				+ ", credit_level=" + credit_level + ", credit_disputes="
				+ credit_disputes + ", credit_appoint=" + credit_appoint + "]";
	}
	
	
}
