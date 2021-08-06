package com.revature.curriculummanagement.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.controller.TopicsController;
import com.revature.curriculummanagement.exception.ControllerException;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.TopicNotFoundException;
import com.revature.curriculummanagement.model.Topics;

public class TopicApplication {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static Topics topics = new Topics();
	static TopicsController topicsController = new TopicsController();
	static List<Topics> topicsList = new ArrayList<>();
	static Logger logger = Logger.getLogger("TopicApplication.class");

	public static void insertTopics() {
		try {
			System.out.println("Enter the topics details:");
			System.out.println("Enter the unit no:");
			String unitNo = bufferedReader.readLine();
			System.out.println("Enter the unit name:");
			String unitName = bufferedReader.readLine();
			System.out.println("Enter the starting date:");
			String startingDate = bufferedReader.readLine();
			System.out.println("Enter the completed status:");
			boolean status = Boolean.parseBoolean(bufferedReader.readLine());
			System.out.println("Enter the subject id:");
			Integer subjectId = Integer.parseInt(bufferedReader.readLine());
			System.out.println("Enter the class room no:");
			Integer classRoomNo = Integer.parseInt(bufferedReader.readLine());
			topics.setUnitNo(unitNo);
			topics.setUnitName(unitName);
			topics.setStartDate(startingDate);
			topics.setStatus(status);
			topics.setSubjectId(subjectId);
			topics.setClassRoomNo(classRoomNo);
			topicsController.addTopicsDetails(topics);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}

	public static void updateTopics() {
		try {
			System.out.println("Enter the unit no:");
			String unitNo = bufferedReader.readLine();
			topicsController.updateTopicsDetails(unitNo);
		} catch (NumberFormatException | IOException | ControllerException e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}

	public static void deleteTopics() {
		try {
			System.out.println("Enter the unit no:");
			String unitNo = bufferedReader.readLine();
			topicsController.deleteTopicsDetails(unitNo);
		} catch (IOException | NumberFormatException | ControllerException e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}

	public static void getTopics() {
		topicsList = topicsController.getTopicsDetails();
		Iterator<Topics> topicsIterator = topicsList.iterator();
		while (topicsIterator.hasNext()) {
			System.out.println(topicsIterator.next());
		}
	}

	public static void getParticularTopic() {
		try {
			System.out.println("Enter the unit no:");
			String unitNo = bufferedReader.readLine();
			List<Topics> topicsParicularList = new ArrayList<Topics>();
			topicsParicularList = topicsController.getParticularTopicDetails(unitNo);
			Iterator<Topics> topicsParticularIterator = topicsParicularList.iterator();
			while (topicsParticularIterator.hasNext()) {
				System.out.println(topicsParticularIterator.next());
			}
		} catch (IOException | NumberFormatException | ControllerException e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}

	public static void main(String[] args) {
		while (true) {
			System.out.println("Topic Application\n");
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Retrieval");
			System.out.println("5.Paricular topic data");
			System.out.println("6.Exit");
			System.out.println("Enter the choice:");
			Integer userChoice;
			try {
				userChoice = Integer.parseInt(bufferedReader.readLine());
				switch (userChoice) {
				case 1:
					logger.info("In topics controller -> add method");
					insertTopics();
					break;
				case 2:
					logger.info("In topics controller -> update method");
					updateTopics();
					break;
				case 3:
					logger.info("In topics controller -> delete method");
					deleteTopics();
					break;
				case 4:
					logger.info("In topics controller -> get method");
					getTopics();
					break;
				case 5:
					logger.info("In topics controller -> get particular topic method");
					getParticularTopic();
					break;
				case 6:
					logger.info("Exits from topics application");
					System.exit(0);
					break;
				default:
					throw new InvalidChoiceException("Enter the valid choice!");
				}
			} catch (IOException | NumberFormatException | InvalidChoiceException e) {
				logger.info(e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
