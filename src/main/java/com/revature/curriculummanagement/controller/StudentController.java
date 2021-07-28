package com.revature.curriculummanagement.controller;

import java.io.IOException;

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

	public void updateStudentDetails(Student student) throws NumberFormatException, IOException {
		studentServiceImpl.updateStudentDetails(student);
	}

	public void deleteStudentDetails(Student student) throws NumberFormatException, IOException {
		studentServiceImpl.deleteStudentDetails(student);
	}
}
