package com.revature.curriculummanagement.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.model.Classes;

public interface ClassDAO {
	void addClassDetails(Classes classes) throws SQLException, IOException;

	void updateClassDetails(Integer roomNo) throws SQLException, IOException;

	void deleteClassDetails(Integer roomNo) throws SQLException, IOException;

	List<Classes> getClassDetails() throws SQLException, IOException;
}
