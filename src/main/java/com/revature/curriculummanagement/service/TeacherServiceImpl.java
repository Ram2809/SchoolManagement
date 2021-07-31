package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.dao.TeacherDAOImpl;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.exception.TeacherNotFoundException;
import com.revature.curriculummanagement.model.Student;
import com.revature.curriculummanagement.model.Teacher;

public class TeacherServiceImpl implements TeacherService{
	TeacherDAOImpl teacherDAOImpl=new TeacherDAOImpl();
	public void addTeacherDetails(Teacher teacher) {
		teacherDAOImpl.addTeacherDetails(teacher);
	}
	public void updateTeacherDetails(Integer updateId)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		teacherDAOImpl.updateTeacherDetails(updateId);
	}

	public void deleteTeacherDetails(Integer deleteId)
			throws NumberFormatException, IOException, SQLException, TeacherNotFoundException {
		teacherDAOImpl.deleteTeacherDetails(deleteId);
	}

	public List<Teacher> getTeacherDetails() throws NumberFormatException, IOException, SQLException {
		return teacherDAOImpl.getTeacherDetails();
	}

	public List<Teacher> getParticularTeacherDetails(Integer fetchId)
			throws NumberFormatException, IOException, SQLException,TeacherNotFoundException {
		return teacherDAOImpl.getParticularTeacherDetails(fetchId);
	}

}
