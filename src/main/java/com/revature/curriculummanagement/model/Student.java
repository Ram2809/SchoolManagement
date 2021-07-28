package com.revature.curriculummanagement.model;

public class Student {
	private Integer rollNo;
	private String name;
	private String dateOfBirth;
	private String standard;
	private String address;

	public Student() {
		super();
	}

	public Student(Integer rollNo, String name, String dateOfBirth, String standard, String address) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.standard = standard;
		this.address = address;
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

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", standard="
				+ standard + ", address=" + address + "]";
	}

}
