package com.revature.curriculummanagement.model;

public class Student {
	private Integer rollNo;
	private String name;
	private String dateOfBirth;
	private String address;
	private Integer classRoomNo;

	public Student() {
		super();
	}

	public Student(Integer rollNo, String name, String dateOfBirth, String address, Integer classRoomNo) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
		return "Student [rollNo=" + rollNo + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", address=" + address
				+ ", classRoomNo=" + classRoomNo + "]";
	}

}
