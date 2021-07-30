package com.revature.curriculummanagement.controller;

import java.io.IOException;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.model.Classes;
import com.revature.curriculummanagement.model.Student;
import com.revature.curriculummanagement.service.ClassServiceImpl;
import com.revature.curriculummanagement.service.StudentServiceImpl;

public class ClassController {
	ClassServiceImpl classServiceImpl = new ClassServiceImpl();

	public void addclassDetails(Classes classes) {
		classServiceImpl.addClassDetails(classes);
	}

	public void getClassDetails(Classes classes) {
		classServiceImpl.getClassDetails(classes);
	}

	public void updateClassDetails(Classes classes)
			throws NumberFormatException, IOException, InvalidChoiceException {
		classServiceImpl.updateClassDetails(classes);
	}

	public void deleteClassDetails(Classes classes) throws NumberFormatException, IOException {
		classServiceImpl.deleteClassDetails(classes);
	}
}
