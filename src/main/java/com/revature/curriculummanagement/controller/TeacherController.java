package com.revature.curriculummanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.TeacherNotFoundException;
import com.revature.curriculummanagement.model.Teacher;
import com.revature.curriculummanagement.service.TeacherServiceImpl;

public class TeacherController {
	TeacherServiceImpl teacherServiceImpl = new TeacherServiceImpl();

	public void addTeacherDetails(Teacher teacher) throws SQLException, IOException {
		teacherServiceImpl.addTeacherDetails(teacher);
	}

	public List<Teacher> getTeacherDetails() throws NumberFormatException, IOException, SQLException {
		return teacherServiceImpl.getTeacherDetails();
	}

	public void updateTeacherDetails(Integer updateId)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		teacherServiceImpl.updateTeacherDetails(updateId);
	}

	public void deleteTeacherDetails(Integer deleteId)
			throws NumberFormatException, IOException, SQLException, TeacherNotFoundException {
		teacherServiceImpl.deleteTeacherDetails(deleteId);
	}

	public List<Teacher> getParticularTeacherDetails(Integer fetchId)
			throws NumberFormatException, IOException, SQLException, TeacherNotFoundException {
		return teacherServiceImpl.getParticularTeacherDetails(fetchId);
	}
}
