package com.revature.curriculummanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.model.Discussion;
import com.revature.curriculummanagement.service.DiscussionServiceImpl;


public class DiscussionController {
	DiscussionServiceImpl discussionServiceImpl = new DiscussionServiceImpl();

	public void addDiscussionDetails(Discussion discussion) throws SQLException, IOException {
		discussionServiceImpl.addDiscussionDetails(discussion);
	}

	/*public List<Student> getStudentDetails() throws NumberFormatException, IOException, SQLException {
		return studentServiceImpl.getStudentDetails();
	}

	public void updateStudentDetails(Integer updateId)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		studentServiceImpl.updateStudentDetails(updateId);
	}

	public void deleteStudentDetails(Integer deleteId)
			throws NumberFormatException, IOException, SQLException, StudentNotFoundException {
		studentServiceImpl.deleteStudentDetails(deleteId);
	}

	public List<Student> getParticularStudentDetails(Integer fetchId)
			throws NumberFormatException, IOException, SQLException, StudentNotFoundException {
		return studentServiceImpl.getParticularStudentDetails(fetchId);
	}*/
}
