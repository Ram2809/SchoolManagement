package com.revature.curriculummanagement.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.curriculummanagement.model.Discussion;
import com.revature.curriculummanagement.util.DBUtil;

public class DiscussionDAOImpl implements DiscussionDAO{

	public void addDiscussionDetails(Discussion discussion) throws SQLException, IOException {
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = null;
			String query = "INSERT INTO discussion VALUES(?,?,?,?,?,?)";
			pst = con.prepareStatement(query);
			pst.setInt(1, discussion.getQuestionNo());
			pst.setString(2, discussion.getQuestion());
			pst.setString(3, discussion.getAnswer());
			pst.setInt(4, discussion.getUnitId());
			pst.setInt(5, discussion.getQuestionNo());
			pst.setString(6, discussion.getDate());
			int count = pst.executeUpdate();
			System.out.println(count + " " + "Rows inserted!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
