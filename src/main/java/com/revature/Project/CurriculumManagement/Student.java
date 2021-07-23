package com.revature.Project.CurriculumManagement;

public class Student {
	Integer StudentRollNo;
	String studentName;
	String studentDOB;
	String studentStd;
	String studentAddress;
	public Student(Integer studentRollNo, String studentName, String studentDOB, String studentStd,
			String studentAddress) {
		super();
		this.StudentRollNo = studentRollNo;
		this.studentName = studentName;
		this.studentDOB = studentDOB;
		this.studentStd = studentStd;
		this.studentAddress = studentAddress;
	}
}
