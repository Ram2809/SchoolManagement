package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.revature.curriculummanagement.dao.StudentDAOImpl;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.model.Student;

public class StudentServiceImpl implements StudentService {
	StudentDAOImpl studentDAOImpl = new StudentDAOImpl();

	public void addStudentDetails(Student student) throws SQLException, IOException {
		studentDAOImpl.addStudentDetails(student);
	}

	public void updateStudentDetails(Integer updateId)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		studentDAOImpl.updateStudentDetails(updateId);
	}

	public void deleteStudentDetails(Integer deleteId)
			throws NumberFormatException, IOException, SQLException, StudentNotFoundException {
		studentDAOImpl.deleteStudentDetails(deleteId);
	}

	public List<Student> getStudentDetails() throws NumberFormatException, IOException, SQLException {
		return studentDAOImpl.getStudentDetails();
	}

	public List<Student> getParticularStudentDetails(Integer fetchId)
			throws NumberFormatException, IOException, SQLException, StudentNotFoundException {
		return studentDAOImpl.getParticularStudentDetails(fetchId);
	}

	public void getStudentDetailsByClassRoom(Integer roomNo) {
		studentDAOImpl.getStudentDetailsByClassRoom(roomNo);
	}

}