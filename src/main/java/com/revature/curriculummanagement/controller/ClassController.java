package com.revature.curriculummanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.model.Classes;
import com.revature.curriculummanagement.service.ClassServiceImpl;

public class ClassController {
	static ClassServiceImpl classServiceImpl = new ClassServiceImpl();

	public void addClassDetails(Classes classes) throws SQLException, IOException {
		classServiceImpl.addClassDetails(classes);
	}

	public static List<Classes> getClassDetails() throws SQLException, IOException {
		return classServiceImpl.getClassDetails();
	}

	public void updateClassDetails(Integer roomNo)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		classServiceImpl.updateClassDetails(roomNo);
	}

	public void deleteClassDetails(Integer roomNo) throws NumberFormatException, IOException, SQLException {
		classServiceImpl.deleteClassDetails(roomNo);
	}
}
