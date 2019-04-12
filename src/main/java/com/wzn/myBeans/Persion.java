package com.wzn.myBeans;

import lombok.Data;

@Data
public class Persion {
	private int pid;
	private String name;
	private int age;
	private String sex;

	// 一对一
	private IDCard idCard = new IDCard();

	public Persion() {
	}

	public Persion(String name, int age, String number) {
		this.name = name;
		this.age = age;
//		this.sex = sex;
		this.idCard.setNumber(number);
	}
	public Persion(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
