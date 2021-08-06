package com.revature.curriculummanagement.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.controller.ClassController;
import com.revature.curriculummanagement.exception.ControllerException;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.model.Classes;

public class ClassApplication {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static Classes classes = new Classes();
	static ClassController classController = new ClassController();
	static List<Classes> classList = new ArrayList<>();
	static Logger logger = Logger.getLogger("ClassApplication.class");

	public static void insertClass() {
		try {
			System.out.println("Enter the class details:");
			System.out.println("Enter the class room no.:");
			Integer classRoomNo = Integer.parseInt(bufferedReader.readLine());
			System.out.println("Enter the standard:");
			String standard = bufferedReader.readLine();
			System.out.println("Enter the section:");
			String section = bufferedReader.readLine();
			classes.setClassRoomNo(classRoomNo);
			classes.setStandard(standard);
			classes.setSection(section);
			classController.addClassDetails(classes);
		} catch (NumberFormatException | IOException e) {
			logger.info(e.getMessage());
		}
	}

	public static void updateClass() {
		try {
			System.out.println("Enter the class room no:");
			Integer roomNo = Integer.parseInt(bufferedReader.readLine());
			classController.updateClassDetails(roomNo);
		} catch (NumberFormatException | IOException | ControllerException e) {
			logger.info(e.getMessage());
		}
	}

	public static void deleteClass() {
		try {
			System.out.println("Enter the room no:");
			Integer roomNo = Integer.parseInt(bufferedReader.readLine());
			classController.deleteClassDetails(roomNo);
		} catch (NumberFormatException | IOException e) {
			logger.info(e.getMessage());
		}
	}

	public static void getClassDetail() {
		classList = classController.getClassDetails();
		Iterator<Classes> classIterator = classList.iterator();
		while (classIterator.hasNext()) {
			System.out.println(classIterator.next());
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info("In class application");
		while (true) {
			System.out.println("Class Application\n");
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Retrieval");
			System.out.println("5.Exit");
			System.out.println("Enter the choice:");
			try {
				Integer userChoice = Integer.parseInt(bufferedReader.readLine());
				switch (userChoice) {
				case 1:
					logger.info("In class controller -> add method");
					insertClass();
					break;
				case 2:
					logger.info("In class controller -> update method");
					updateClass();
					break;
				case 3:
					logger.info("In class controller -> delete method");
					deleteClass();
					break;
				case 4:
					logger.info("In class controller -> get method");
					getClassDetail();
					break;
				case 5:
					logger.info("Exits from class application");
					System.exit(0);
					break;
				default:
					throw new InvalidChoiceException("Enter the valid choice!");
				}
			} catch (IOException | NumberFormatException | InvalidChoiceException e) {
				logger.info(e.getMessage());
			}
		}
	}
}
