package com.revature.curriculummanagement.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.TeacherNotFoundException;
import com.revature.curriculummanagement.model.Teacher;

public interface TeacherDAO {
	void addTeacherDetails(Teacher teacher);

	void updateTeacherDetails(Integer updateId) throws SQLException, IOException;

	void deleteTeacherDetails(Integer deleteId) throws SQLException, IOException, TeacherNotFoundException;

	List<Teacher> getTeacherDetails() throws SQLException, IOException;

	List<Teacher> getParticularTeacherDetails(Integer fetchId)
			throws SQLException, IOException, TeacherNotFoundException;

	void getTeacherDetailsByClassRoom(Integer roomNo);
}
