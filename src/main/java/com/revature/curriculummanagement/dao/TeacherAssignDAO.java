package com.revature.curriculummanagement.dao;

import java.util.List;

import com.revature.curriculummanagement.exception.DatabaseException;
import com.revature.curriculummanagement.model.TeacherDetails;

public interface TeacherAssignDAO {
	void addTeacherAssignDetails(TeacherDetails teacherDetails);

	void updateTeacherAssignDetails(Integer teacherId) throws DatabaseException;

	void deleteTeacherAssignDetails(Integer teacherId) throws DatabaseException;

	List<TeacherDetails> getTeacherAssignDetails();

	List<TeacherDetails> getParticularTeacherAssignDetails(Integer teacherId) throws DatabaseException;
}
