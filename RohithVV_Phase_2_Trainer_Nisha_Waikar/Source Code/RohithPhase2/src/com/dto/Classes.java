package com.dto;

public class Classes {
	private int classID;
	private Integer std;
	private String div;
	public Classes() {
		
	}
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	public Integer getStd() {
		return std;
	}
	public void setStd(int std) {
		this.std = std;
	}
	public String getDiv() {
		return div;
	}
	public void setDiv(String div) {
		this.div = div;
	}
	@Override
	public String toString() {
		return "Classes [classID=" + classID + ", std=" + std + ", div=" + div + "]";
	}
	
	
}
