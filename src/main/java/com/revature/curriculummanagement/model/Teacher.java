package com.revature.curriculummanagement.model;

public class Teacher {
	private Integer id;
	private String name;
	private String dateOfBirth;
	private String address;
	private String qualification;
	private String designation;

	public Teacher() {
		super();
	}

	public Teacher(Integer id, String name, String dateOfBirth, String address, String qualification,
			String designation) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.qualification = qualification;
		this.designation = designation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", address=" + address
				+ ", qualification=" + qualification + ", designation=" + designation + "]";
	}

}
