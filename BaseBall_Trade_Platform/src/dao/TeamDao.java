package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TeamDao {
	DataSource dataSource;

	public TeamDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/final");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getTeamName(int tIdx) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String teamName = null;
		try {
			conn = dataSource.getConnection();

			String query = "select tName from team where tIdx = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, tIdx);

			rs = pstmt.executeQuery();
			rs.next();
			teamName = rs.getString("tName");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return teamName;
	}

	public int getTeamIdx(String teamName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int teamIdx = 0;
		try {
			conn = dataSource.getConnection();

			String query = "select tIdx from team where tName = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, teamName);

			rs = pstmt.executeQuery();
			rs.next();
			teamIdx = rs.getInt("tidx");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return teamIdx;
	}
}
