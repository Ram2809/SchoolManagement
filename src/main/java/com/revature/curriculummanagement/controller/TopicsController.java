package com.revature.curriculummanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.TopicNotFoundException;
import com.revature.curriculummanagement.model.Topics;
import com.revature.curriculummanagement.service.TopicsServiceImpl;

public class TopicsController {
	TopicsServiceImpl topicsServiceImpl = new TopicsServiceImpl();

	public void addTopicsDetails(Topics topics) throws SQLException, IOException {
		topicsServiceImpl.addTopicsDetails(topics);
	}

	public List<Topics> getTopicsDetails() throws NumberFormatException, IOException, SQLException {
		return topicsServiceImpl.getTopicsDetails();
	}

	public void updateTopicsDetails(String unitNo)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		topicsServiceImpl.updateTopicsDetails(unitNo);
	}

	public void deleteTopicsDetails(String unitNo)
			throws NumberFormatException, IOException, SQLException, TopicNotFoundException {
		topicsServiceImpl.deleteTopicsDetails(unitNo);
	}

	public List<Topics> getParticularTopicDetails(String unitNo)
			throws NumberFormatException, IOException, SQLException, TopicNotFoundException {
		return topicsServiceImpl.getParticularTopicDetails(unitNo);
	}
}
