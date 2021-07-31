package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.curriculummanagement.dao.HeadMasterDAOImpl;
import com.revature.curriculummanagement.model.HeadMaster;

public class HeadMasterServiceImpl implements HeadMasterService {
	HeadMasterDAOImpl headMasterDAOImpl = new HeadMasterDAOImpl();

	public void addHeadMasterDetails(HeadMaster headMaster) throws SQLException, IOException {
		headMasterDAOImpl.addHeadMasterDetails(headMaster);
	}

	public void updateHeadMasterDetails(Integer updateId, String newName) throws SQLException, IOException {
		headMasterDAOImpl.updateHeadMasterDetails(updateId, newName);
	}

	public void deleteHeadMasterDetails(Integer deleteId) throws SQLException, IOException {
		headMasterDAOImpl.deleteHeadMasterDetails(deleteId);
	}

	public List<HeadMaster> getHeadMasterDetails() throws SQLException, IOException {
		return headMasterDAOImpl.getHeadMasterDetails();
	}
}
