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
import com.revature.curriculummanagement.exception.TopicNotFoundException;
import com.revature.curriculummanagement.model.Topics;
import com.revature.curriculummanagement.util.DBUtil;

public class TopicsDAOImpl implements TopicsDAO {

	static List<Topics> topicsList = new ArrayList<>();
	static List<String> topicsIdList = new ArrayList<>();
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void getUnitNo() {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "select unitNo from topics";
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				topicsIdList.add(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addTopicsDetails(Topics topics) throws SQLException, IOException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "INSERT INTO topics VALUES(?,?,?,?,?,?)";
			pst = con.prepareStatement(query);
			pst.setString(1, topics.getUnitNo());
			pst.setString(2, topics.getUnitName());
			pst.setString(3, topics.getStartDate());
			pst.setBoolean(4, topics.isStatus());
			pst.setInt(5, topics.getSubjectId());
			pst.setInt(6, topics.getClassRoomNo());
			pst.executeUpdate();
			System.out.println("Rows inserted!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateTopicsDetails(String unitNo) throws SQLException, IOException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "";
			getUnitNo();
			if (!topicsIdList.contains(unitNo)) {
				throw new TopicNotFoundException("Topic not found,Enter the valid id!");
			}
			System.out.println("1.Update unit name");
			System.out.println("2.Update starting date");
			System.out.println("3.Update status");
			System.out.println("Enter your choice:");
			Integer userChoice = Integer.parseInt(bufferedReader.readLine());
			switch (userChoice) {
			case 1:
				System.out.println("Enter the new unit name:");
				String updateUnitName = bufferedReader.readLine();
				query = "UPDATE topics SET unitName=? WHERE unitNo=?";
				pst = con.prepareStatement(query);
				pst.setString(1, updateUnitName);
				pst.setString(2, unitNo);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			case 2:
				System.out.println("Enter the new starting date:");
				String updateBeginDate = bufferedReader.readLine();
				query = "UPDATE topics SET beginDate=? WHERE unitNo=?";
				pst = con.prepareStatement(query);
				pst.setString(1, updateBeginDate);
				pst.setString(2, unitNo);
				pst.executeUpdate();
				System.out.println("Rows updated!");
				break;
			case 3:
				System.out.println("Enter the new status:");
				Boolean updateStatus = Boolean.parseBoolean(bufferedReader.readLine());
				query = "UPDATE topics SET status=? WHERE unitNo=?";
				pst = con.prepareStatement(query);
				pst.setBoolean(1, updateStatus);
				pst.setString(2, unitNo);
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

	public void deleteTopicsDetails(String unitNo) throws SQLException, IOException, TopicNotFoundException {
		getUnitNo();
		if (!topicsIdList.contains(unitNo)) {
			throw new TopicNotFoundException("Topic not found,Enter the valid id!");
		}
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "DELETE FROM topics WHERE unitNo=?";
			pst = con.prepareStatement(query);
			pst.setString(1, unitNo);
			int count = pst.executeUpdate();
			System.out.println(count + " " + "Rows deleted!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Topics> getTopicsDetails() throws SQLException, IOException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "SELECT * FROM topics";
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				topicsList.add(new Topics(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4),
						rs.getInt(5), rs.getInt(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topicsList;
	}

	public List<Topics> getParticularTopicDetails(String unitNo)
			throws SQLException, IOException, TopicNotFoundException {
		List<Topics> topicsParticularList = new ArrayList<>();
		getUnitNo();
		if (!topicsIdList.contains(unitNo)) {
			throw new TopicNotFoundException("Topic not found,Enter the valid id!");
		}
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "SELECT * FROM topics WHERE unitNo=?";
			pst = con.prepareStatement(query);
			pst.setString(1, unitNo);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				topicsParticularList.add(new Topics(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4),
						rs.getInt(5), rs.getInt(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topicsParticularList;
	}

}
