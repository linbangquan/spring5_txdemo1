package com.lbq.spring5.tx.dto;

public class Account {

	private String id;
	private String username;
	private String money;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", money=" + money + "]";
	}
}
