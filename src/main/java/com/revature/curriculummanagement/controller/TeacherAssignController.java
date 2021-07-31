package com.revature.curriculummanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.exception.TeacherNotFoundException;
import com.revature.curriculummanagement.model.TeacherDetails;
import com.revature.curriculummanagement.service.TeacherAssignServiceImpl;

public class TeacherAssignController {
	TeacherAssignServiceImpl teacherAssignServiceImpl = new TeacherAssignServiceImpl();

	public void addTeacherAssignDetails(TeacherDetails teacherDetails) throws SQLException, IOException {
		teacherAssignServiceImpl.addTeacherAssignDetails(teacherDetails);
	}

	public List<TeacherDetails> getTeacherAssignDetails() throws NumberFormatException, IOException, SQLException {
		return teacherAssignServiceImpl.getTeacherAssignDetails();
	}

	public void updateTeacherAssignDetails(Integer teacherId)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		teacherAssignServiceImpl.updateTeacherAssignDetails(teacherId);
	}

	public void deleteTeacherAssignDetails(Integer teacherId)
			throws NumberFormatException, IOException, SQLException, StudentNotFoundException {
		teacherAssignServiceImpl.deleteTeacherAssignDetails(teacherId);
	}

	public List<TeacherDetails> getParticularTeacherAssignDetails(Integer teacherId) throws NumberFormatException,
			IOException, SQLException, StudentNotFoundException, TeacherNotFoundException {
		return teacherAssignServiceImpl.getParticularTeacherAssignDetails(teacherId);
	}
}
