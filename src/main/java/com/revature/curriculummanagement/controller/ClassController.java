package com.revature.curriculummanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.exception.ControllerException;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.model.Classes;
import com.revature.curriculummanagement.service.ClassService;
import com.revature.curriculummanagement.service.ClassServiceImpl;

public class ClassController {
	static ClassService classServiceImpl = new ClassServiceImpl();
	static Logger logger = Logger.getLogger("ClassController.class");

	public void addClassDetails(Classes classes) {
		logger.info("In class service -> add method");
		classServiceImpl.addClassDetails(classes);
	}

	public static List<Classes> getClassDetails() {
		logger.info("In class service -> get method");
		return classServiceImpl.getClassDetails();
	}

	public void updateClassDetails(Integer roomNo) throws ControllerException {
		logger.info("In class service -> update method");
		try {
			classServiceImpl.updateClassDetails(roomNo);
		} catch (BusinessServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	public void deleteClassDetails(Integer roomNo) {
		logger.info("In class service -> delete method");
		classServiceImpl.deleteClassDetails(roomNo);
	}
}
