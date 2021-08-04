package com.revature.curriculummanagement.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.controller.HeadMasterController;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.QuestionNotFoundException;
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.exception.SubjectNotFoundException;
import com.revature.curriculummanagement.exception.TeacherNotFoundException;
import com.revature.curriculummanagement.model.HeadMaster;

public class HeadMaterApplication {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static HeadMaster headMaster = new HeadMaster();
	static HeadMasterController headMasterController = new HeadMasterController();
	static List<HeadMaster> headMasterList = new ArrayList<>();
	static Logger logger = Logger.getLogger("HeadMasterApplication.class");

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

	public static void performHMCRUD() throws NumberFormatException, IOException, SQLException, InvalidChoiceException {
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
				logger.info("In head master controller -> add method");
				insertHeadMaster();
				break;
			case 2:
				logger.info("In head master controller -> update method");
				updateHeadMaster();
				break;
			case 3:
				logger.info("In head master controller -> delete method");
				deleteHeadMaster();
				break;
			case 4:
				logger.info("In head master controller -> get method");
				getHeadMaster();
				break;
			case 5:
				logger.info("Exits from head master application");
				System.exit(0);
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
		}
	}

	public static void main(String[] args)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException, StudentNotFoundException,
			SubjectNotFoundException, TeacherNotFoundException, QuestionNotFoundException {
		System.out.println("Welcome to Head Master Section\n");
		while (true) {
			System.out.println("1.Head Master section");
			System.out.println("2.Student Section");
			System.out.println("3.Teacher Section");
			System.out.println("4.Class Section");
			System.out.println("5.Subject Section");
			System.out.println("6.Teacher Assign Section");
			System.out.println("7.Time Table Section");
			System.out.println("8.Discussion Section");
			System.out.println("9.Exit");
			System.out.println("Enter your choice:");
			int userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
			case 1:
				performHMCRUD();
				break;
			case 2:
				StudentApplication.main(args);
				break;
			case 3:
				TeacherApplication.main(args);
				break;
			case 4:
				ClassApplication.main(args);
				break;
			case 5:
				SubjectApplication.main(args);
				break;
			case 6:
				TeacherAssign.main(args);
				break;
			case 7:
				TimeTableApplication.main(args);
				break;
			case 8:
				DiscussionApplication.main(args);
				break;
			case 9:
				System.exit(0);
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
		}
	}
}
