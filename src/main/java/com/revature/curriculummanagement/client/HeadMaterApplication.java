package com.revature.curriculummanagement.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.revature.curriculummanagement.controller.HeadMasterController;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.model.HeadMaster;

public class HeadMaterApplication {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static HeadMaster headMaster = new HeadMaster();
	static HeadMasterController headMasterController = new HeadMasterController();
	static List<HeadMaster> headMasterList = new ArrayList<>();

	public static void insertHeadMaster() throws NumberFormatException, IOException, SQLException {
		System.out.println("Enter the head master details:");
		System.out.println("Enter the head master id:");
		Integer id = Integer.parseInt(bufferedReader.readLine());
		System.out.println("Enter the head master name:");
		String name = bufferedReader.readLine();
		headMaster.setId(id);
		headMaster.setName(name);
		headMasterController.addHeadMasterDetails(headMaster);
	}

	public static void updateHeadMaster() throws IOException, SQLException {
		System.out.println("Enter the id:");
		Integer updateId = Integer.parseInt(bufferedReader.readLine());
		System.out.println("Enter the new name:");
		String newName = bufferedReader.readLine();
		headMasterController.updateHeadMasterDetails(updateId, newName);
	}

	public static void deleteHeadMaster() throws SQLException, IOException {
		System.out.println("Enter the id:");
		Integer deleteId = Integer.parseInt(bufferedReader.readLine());
		headMasterController.deleteHeadMasterDetails(deleteId);
	}

	public static void getHeadMaster() throws SQLException, IOException {
		headMasterList = headMasterController.getHeadMasterDetails();
		Iterator<HeadMaster> headMasterIterator = headMasterList.iterator();
		while (headMasterIterator.hasNext()) {
			System.out.println(headMasterIterator.next());
		}
	}

	public static void main(String[] args)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		System.out.println("Head Master Application");
		while (true) {
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Retrieval");
			System.out.println("5.Exit");
			System.out.println("Enter your choice:");
			Integer userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
			case 1:
				insertHeadMaster();
				break;
			case 2:
				updateHeadMaster();
				break;
			case 3:
				deleteHeadMaster();
				break;
			case 4:
				getHeadMaster();
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
		}
	}
}
