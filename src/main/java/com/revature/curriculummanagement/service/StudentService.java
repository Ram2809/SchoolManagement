package com.revature.curriculummanagement.service;

import com.revature.curriculummanagement.model.Student;

public interface StudentService {
	void addStudentDetails(Student student);

	void getStudentDetails(Student student);
	void updateStudentDetails(Student student);
}
