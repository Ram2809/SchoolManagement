package com.revature.curriculummanagement.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.revature.curriculummanagement.controller.DiscussionController;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.QuestionNotFoundException;
import com.revature.curriculummanagement.exception.StudentNotFoundException;
import com.revature.curriculummanagement.model.Discussion;

public class DiscussionApplication {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static Discussion discussion = new Discussion();
	static DiscussionController discussionController = new DiscussionController();
	static List<Discussion> discussionList = new ArrayList<>();

	public static void insertDiscussion() throws NumberFormatException, IOException, SQLException {
		System.out.println("Enter the discussion details:");
		System.out.println("Enter the question no:");
		String questionNo = bufferedReader.readLine();
		System.out.println("Enter the question:");
		String question = bufferedReader.readLine();
		System.out.println("Enter the answer:");
		String answer = bufferedReader.readLine();
		System.out.println("Enter the subject id:");
		Integer subjectId = Integer.parseInt(bufferedReader.readLine());
		System.out.println("Enter the unit no:");
		Integer unitNo = Integer.parseInt(bufferedReader.readLine());
		System.out.println("Enter the discussion date:");
		String date = bufferedReader.readLine();
		discussion.setQuestionNo(questionNo);
		discussion.setQuestion(question);
		discussion.setAnswer(answer);
		discussion.setSubjectId(subjectId);
		discussion.setUnitId(unitNo);
		discussion.setDate(date);
		discussionController.addDiscussionDetails(discussion);
	}

	public static void updateDiscussion()
			throws NumberFormatException, IOException, InvalidChoiceException, SQLException {
		System.out.println("Enter the id:");
		String questionNo = bufferedReader.readLine();
		discussionController.updateDiscussionDetails(questionNo);
	}

	public static void deleteDiscussion() throws NumberFormatException, IOException, SQLException,
			StudentNotFoundException, QuestionNotFoundException {
		System.out.println("Enter the question no:");
		String questionNo = bufferedReader.readLine();
		discussionController.deleteDiscussionDetails(questionNo);
	}

	public static void getDiscussion() throws NumberFormatException, IOException, SQLException {
		discussionList = discussionController.getDiscussionDetails();
		Iterator<Discussion> discussionIterator = discussionList.iterator();
		while (discussionIterator.hasNext()) {
			System.out.println(discussionIterator.next());
		}
	}

	public static void getParticularDiscussion()
			throws NumberFormatException, IOException, SQLException, QuestionNotFoundException {
		System.out.println("Enter the question no:");
		String questionNo = bufferedReader.readLine();
		List<Discussion> discussionParicularList = new ArrayList<Discussion>();
		discussionParicularList = discussionController.getParticularDiscussionDetails(questionNo);
		Iterator<Discussion> discussionParticularIterator = discussionParicularList.iterator();
		while (discussionParticularIterator.hasNext()) {
			System.out.println(discussionParticularIterator.next());
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException,
			InvalidChoiceException, QuestionNotFoundException, StudentNotFoundException {
		while (true) {
			System.out.println("Discussion Application");
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Retrieval");
			System.out.println("5.Paricular discussion data");
			System.out.println("6.Exit");
			System.out.println("Enter the choice:");
			Integer userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
			case 1:
				insertDiscussion();
				break;
			case 2:
				updateDiscussion();
				break;
			case 3:
				deleteDiscussion();
				break;
			case 4:
				getDiscussion();
				break;
			case 5:
				getParticularDiscussion();
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
