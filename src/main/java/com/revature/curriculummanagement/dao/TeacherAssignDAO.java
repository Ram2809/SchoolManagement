package com.revature.curriculummanagement.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.exception.TeacherNotFoundException;
import com.revature.curriculummanagement.model.TeacherDetails;

public interface TeacherAssignDAO {
	void addTeacherAssignDetails(TeacherDetails teacherDetails) throws SQLException, IOException;

	void updateTeacherAssignDetails(Integer teacherId) throws SQLException, IOException;

	void deleteTeacherAssignDetails(Integer teacherId) throws SQLException, IOException, StudentNotFoundException;

	List<TeacherDetails> getTeacherAssignDetails() throws SQLException, IOException;

	List<TeacherDetails> getParticularTeacherAssignDetails(Integer teacherId)
			throws SQLException, IOException, StudentNotFoundException, TeacherNotFoundException;
}
