package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.dao.StudentDAOImpl;
import com.revature.curriculummanagement.dao.TeacherAssignDAOImpl;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.exception.TeacherNotFoundException;
import com.revature.curriculummanagement.model.Student;
import com.revature.curriculummanagement.model.TeacherDetails;

public class TeacherAssignServiceImpl implements TeacherAssignService{
	TeacherAssignDAOImpl teacherAssignDAOImpl = new TeacherAssignDAOImpl();

	public void addTeacherAssignDetails(TeacherDetails teacherDetails) throws SQLException, IOException {
		teacherAssignDAOImpl.addTeacherAssignDetails(teacherDetails);
	}

	public void updateTeacherAssignDetails(Integer teacherId)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		teacherAssignDAOImpl.updateTeacherAssignDetails(teacherId);
	}

	public void deleteTeacherAssignDetails(Integer teacherId)
			throws NumberFormatException, IOException, SQLException, StudentNotFoundException {
		teacherAssignDAOImpl.deleteTeacherAssignDetails(teacherId);
	}

	public List<TeacherDetails> getTeacherAssignDetails() throws NumberFormatException, IOException, SQLException {
		return teacherAssignDAOImpl.getTeacherAssignDetails();
	}

	public List<TeacherDetails> getParticularTeacherAssignDetails(Integer teacherId)
			throws NumberFormatException, IOException, SQLException, StudentNotFoundException, TeacherNotFoundException {
		return teacherAssignDAOImpl.getParticularTeacherAssignDetails(teacherId);
	}
	
}
