package com.revature.curriculummanagement.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.curriculummanagement.exception.DatabaseException;
import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.QuestionNotFoundException;
import com.revature.curriculummanagement.exception.SubjectNotFoundException;
import com.revature.curriculummanagement.exception.TopicNotFoundException;
import com.revature.curriculummanagement.model.Discussion;
import com.revature.curriculummanagement.util.DBUtil;
import static com.revature.curriculummanagement.dao.TopicsDAOImpl.topicsIdList;
import static com.revature.curriculummanagement.dao.TopicsDAOImpl.getUnitNo;;

public class DiscussionDAOImpl implements DiscussionDAO {
	static List<Discussion> discussionList = new ArrayList<>();
	static List<String> questionNoList = new ArrayList<>();
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static Logger logger = Logger.getLogger("DiscussionDAOImpl.class");

	public static void getQuestionNo() {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "SELECT QuestionNo FROM discussion";
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				questionNoList.add(rs.getString(1));
			}
		} catch (SQLException e) {
			logger.warn(e.getMessage());
		}
	}

	public void addDiscussionDetails(Discussion discussion) {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "INSERT INTO discussion VALUES(?,?,?,?,?,?)";
			pst = con.prepareStatement(query);
			pst.setString(1, discussion.getQuestionNo());
			pst.setString(2, discussion.getQuestion());
			pst.setString(3, discussion.getAnswer());
			pst.setString(4, discussion.getUnitId());
			pst.setInt(5, discussion.getSubjectId());
			pst.setString(6, discussion.getDate());
			int count = pst.executeUpdate();
			System.out.println(count + " " + "Rows inserted!");
		} catch (SQLException e) {
			logger.warn(e.getMessage());
		}

	}

	public void updateDiscussionDetails(String questionNo) throws DatabaseException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "";
			getQuestionNo();
			if (!questionNoList.contains(questionNo)) {
				throw new QuestionNotFoundException("Question not found,Enter the valid id!");
			}
			System.out.println("1.Update question");
			System.out.println("2.Update answer");
			System.out.println("3.Update date");
			System.out.println("Enter your choice:");
			Integer userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
			case 1:
				System.out.println("Enter the new question:");
				String newQuestion = bufferedReader.readLine();
				query = "UPDATE discussion SET Question=? WHERE QuestionNo=?";
				pst = con.prepareStatement(query);
				pst.setString(1, newQuestion);
				pst.setString(2, questionNo);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			case 2:
				System.out.println("Enter the new answer:");
				String newAnswer = bufferedReader.readLine();
				query = "UPDATE discussion SET Answer=? WHERE QuestionNo=?";
				pst = con.prepareStatement(query);
				pst.setString(1, newAnswer);
				pst.setString(2, questionNo);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			case 3:
				System.out.println("Enter the new date:");
				String newDate = bufferedReader.readLine();
				query = "UPDATE discussion SET date=? WHERE QuestionNo=?";
				pst = con.prepareStatement(query);
				pst.setString(1, newDate);
				pst.setString(2, questionNo);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
		} catch (SQLException | InvalidChoiceException | QuestionNotFoundException | IOException
				| NumberFormatException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public void deleteDiscussionDetails(String questionNo) throws DatabaseException {
		try {
			getQuestionNo();
			if (!questionNoList.contains(questionNo)) {
				throw new QuestionNotFoundException("Question not found,Enter the valid id!");
			}
			Connection con = DBUtil.getConnection();
			PreparedStatement pst = null;
			String query = "DELETE FROM discussion WHERE QuestionNo=?";
			pst = con.prepareStatement(query);
			pst.setString(1, questionNo);
			int count = pst.executeUpdate();
			System.out.println(count + " " + "Rows deleted!");
		} catch (SQLException | QuestionNotFoundException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public List<Discussion> getDiscussionDetails() {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "SELECT * FROM discussion";
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				discussionList.add(new Discussion(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			logger.warn(e.getMessage());
		}
		return discussionList;
	}

	public List<Discussion> getParticularDiscussionDetails(String questionNo) throws DatabaseException {
		List<Discussion> discussionParticularList = new ArrayList<>();
		try {
			getQuestionNo();
			if (!questionNoList.contains(questionNo)) {
				throw new QuestionNotFoundException("Question not found,Enter the valid id!");
			}
			Connection con = DBUtil.getConnection();
			PreparedStatement pst = null;
			String query = "SELECT * FROM discussion WHERE QuestionNo=?";
			pst = con.prepareStatement(query);
			pst.setString(1, questionNo);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				discussionParticularList.add(new Discussion(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getInt(5), rs.getString(6)));
			}
		} catch (SQLException | QuestionNotFoundException e) {
			throw new DatabaseException(e.getMessage());
		}
		return discussionParticularList;
	}

	public void getDiscussionStatusByUnit(String unitNo) throws DatabaseException {
		try {
			getUnitNo();
			if (!topicsIdList.contains(unitNo)) {
				throw new TopicNotFoundException("Topic not found,Enter the valid id!");
			}
			Connection con = DBUtil.getConnection();
			PreparedStatement pst = null;
			String query = "SELECT class.roomNo,class.standard,class.section,subject.id,subject.name,topics.unitNo,topics.unitName,discussion.questionNo,discussion.question,discussion.answer,discussion.date FROM class JOIN subject ON class.roomNo=subject.classId JOIN topics ON subject.id=topics.subjectId JOIN discussion ON topics.unitNo=discussion.unitNo WHERE topics.unitNo=?";
			pst = con.prepareStatement(query);
			pst.setString(1, unitNo);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4)
						+ " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) + " " + rs.getString(8)
						+ " " + rs.getString(9) + " " + rs.getString(10) + " " + rs.getString(11));
			}
		} catch (SQLException | TopicNotFoundException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

}
