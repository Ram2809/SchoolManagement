package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.dao.TopicsDAOImpl;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.TopicNotFoundException;
import com.revature.curriculummanagement.model.Topics;

public class TopicsServiceImpl implements TopicsService{
	TopicsDAOImpl topicsDAOImpl = new TopicsDAOImpl();

	public void addTopicsDetails(Topics topics) throws SQLException, IOException {
		topicsDAOImpl.addTopicsDetails(topics);
	}

	public void updateTopicsDetails(String unitNo)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		topicsDAOImpl.updateTopicsDetails(unitNo);
	}

	public void deleteTopicsDetails(String unitNo)
			throws NumberFormatException, IOException, SQLException, TopicNotFoundException {
		topicsDAOImpl.deleteTopicsDetails(unitNo);
	}

	public List<Topics> getTopicsDetails() throws NumberFormatException, IOException, SQLException {
		return topicsDAOImpl.getTopicsDetails();
	}

	public List<Topics> getParticularTopicDetails(String unitNo)
			throws NumberFormatException, IOException, SQLException, TopicNotFoundException {
		return topicsDAOImpl.getParticularTopicDetails(unitNo);
	}
}
