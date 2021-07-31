package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.model.HeadMaster;

public interface HeadMasterService {
	void addHeadMasterDetails(HeadMaster headMaster) throws SQLException, IOException;

	void updateHeadMasterDetails(Integer updateId, String newName) throws SQLException, IOException;

	void deleteHeadMasterDetails(Integer deleteId) throws SQLException, IOException;

	List<HeadMaster> getHeadMasterDetails() throws SQLException, IOException;
}
