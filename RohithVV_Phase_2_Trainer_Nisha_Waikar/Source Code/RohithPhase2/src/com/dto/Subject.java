package com.dto;

public class Subject {
	private int subID;
	private String subName;
	private int classID;
	private int tID;
	public Subject() {
		
	}
	public int getSubID() {
		return subID;
	}
	public void setSubID(int subID) {
		this.subID = subID;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	public int gettID() {
		return tID;
	}
	public void settID(int tID) {
		this.tID = tID;
	}
	@Override
	public String toString() {
		return "Subject [subID=" + subID + ", subName=" + subName + ", classID=" + classID + ", tID=" + tID + "]";
	}
	
	
}
