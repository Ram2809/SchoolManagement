package com.revature.curriculummanagement.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.DatabaseException;
import com.revature.curriculummanagement.model.Classes;

public interface ClassDAO {
	void addClassDetails(Classes classes);

	void updateClassDetails(Integer roomNo) throws DatabaseException;

	void deleteClassDetails(Integer roomNo);

	List<Classes> getClassDetails();
}
