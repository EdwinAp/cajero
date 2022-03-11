package com.azteca.cajero.dao.models.pojos;

public class IdentifyUser {
	
	private String username;
	private String numbertarget;
	private Double amount;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNumbertarget() {
		return numbertarget;
	}
	public void setNumbertarget(String numbertarget) {
		this.numbertarget = numbertarget;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "IdentifyUser [username=" + username + ", numbertarget=" + numbertarget + ", amount=" + amount + "]";
	}

}
