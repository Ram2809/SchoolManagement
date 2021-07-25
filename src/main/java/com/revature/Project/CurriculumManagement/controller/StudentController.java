package com.revature.Project.CurriculumManagement.controller;

import com.revature.Project.CurriculumManagement.model.Student;
import com.revature.Project.CurriculumManagement.service.StudentServiceImpl;

public class StudentController {
	StudentServiceImpl studentServiceImpl = new StudentServiceImpl();

	public void addStudentDetails(Student student) {
		studentServiceImpl.addStudentDetails(student);
	}

	public void getStudentDetails(Student student) {
		studentServiceImpl.getStudentDetails(student);
	}
}
