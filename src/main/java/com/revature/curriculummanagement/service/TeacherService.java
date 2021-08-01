package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.TeacherNotFoundException;
import com.revature.curriculummanagement.model.Teacher;

public interface TeacherService {
	void addTeacherDetails(Teacher teacher);

	List<Teacher> getTeacherDetails() throws NumberFormatException, IOException, SQLException;

	void updateTeacherDetails(Integer updateId)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException;

	void deleteTeacherDetails(Integer deleteId)
			throws NumberFormatException, IOException, SQLException, TeacherNotFoundException;

	List<Teacher> getParticularTeacherDetails(Integer fetchId)
			throws NumberFormatException, IOException, SQLException, TeacherNotFoundException;

	void getTeacherDetailsByClassRoom(Integer roomNo);
}
