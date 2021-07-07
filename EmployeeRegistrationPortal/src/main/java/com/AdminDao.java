package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBConnection;


public class AdminDao {

	public AdminBean login(String aEmail, String aPassword) {

		Connection conn;
		PreparedStatement pstmt;

		conn = DBConnection.getDBConnection();
		AdminBean adminBean = null;
		if (conn != null) {

			String loginSQL = "select * from admin where aemail =? and apassword =? ";
			try {
				pstmt = conn.prepareStatement(loginSQL);
				pstmt.setString(1, aEmail);
				pstmt.setString(2, aPassword);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {

					adminBean = new AdminBean();
					adminBean.setaName(rs.getString("aname"));
					adminBean.setaEmail(rs.getString("aemail"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return adminBean;
	}

}
