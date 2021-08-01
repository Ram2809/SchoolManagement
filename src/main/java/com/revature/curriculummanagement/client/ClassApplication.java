package com.revature.curriculummanagement.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.revature.curriculummanagement.controller.ClassController;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.model.Classes;

public class ClassApplication {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static Classes classes = new Classes();
	static ClassController classController = new ClassController();
	static List<Classes> classList = new ArrayList<>();

	public static void insertClass() throws NumberFormatException, IOException, SQLException {
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
	}

	public static void updateClass() throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		System.out.println("Enter the class room no:");
		Integer roomNo = Integer.parseInt(bufferedReader.readLine());
		classController.updateClassDetails(roomNo);
	}

	public static void deleteClass() throws NumberFormatException, IOException, SQLException {
		System.out.println("Enter the room no:");
		Integer roomNo = Integer.parseInt(bufferedReader.readLine());
		classController.deleteClassDetails(roomNo);
	}

	public static void getClassDetail() throws SQLException, IOException {
		classList = classController.getClassDetails();
		Iterator<Classes> classIterator = classList.iterator();
		while (classIterator.hasNext()) {
			System.out.println(classIterator.next());
		}
	}

	public static void main(String[] args)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("Class Application\n");
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Retrieval");
			System.out.println("5.Exit");
			System.out.println("Enter the choice:");
			Integer userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
			case 1:
				insertClass();
				break;
			case 2:
				updateClass();
				break;
			case 3:
				deleteClass();
				break;
			case 4:
				getClassDetail();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
		}
	}
}
