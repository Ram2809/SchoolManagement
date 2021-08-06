package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.dao.ClassDAO;
import com.revature.curriculummanagement.dao.ClassDAOImpl;
import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.exception.DatabaseException;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.model.Classes;

public class ClassServiceImpl implements ClassService {

	ClassDAO classDAOImpl = new ClassDAOImpl();
	static Logger logger = Logger.getLogger("ClassServiceImpl.class");

	public void addClassDetails(Classes classes) {
		logger.info("In class DAO -> add method");
		classDAOImpl.addClassDetails(classes);

	}

	public void updateClassDetails(Integer roomNo) throws BusinessServiceException {
		logger.info("In class DAO -> update method");
		try {
			classDAOImpl.updateClassDetails(roomNo);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

	public void deleteClassDetails(Integer roomNo) {
		logger.info("In class DAO -> delete method");
		classDAOImpl.deleteClassDetails(roomNo);
	}

	public List<Classes> getClassDetails() {
		logger.info("In class DAO -> get method");
		return classDAOImpl.getClassDetails();
	}

}