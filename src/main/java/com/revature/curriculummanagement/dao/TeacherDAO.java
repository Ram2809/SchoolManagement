package com.revature.curriculummanagement.dao;

import java.util.List;

import com.revature.curriculummanagement.exception.DatabaseException;
import com.revature.curriculummanagement.model.Teacher;

public interface TeacherDAO {
	void addTeacherDetails(Teacher teacher);

	void updateTeacherDetails(Integer id) throws DatabaseException;

	void deleteTeacherDetails(Integer id) throws DatabaseException;

	List<Teacher> getTeacherDetails();

	List<Teacher> getParticularTeacherDetails(Integer id) throws DatabaseException;

	void getTeacherDetailsByClassRoom(Integer roomNo);
}
