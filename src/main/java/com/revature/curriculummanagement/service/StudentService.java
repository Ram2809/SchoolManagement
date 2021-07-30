package com.revature.curriculummanagement.service;

import java.io.IOException;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.model.Student;

public interface StudentService {
	void addStudentDetails(Student student);

	void getStudentDetails(Student student);

	void updateStudentDetails(Student student) throws NumberFormatException, IOException, InvalidChoiceException;

	void deleteStudentDetails(Student student) throws NumberFormatException, IOException;
}
