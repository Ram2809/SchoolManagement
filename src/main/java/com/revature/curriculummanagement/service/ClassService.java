package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.model.Classes;
import com.revature.curriculummanagement.model.HeadMaster;

public interface ClassService {
	void addClassDetails(Classes classes) throws SQLException, IOException;

	void updateClassDetails(Integer roomNo)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException;

	void deleteClassDetails(Integer roomNo) throws NumberFormatException, IOException, SQLException;

	List<Classes> getClassDetails() throws SQLException, IOException;
}