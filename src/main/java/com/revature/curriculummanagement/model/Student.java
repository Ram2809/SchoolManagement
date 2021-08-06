package com.revature.curriculummanagement.model;

public class Student {
	private Integer rollNo;
	private String name;
	private String dob;
	private String address;
	private Integer classRoomNo;

	public Student() {
		super();
	}

	public Student(Integer rollNo, String name, String dob, String address, Integer classRoomNo) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.classRoomNo = classRoomNo;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dateOfBirth) {
		this.dob = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getClassRoomNo() {
		return classRoomNo;
	}

	public void setClassRoomNo(Integer classRoomNo) {
		this.classRoomNo = classRoomNo;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", dateOfBirth=" + dob + ", address=" + address
				+ ", classRoomNo=" + classRoomNo + "]";
	}

}
