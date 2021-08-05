package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.BusinessServiceException;
import com.revature.curriculummanagement.exception.DatabaseException;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.model.Classes;

public interface ClassService {
	void addClassDetails(Classes classes) throws DatabaseException, BusinessServiceException;

	void updateClassDetails(Integer roomNo)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException;

	void deleteClassDetails(Integer roomNo) throws NumberFormatException, IOException, SQLException;

	List<Classes> getClassDetails() throws SQLException, IOException;
}