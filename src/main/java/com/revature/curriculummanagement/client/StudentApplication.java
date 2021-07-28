package com.revature.curriculummanagement.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.revature.curriculummanagement.controller.StudentController;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.model.Student;

public class StudentApplication {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static Student student = new Student();
	static StudentController studentController = new StudentController();

	public static void insertStudent() throws NumberFormatException, IOException {
		System.out.println("Enter the number of students:");
		Integer noOfStudents = Integer.parseInt(bufferedReader.readLine());
		System.out.println("Enter the student details:");
		for (Integer i = 0; i < noOfStudents; i++) {
			Integer studentId = Integer.parseInt(bufferedReader.readLine());
			String studentName = bufferedReader.readLine();
			String studentDateOfBirth = bufferedReader.readLine();
			String studentStandard = bufferedReader.readLine();
			String studentAddress = bufferedReader.readLine();
			student.setRollNo(studentId);
			student.setName(studentName);
			student.setDateOfBirth(studentDateOfBirth);
			student.setStandard(studentStandard);
			student.setAddress(studentAddress);

			// studentList.add(new Student(student.getRollNo(), student.getName(),
			// student.getDateOfBirth(),
			// student.getStandard(), student.getAddress()));
		}
		studentController.addStudentDetails(student);
	}

	public static void updateStudent() {

	}

	public static void deleteStudent() {

	}

	public static void getStudent() {
		studentController.getStudentDetails(student);
	}

	public static void main(String[] args) throws NumberFormatException, IOException, InvalidChoiceException,StudentNotFoundException{
		// TODO Auto-generated method stub
		System.out.println("1.Insert");
		System.out.println("2.Updation");
		System.out.println("3.Deletion");
		System.out.println("4.Retrival");
		insertStudent();
		getStudent();
		studentController.updateStudentDetails(student);
		//Integer userChoice = Integer.parseInt(bufferedReader.readLine());
		/*switch (userChoice) {
		case 1:
			insertStudent();
			break;
		case 2:
			updateStudent();
			break;
		case 3:
			deleteStudent();
			break;
		case 4:
			getStudent();
			break;
		default:
			throw new InvalidChoiceException("Enter the valid choice!");
		}*/
	}

}
