package com.dto;

public class Student {
	private int stID;
	private String StName;
	private int classID;
	public Student() {
		
	}
	
	public int getStID() {
		return stID;
	}

	public void setStID(int stID) {
		this.stID = stID;
	}

	public String getStName() {
		return StName;
	}

	public void setStName(String StName) {
		this.StName = StName;
	}

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	@Override
	public String toString() {
		return "Student [stID=" + stID + ", StName=" + StName + ", classID=" + classID + "]";
	}
	
	
	
}
