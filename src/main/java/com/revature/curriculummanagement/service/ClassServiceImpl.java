package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.dao.ClassDAOImpl;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.model.Classes;

public class ClassServiceImpl implements ClassService {

	ClassDAOImpl classDAOImpl = new ClassDAOImpl();
	static Logger logger = Logger.getLogger("ClassServiceImpl.class");

	public void addClassDetails(Classes classes) throws SQLException, IOException {
		logger.info("In class DAO -> add method");
		classDAOImpl.addClassDetails(classes);
	}

	public void updateClassDetails(Integer roomNo)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		logger.info("In class DAO -> update method");
		classDAOImpl.updateClassDetails(roomNo);
	}

	public void deleteClassDetails(Integer roomNo) throws NumberFormatException, IOException, SQLException {
		logger.info("In class DAO -> delete method");
		classDAOImpl.deleteClassDetails(roomNo);
	}

	public List<Classes> getClassDetails() throws SQLException, IOException {
		logger.info("In class DAO -> get method");
		return classDAOImpl.getClassDetails();
	}

}