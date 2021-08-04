package com.revature.curriculummanagement.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import com.revature.curriculummanagement.controller.TimeTableController;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.model.Student;
import com.revature.curriculummanagement.model.TimeTable;

public class TimeTableApplication {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static TimeTable timeTable = new TimeTable();
	static TimeTableController timeTableController = new TimeTableController();
	static List<TimeTable> timeTableList = new ArrayList<>();

	public static void insertTimeTable() throws IOException {
		System.out.println("Enter the timetable details:");
		timeTableController.addTimeTableDetails();
	}

	public static void updateTimeTable() throws NumberFormatException, IOException {
		System.out.println("Enter the class room no:");
		Integer classId = Integer.parseInt(bufferedReader.readLine());
		System.out.println("Enter the day:");
		String day = bufferedReader.readLine();
		timeTableController.updateTimeTableDetails(classId, day);
	}

	public static void deleteTimeTable() throws NumberFormatException, IOException {
		System.out.println("Enter the class room no:");
		Integer classId = Integer.parseInt(bufferedReader.readLine());
		System.out.println("Enter the day:");
		String day = bufferedReader.readLine();
		timeTableController.deleteTimeTableDetails(classId, day);
	}

	public static void getTimeTable() throws NumberFormatException, IOException, SQLException {
		timeTableList = timeTableController.getTimeTableDetails();
		Iterator<TimeTable> timeTableIterator = timeTableList.iterator();
		while (timeTableIterator.hasNext()) {
			System.out.println(timeTableIterator.next());
		}
	}

	public static void getParticularTimeTable() throws NumberFormatException, IOException, SQLException {
		System.out.println("Enter the class room no:");
		Integer classId = Integer.parseInt(bufferedReader.readLine());
		System.out.println("Enter the day:");
		String day = bufferedReader.readLine();
		List<TimeTable> timeTableParicularList = new ArrayList<TimeTable>();
		timeTableParicularList = timeTableController.getParticularTimeTableDetails(classId, day);
		Iterator<TimeTable> timeTableParticularIterator = timeTableParicularList.iterator();
		while (timeTableParticularIterator.hasNext()) {
			System.out.println(timeTableParticularIterator.next());
		}
	}

	public static void timeTableByclassRoom() throws NumberFormatException, IOException {
		System.out.println("Enter the class room no:");
		Integer roomNo = Integer.parseInt(bufferedReader.readLine());
		timeTableController.getTimeTableByclassRoom(roomNo);
	}

	public static void timeTableByclassStandard() throws NumberFormatException, IOException {
		System.out.println("Enter the class room no:");
		Integer roomNo = Integer.parseInt(bufferedReader.readLine());
		timeTableController.getTimeTableByclassStandard(roomNo);
	}

	public static void main(String[] args)
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger("TimeTableApplication.class");
		while (true) {
			System.out.println("TimeTable Application\n");
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Retrieval");
			System.out.println("5.Paricular student data");
			System.out.println("6.Get timetable for paticular class");
			System.out.println("7.Get timetable for paticular standard");
			System.out.println("8.Exit");
			System.out.println("Enter the choice:");
			Integer userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
			case 1:
				logger.info("In timetable controller -> add method");
				insertTimeTable();
				break;
			case 2:
				logger.info("In timetable controller -> update method");
				updateTimeTable();
				break;
			case 3:
				logger.info("In timetable controller -> delete method");
				deleteTimeTable();
				break;
			case 4:
				logger.info("In timetable controller -> get method");
				getTimeTable();
				break;
			case 5:
				logger.info("In timetable controller -> get particular time table method");
				getParticularTimeTable();
				break;
			case 6:
				logger.info("In timetable controller -> get time table by class room method");
				timeTableByclassRoom();
				break;
			case 7:
				logger.info("In timetable controller -> get time table by standard method");
				timeTableByclassStandard();
				break;
			case 8:
				logger.info("Exits from time table application");
				System.exit(0);
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
		}
	}

}
