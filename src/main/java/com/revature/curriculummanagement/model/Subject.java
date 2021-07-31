package com.revature.curriculummanagement.model;

public class Subject {
	private Integer subId;
	private String subName;
	private Integer classId;

	public Subject() {
		super();
	}

	public Subject(Integer subId, String subName, Integer classId) {
		super();
		this.subId = subId;
		this.subName = subName;
		this.classId = classId;
	}

	public Integer getSubId() {
		return subId;
	}

	public void setSubId(Integer subId) {
		this.subId = subId;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	@Override
	public String toString() {
		return "Subject [subId=" + subId + ", subName=" + subName + ", classId=" + classId + "]";
	}

}
