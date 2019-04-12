package com.wzn.myBeans;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class BookInfo {
	private int id;
	private String bookName;
	private int price;

	private List<AuthorInfo> authors = new ArrayList<>();

	public BookInfo() {
	}

	public BookInfo(String bookName, int price) {
		this.bookName = bookName;
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookInfo [id=" + id + ", bookName=" + bookName + ", price=" + price + "]";
	}
}
