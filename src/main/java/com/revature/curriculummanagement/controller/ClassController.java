package com.revature.curriculummanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.model.Classes;
import com.revature.curriculummanagement.service.ClassServiceImpl;

public class ClassController {
	static ClassServiceImpl classServiceImpl = new ClassServiceImpl();
	static Logger logger = Logger.getLogger("ClassController.class");

	public void addClassDetails(Classes classes) throws SQLException, IOException {
		logger.info("In class service -> add method");
		classServiceImpl.addClassDetails(classes);
	}

	public static List<Classes> getClassDetails() throws SQLException, IOException {
		logger.info("In class service -> get method");
		return classServiceImpl.getClassDetails();
	}

	public void updateClassDetails(Integer roomNo)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		logger.info("In class service -> update method");
		classServiceImpl.updateClassDetails(roomNo);
	}

	public void deleteClassDetails(Integer roomNo) throws NumberFormatException, IOException, SQLException {
		logger.info("In class service -> delete method");
		classServiceImpl.deleteClassDetails(roomNo);
	}
}
