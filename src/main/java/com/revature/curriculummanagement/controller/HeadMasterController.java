package com.revature.curriculummanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.model.HeadMaster;
import com.revature.curriculummanagement.service.HeadMasterServiceImpl;

public class HeadMasterController {
	static HeadMasterServiceImpl headMasterServiceImpl = new HeadMasterServiceImpl();
	static Logger logger = Logger.getLogger("HeadMasterController.class");

	public static void addHeadMasterDetails(HeadMaster headMaster) throws SQLException, IOException {
		logger.info("In head master service -> add method");
		headMasterServiceImpl.addHeadMasterDetails(headMaster);
	}

	public static void updateHeadMasterDetails(Integer updateId, String newName) throws SQLException, IOException {
		logger.info("In head master service -> update method");
		headMasterServiceImpl.updateHeadMasterDetails(updateId, newName);
	}

	public static void deleteHeadMasterDetails(Integer deleteId) throws SQLException, IOException {
		logger.info("In head master service -> delete method");
		headMasterServiceImpl.deleteHeadMasterDetails(deleteId);
	}

	public static List<HeadMaster> getHeadMasterDetails() throws SQLException, IOException {
		logger.info("In head master service -> get method");
		return headMasterServiceImpl.getHeadMasterDetails();
	}
}
