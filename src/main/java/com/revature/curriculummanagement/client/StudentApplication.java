package com.revature.curriculummanagement.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
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
	static List<Student> studentList = new ArrayList<>();

	public static void insertStudent() throws NumberFormatException, IOException, SQLException {
		System.out.println("Enter the student details:");
		System.out.println("Enter the student id:");
		Integer studentId = Integer.parseInt(bufferedReader.readLine());
		System.out.println("Enter the student name:");
		String studentName = bufferedReader.readLine();
		System.out.println("Enter the student dob:");
		String studentDateOfBirth = bufferedReader.readLine();
		System.out.println("Enter the student address:");
		String studentAddress = bufferedReader.readLine();
		System.out.println("Enter the class room no:");
		Integer classRoomNo = Integer.parseInt(bufferedReader.readLine());
		student.setRollNo(studentId);
		student.setName(studentName);
		student.setDateOfBirth(studentDateOfBirth);
		student.setAddress(studentAddress);
		student.setClassRoomNo(classRoomNo);
		studentController.addStudentDetails(student);
	}

	public static void updateStudent() throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		System.out.println("Enter the id:");
		Integer updateId = Integer.parseInt(bufferedReader.readLine());
		studentController.updateStudentDetails(updateId);
	}

	public static void deleteStudent()
			throws NumberFormatException, IOException, SQLException, StudentNotFoundException {
		System.out.println("Enter the student id:");
		Integer deleteId = Integer.parseInt(bufferedReader.readLine());
		studentController.deleteStudentDetails(deleteId);
	}

	public static void getStudent() throws NumberFormatException, IOException, SQLException {
		studentList = studentController.getStudentDetails();
		Iterator<Student> studentIterator = studentList.iterator();
		while (studentIterator.hasNext()) {
			System.out.println(studentIterator.next());
		}
	}

	public static void getParticularStudent()
			throws NumberFormatException, IOException, SQLException, StudentNotFoundException {
		System.out.println("Enter the id:");
		Integer fetchId = Integer.parseInt(bufferedReader.readLine());
		List<Student> studentParicularList = new ArrayList<Student>();
		studentParicularList = studentController.getParticularStudentDetails(fetchId);
		Iterator<Student> studentParticularIterator = studentParicularList.iterator();
		while (studentParticularIterator.hasNext()) {
			System.out.println(studentParticularIterator.next());
		}
	}

	public static void main(String[] args)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException, StudentNotFoundException {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("Student Application");
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Retrieval");
			System.out.println("5.Paricular student data");
			System.out.println("6.Exit");
			System.out.println("Enter the choice:");
			Integer userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
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
			case 5:
				getParticularStudent();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
		}
	}
}
