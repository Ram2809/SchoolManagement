package com.revature.curriculummanagement.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.dao.HeadMasterDAO;
import com.revature.curriculummanagement.dao.HeadMasterDAOImpl;
import com.revature.curriculummanagement.model.HeadMaster;

public class HeadMasterServiceImpl implements HeadMasterService {
	HeadMasterDAO headMasterDAOImpl = new HeadMasterDAOImpl();
	static Logger logger = Logger.getLogger("HeadMasterServiceImpl.class");

	public void addHeadMasterDetails(HeadMaster headMaster) throws SQLException, IOException {
		logger.info("In head master DAO -> add method");
		headMasterDAOImpl.addHeadMasterDetails(headMaster);
	}

	public void updateHeadMasterDetails(Integer id, String newName) throws SQLException, IOException {
		logger.info("In head master DAO -> update method");
		headMasterDAOImpl.updateHeadMasterDetails(id, newName);
	}

	public void deleteHeadMasterDetails(Integer id) throws SQLException, IOException {
		logger.info("In head master DAO -> delete method");
		headMasterDAOImpl.deleteHeadMasterDetails(id);
	}

	public List<HeadMaster> getHeadMasterDetails() throws SQLException, IOException {
		logger.info("In head master DAO -> get method");
		return headMasterDAOImpl.getHeadMasterDetails();
	}
}
