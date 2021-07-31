package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.exception.TeacherNotFoundException;
import com.revature.curriculummanagement.model.TeacherDetails;

public interface TeacherAssignService {
	void addTeacherAssignDetails(TeacherDetails teacherDetails) throws SQLException, IOException;

	List<TeacherDetails> getTeacherAssignDetails() throws NumberFormatException, IOException, SQLException;

	void updateTeacherAssignDetails(Integer teacherId)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException;

	void deleteTeacherAssignDetails(Integer teacherId)
			throws NumberFormatException, IOException, SQLException, StudentNotFoundException;

	List<TeacherDetails> getParticularTeacherAssignDetails(Integer teacherId)
			throws NumberFormatException, IOException, SQLException, StudentNotFoundException, TeacherNotFoundException;
}
