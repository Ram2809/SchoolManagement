package com.revature.curriculummanagement.controller;

import com.revature.curriculummanagement.model.Student;
import com.revature.curriculummanagement.service.StudentServiceImpl;

public class StudentController {
	StudentServiceImpl studentServiceImpl = new StudentServiceImpl();

	public void addStudentDetails(Student student) {
		studentServiceImpl.addStudentDetails(student);
	}

	public void getStudentDetails(Student student) {
		studentServiceImpl.getStudentDetails(student);
	}
	public void updateStudentDetails(Student student) {
		studentServiceImpl.updateStudentDetails(student);
	}
}
