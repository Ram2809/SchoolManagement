package com.revature.curriculummanagement.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.exception.TopicNotFoundException;
import com.revature.curriculummanagement.model.Topics;

public interface TopicsDAO {
	void addTopicsDetails(Topics topics) throws SQLException, IOException;

	void updateTopicsDetails(String unitNo) throws SQLException, IOException;

	void deleteTopicsDetails(String unitNo) throws SQLException, IOException, TopicNotFoundException;

	List<Topics> getTopicsDetails() throws SQLException, IOException;

	List<Topics> getParticularTopicDetails(String unitNo) throws SQLException, IOException, TopicNotFoundException;
}
