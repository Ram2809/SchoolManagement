package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.TopicNotFoundException;
import com.revature.curriculummanagement.model.Topics;

public interface TopicsService {
	void addTopicsDetails(Topics topics) throws SQLException, IOException;

	List<Topics> getTopicsDetails() throws NumberFormatException, IOException, SQLException;

	void updateTopicsDetails(String unitNo)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException;

	void deleteTopicsDetails(String unitNo)
			throws NumberFormatException, IOException, SQLException, TopicNotFoundException;

	List<Topics> getParticularTopicDetails(String unitNo)
			throws NumberFormatException, IOException, SQLException, TopicNotFoundException;
}
