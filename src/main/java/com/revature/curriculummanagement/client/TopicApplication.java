package com.revature.curriculummanagement.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.revature.curriculummanagement.controller.TopicsController;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.TopicNotFoundException;
import com.revature.curriculummanagement.model.Topics;

public class TopicApplication {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static Topics topics = new Topics();
	static TopicsController topicsController = new TopicsController();
	static List<Topics> topicsList = new ArrayList<>();

	public static void insertTopics() throws NumberFormatException, IOException, SQLException {
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
	}

	public static void updateTopics() throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		System.out.println("Enter the unit no:");
		String unitNo = bufferedReader.readLine();
		topicsController.updateTopicsDetails(unitNo);
	}

	public static void deleteTopics() throws NumberFormatException, IOException, SQLException, TopicNotFoundException {
		System.out.println("Enter the unit no:");
		String unitNo = bufferedReader.readLine();
		topicsController.deleteTopicsDetails(unitNo);
	}

	public static void getTopics() throws NumberFormatException, IOException, SQLException {
		topicsList = topicsController.getTopicsDetails();
		Iterator<Topics> topicsIterator = topicsList.iterator();
		while (topicsIterator.hasNext()) {
			System.out.println(topicsIterator.next());
		}
	}

	public static void getParticularTopic()
			throws NumberFormatException, IOException, SQLException, TopicNotFoundException {
		System.out.println("Enter the unit no:");
		String unitNo = bufferedReader.readLine();
		List<Topics> topicsParicularList = new ArrayList<Topics>();
		topicsParicularList = topicsController.getParticularTopicDetails(unitNo);
		Iterator<Topics> topicsParticularIterator = topicsParicularList.iterator();
		while (topicsParticularIterator.hasNext()) {
			System.out.println(topicsParticularIterator.next());
		}
	}

	public static void main(String[] args)
			throws NumberFormatException, IOException, SQLException, InvalidChoiceException, TopicNotFoundException {
		while (true) {
			System.out.println("Topic Application\n");
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Retrieval");
			System.out.println("5.Paricular topic data");
			System.out.println("6.Exit");
			System.out.println("Enter the choice:");
			Integer userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
			case 1:
				insertTopics();
				break;
			case 2:
				updateTopics();
				break;
			case 3:
				deleteTopics();
				break;
			case 4:
				getTopics();
				break;
			case 5:
				getParticularTopic();
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
