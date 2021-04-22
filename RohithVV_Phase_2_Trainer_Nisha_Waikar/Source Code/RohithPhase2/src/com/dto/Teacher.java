package com.dto;

public class Teacher {
	private int tID;
	private String tName;
	public Teacher() {
		// TODO Auto-generated constructor stub
	}
	public int gettID() {
		return tID;
	}
	public void settID(int tID) {
		this.tID = tID;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	@Override
	public String toString() {
		return "Teacher [tID=" + tID + ", tName=" + tName + "]";
	}
	
	
	
	
}
