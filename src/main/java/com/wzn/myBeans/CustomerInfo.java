package com.wzn.myBeans;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CustomerInfo {
	private int id;
	private String username;
	private int age;
	private String sex;
	private int money;

	// 一对多的映射
	private List<OrderInfo> orders = new ArrayList<>();
	
	//有参构造不需要设置id 和  集合   因为id对自动生成    集合会在后面添加数据进去
	public CustomerInfo(String username, int age, String sex, int money) {
		this.username = username;
		this.age = age;
		this.sex = sex;
		this.money = money;
	}

	public CustomerInfo() {
	}
}
