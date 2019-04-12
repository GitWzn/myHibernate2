package com.wzn.myBeans;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class AuthorInfo {
	private int id;
	private String name;
	private int age;
	
	//多对多的映射集合
	private List<BookInfo> books = new ArrayList<>();

	public AuthorInfo() {
	}
	
	public AuthorInfo(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
