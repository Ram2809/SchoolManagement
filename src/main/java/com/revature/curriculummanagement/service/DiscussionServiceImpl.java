package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.dao.DiscussionDAOImpl;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.model.Discussion;
import com.revature.curriculummanagement.model.Student;

public class DiscussionServiceImpl {
	DiscussionDAOImpl discussionDAOImpl=new DiscussionDAOImpl();
	public void addDiscussionDetails(Discussion discussion) throws SQLException, IOException {
		discussionDAOImpl.addDiscussionDetails(discussion);
	}

	/*public void updateStudentDetails(Integer updateId)
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
	}*/

}
