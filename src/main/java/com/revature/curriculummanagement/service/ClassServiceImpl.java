package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.revature.curriculummanagement.dao.ClassDAOImpl;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.model.Classes;

public class ClassServiceImpl implements ClassService {

	ClassDAOImpl classDAOImpl = new ClassDAOImpl();

	public void addClassDetails(Classes classes) throws SQLException, IOException {
		classDAOImpl.addClassDetails(classes);
	}

	public void updateClassDetails(Integer roomNo)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		classDAOImpl.updateClassDetails(roomNo);
	}

	public void deleteClassDetails(Integer roomNo) throws NumberFormatException, IOException, SQLException {
		classDAOImpl.deleteClassDetails(roomNo);
	}

	public List<Classes> getClassDetails() throws SQLException, IOException {
		return classDAOImpl.getClassDetails();
	}

}