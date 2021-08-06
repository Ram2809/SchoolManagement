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
import com.revature.curriculummanagement.exception.SubjectNotFoundException;
import com.revature.curriculummanagement.model.Subject;
import com.revature.curriculummanagement.util.DBUtil;

public class SubjectDAOImpl implements SubjectDAO {
	static List<Subject> subjectList = new ArrayList<>();
	static List<Integer> subjectIdList = new ArrayList<>();
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static Logger logger = Logger.getLogger("SubjectDAOImpl.class");

	public static void getSubjectId() {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "select Id from subject";
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				subjectIdList.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			logger.warn(e.getMessage());
		}
	}

	public void addSubjectDetails(Subject subject) {
		try (Connection con = DBUtil.getConnection();) {
			String query = "INSERT INTO subject VALUES(?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, subject.getSubId());
			pst.setString(2, subject.getSubName());
			pst.setInt(3, subject.getClassId());
			int count = pst.executeUpdate();
			System.out.println(count + " " + "Rows Inserted!");
		} catch (SQLException e) {
			logger.warn(e.getMessage());
		}
	}

	public void updateSubjectDetails(Integer subjectId) throws DatabaseException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "";
			getSubjectId();
			if (!subjectIdList.contains(subjectId)) {
				throw new SubjectNotFoundException("Subject not found,Enter the valid id!");
			}
			System.out.println("1.Update subject name");
			System.out.println("2.Update class id");
			System.out.println("Enter your choice:");
			Integer userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
			case 1:
				System.out.println("Enter the new subject name:");
				String subjectName = bufferedReader.readLine();
				query = "UPDATE subject SET Name=? WHERE Id=?";
				pst = con.prepareStatement(query);
				pst.setString(1, subjectName);
				pst.setInt(2, subjectId);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			case 2:
				System.out.println("Enter the new class id:");
				Integer classId = Integer.parseInt(bufferedReader.readLine());
				query = "UPDATE subject SET classId=? WHERE Id=?";
				pst = con.prepareStatement(query);
				pst.setInt(1, classId);
				pst.setInt(2, subjectId);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
		} catch (IOException | NumberFormatException | SQLException | InvalidChoiceException
				| SubjectNotFoundException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public void deleteSubjectDetails(Integer subjectId) throws DatabaseException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			getSubjectId();
			if (!subjectIdList.contains(subjectId)) {
				throw new SubjectNotFoundException("Subject not found,Enter the valid id!");
			}
			String query = "DELETE FROM subject WHERE Id=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, subjectId);
			int count = pst.executeUpdate();
			System.out.println(count + " " + "Rows deleted!");
		} catch (SQLException | SubjectNotFoundException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public List<Subject> getSubjectDetails() {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "SELECT * FROM subject";
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				subjectList.add(new Subject(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			logger.warn(e.getMessage());
		}
		return subjectList;
	}

	public List<Subject> getParticularSubjectDetails(Integer subjectId) throws DatabaseException {
		List<Subject> subjectParticularList = new ArrayList<>();
		try {
			getSubjectId();
			if (!subjectIdList.contains(subjectId)) {
				throw new SubjectNotFoundException("Subject not found,Enter the valid id!");
			}
			Connection con = DBUtil.getConnection();
			PreparedStatement pst = null;
			String query = "SELECT * FROM subject WHERE Id=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, subjectId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				subjectParticularList.add(new Subject(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (SQLException | SubjectNotFoundException e) {
			throw new DatabaseException(e.getMessage());
		}
		return subjectParticularList;
	}

	public void getSubjectStatus(Integer subjectId) {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "SELECT class.RoomNo,class.Standard,class.Section,subject.Id,subject.Name,teacherdetails.teacherId,teacher.name,topics.unitNo,topics.unitName,topics.beginDate,discussion.date AS completedDate,topics.status FROM class JOIN subject ON class.RoomNo=subject.classId JOIN topics ON subject.Id=topics.subjectId JOIN teacherdetails ON topics.subjectId=teacherdetails.subjectId JOIN teacher ON teacherdetails.teacherId=teacher.id JOIN discussion ON topics.unitNo=discussion.unitNo WHERE subject.Id=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, subjectId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4)
						+ " " + rs.getString(5) + " " + rs.getInt(6) + " " + rs.getString(7) + " " + rs.getString(8)
						+ " " + rs.getString(9) + " " + rs.getString(10) + " " + rs.getString(11) + " "
						+ rs.getBoolean(12));
			}
		} catch (SQLException e) {
			logger.warn(e.getMessage());
		}

	}

}
