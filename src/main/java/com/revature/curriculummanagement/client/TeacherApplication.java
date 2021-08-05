package com.revature.curriculummanagement.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.controller.TeacherController;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.TeacherNotFoundException;
import com.revature.curriculummanagement.model.Teacher;

public class TeacherApplication {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static Teacher teacher = new Teacher();
	static TeacherController teacherController = new TeacherController();
	static List<Teacher> teacherList = new ArrayList<>();

	public static void insertTeacher() throws NumberFormatException, IOException, SQLException {
		System.out.println("Enter the teacher details:");
		System.out.println("Enter the teacher id:");
		Integer teacherId = Integer.parseInt(bufferedReader.readLine());
		System.out.println("Enter the teacher name:");
		String teacherName = bufferedReader.readLine();
		System.out.println("Enter the teacher dob:");
		String teacherDateOfBirth = bufferedReader.readLine();
		System.out.println("Enter the teacher address:");
		String teacherAddress = bufferedReader.readLine();
		System.out.println("Enter the qualifiaction:");
		String qualification = bufferedReader.readLine();
		System.out.println("Enter the subject name");
		String subjectName = bufferedReader.readLine();
		teacher.setId(teacherId);
		teacher.setName(teacherName);
		teacher.setDateOfBirth(teacherDateOfBirth);
		teacher.setAddress(teacherAddress);
		teacher.setQualification(qualification);
		teacher.setSubject(subjectName);
		teacherController.addTeacherDetails(teacher);
	}

	public static void updateTeacher() throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		System.out.println("Enter the id:");
		Integer id = Integer.parseInt(bufferedReader.readLine());
		teacherController.updateTeacherDetails(id);
	}

	public static void deleteTeacher()
			throws NumberFormatException, IOException, SQLException, TeacherNotFoundException {
		System.out.println("Enter the teacher id:");
		Integer id = Integer.parseInt(bufferedReader.readLine());
		teacherController.deleteTeacherDetails(id);
	}

	public static void getTeacher() throws NumberFormatException, IOException, SQLException {
		teacherList = teacherController.getTeacherDetails();
		Iterator<Teacher> teacherIterator = teacherList.iterator();
		while (teacherIterator.hasNext()) {
			System.out.println(teacherIterator.next());
		}
	}

	public static void getParticularTeacher()
			throws NumberFormatException, IOException, SQLException, TeacherNotFoundException {
		System.out.println("Enter the id:");
		Integer id = Integer.parseInt(bufferedReader.readLine());
		List<Teacher> teacherParicularList = new ArrayList<Teacher>();
		teacherParicularList = teacherController.getParticularTeacherDetails(id);
		Iterator<Teacher> teacherParticularIterator = teacherParicularList.iterator();
		while (teacherParticularIterator.hasNext()) {
			System.out.println(teacherParticularIterator.next());
		}
	}

	public static void getTeacherByClassRoom() throws NumberFormatException, IOException {
		System.out.println("Enter the class room no:");
		Integer classRoomNo = Integer.parseInt(bufferedReader.readLine());
		teacherController.getTeacherDetailsByClassRoom(classRoomNo);
	}

	public static void main(String[] args)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException, TeacherNotFoundException {
		Logger logger = Logger.getLogger("TeacherApplication.class");
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("Teacher Application\n");
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Retrieval");
			System.out.println("5.Paricular teacher data");
			System.out.println("6.Get teachers for particular classroom");
			System.out.println("7.Exit");
			System.out.println("Enter the choice:");
			Integer userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
			case 1:
				logger.info("In teacher controller -> add method");
				insertTeacher();
				break;
			case 2:
				logger.info("In teacher controller -> update method");
				updateTeacher();
				break;
			case 3:
				logger.info("In teacher controller -> delete method");
				deleteTeacher();
				break;
			case 4:
				logger.info("In teacher controller -> get method");
				getTeacher();
				break;
			case 5:
				logger.info("In teacher controller -> get particular teacher data method");
				getParticularTeacher();
				break;
			case 6:
				logger.info("In teacher controller -> get teacher for given classroom method");
				getTeacherByClassRoom();
				break;
			case 7:
				logger.info("Exits from teacher application");
				System.exit(0);
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
		}
	}
}
