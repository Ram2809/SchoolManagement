package com.revature.curriculummanagement.client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.revature.curriculummanagement.controller.ClassController;
import com.revature.curriculummanagement.controller.StudentController;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.model.Classes;
import com.revature.curriculummanagement.model.Student;

public class ClassApplication {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static Student student = new Student();
	static Classes classes = new Classes();
	static ClassController classController = new ClassController();

	public static void insertClass() throws NumberFormatException, IOException {
		System.out.println("Enter the class details:");
		Integer classId = Integer.parseInt(bufferedReader.readLine());
		String className = bufferedReader.readLine();
		classes.setClassId(classId);
		classes.setClassName(className);
		classController.addClassDetails(classes);
	}

	public static void updateStudent() throws NumberFormatException, IOException, InvalidChoiceException {
		studentController.updateStudentDetails(student);
	}

	public static void deleteStudent() throws NumberFormatException, IOException {
		studentController.deleteStudentDetails(student);
	}

	public static void getStudent() {
		studentController.getStudentDetails(student);
	}

	public static void main(String[] args) throws NumberFormatException, IOException, InvalidChoiceException {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("1.Insert");
			System.out.println("2.Retrieval");
			System.out.println("3.Updation");
			System.out.println("4.Deletion");
			System.out.println("5.Exit");
			System.out.println("Enter the choice:");
			Integer userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
			case 1:
				insertStudent();
				break;
			case 2:
				getStudent();
				break;
			case 3:
				updateStudent();
				break;
			case 4:
				deleteStudent();
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
