package com.wzn.myBeans;

import lombok.Data;

@Data
public class IDCard {
	private int cid;
	private String number;
	private String address;

	// 一对一
	private Persion persion;

	public IDCard() {
	}

	public IDCard(String number, String address) {
		this.number = number;
		this.address = address;
	}

	@Override
	public String toString() {
		return "IDCard [id=" + cid + ", number=" + number + ", address=" + address + "]";
	}
}
