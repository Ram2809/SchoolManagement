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

import com.revature.curriculummanagement.exception.InvalidChoiceException;
import com.revature.curriculummanagement.exception.SubjectNotFoundException;
import com.revature.curriculummanagement.model.Subject;
import com.revature.curriculummanagement.util.DBUtil;

public class SubjectDAOImpl implements SubjectDAO {
	static List<Subject> subjectList = new ArrayList<>();
	static List<Integer> subjectIdList = new ArrayList<>();
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void getSubjectId() {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "select Id from subject";
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				subjectIdList.add(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addSubjectDetails(Subject subject) throws SQLException, IOException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "INSERT INTO subject VALUES(?,?,?)";
			pst = con.prepareStatement(query);
			pst.setInt(1, subject.getSubId());
			pst.setString(2, subject.getSubName());
			pst.setInt(3, subject.getClassId());
			int count = pst.executeUpdate();
			System.out.println(count + " " + "Rows Inserted!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateSubjectDetails(Integer subjectId) throws SQLException, IOException {
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
				String updateSubjectName = bufferedReader.readLine();
				query = "UPDATE subject SET Name=? WHERE Id=?";
				pst = con.prepareStatement(query);
				pst.setString(1, updateSubjectName);
				pst.setInt(2, subjectId);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			case 2:
				System.out.println("Enter the new class id:");
				Integer updateClassId = Integer.parseInt(bufferedReader.readLine());
				query = "UPDATE subject SET classId=? WHERE Id=?";
				pst = con.prepareStatement(query);
				pst.setInt(1, updateClassId);
				pst.setInt(2, subjectId);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			default:
				throw new InvalidChoiceException("Enter the valid choice!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteSubjectDetails(Integer subjectId) throws SQLException, IOException, SubjectNotFoundException {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Subject> getSubjectDetails() throws SQLException, IOException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "SELECT * FROM subject";
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				subjectList.add(new Subject(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectList;
	}

	public List<Subject> getParticularSubjectDetails(Integer subjectId)
			throws SQLException, IOException, SubjectNotFoundException {
		List<Subject> subjectParticularList = new ArrayList<>();
		getSubjectId();
		if (!subjectIdList.contains(subjectId)) {
			throw new SubjectNotFoundException("Subject not found,Enter the valid id!");
		}
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "SELECT * FROM subject WHERE Id=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, subjectId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				subjectParticularList.add(new Subject(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectParticularList;
	}

}
