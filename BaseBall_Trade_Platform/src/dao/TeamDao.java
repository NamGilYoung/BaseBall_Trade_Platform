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
		String ab = null;
		try {
			conn = dataSource.getConnection();

			String query = "select ab from team_2018 where idx = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, tIdx);

			rs = pstmt.executeQuery();
			rs.next();
			ab = rs.getString("ab");
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
		return ab;
	}

	public int getTeamIdx(String teamName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int teamIdx = 0;
		try {
			conn = dataSource.getConnection();

			String query = "select idx from team_2018 where ab = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, teamName);

			rs = pstmt.executeQuery();
			rs.next();
			teamIdx = rs.getInt("idx");

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

	public String getWinrate_2018(int tname) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String winrate = "";
		double stat;
		double statSum;

		try {
			conn = dataSource.getConnection();

			String query = "select stat from team_2018 where idx = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, tname);

			rs = pstmt.executeQuery();
			rs.next();
			stat = rs.getDouble("stat");

			query = "select sum(stat) from team_2018";

			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery();
			rs.next();
			String stringSum = rs.getString(1);
			statSum = Double.parseDouble(stringSum);
			
			statSum = (100 / statSum) * stat;
			
			winrate = String.format("%.2f", statSum);
			
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
		return winrate;
	}

	public String getWinrate_2019(int tname) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String winrate = "";
		double stat;
		double statSum;

		try {
			conn = dataSource.getConnection();

			String query = "select stat from team_2019 where idx = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, tname);

			rs = pstmt.executeQuery();
			rs.next();
			stat = rs.getDouble("stat");

			query = "select sum(stat) from team_2019";

			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery();
			rs.next();
			String stringSum = rs.getString(1);
			statSum = Double.parseDouble(stringSum);
			
			statSum = (100 / statSum) * stat;
			
			winrate = String.format("%.2f", statSum);
			
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
		return winrate;
	}

	public void updateStat(int tname ,double statSum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();

			String query = "update team_2019 set stat = ? where idx = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setDouble(1, statSum);
			pstmt.setInt(2, tname);
			

			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		       try {
		           
		           if (pstmt != null)
		              pstmt.close();
		           if (conn != null)
		              conn.close();
		        } catch (Exception e2) {
		           e2.printStackTrace();
		        }
		}

		
}

	public void reset2019() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();

			String query = "drop table team_2019";
			pstmt = conn.prepareStatement(query);
					
			pstmt.executeUpdate();
			
			query = "create table team_2019 (select * from team_2018)";
			pstmt = conn.prepareStatement(query);
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
		       try {
		           
		           if (pstmt != null)
		              pstmt.close();
		           if (conn != null)
		              conn.close();
		        } catch (Exception e2) {
		           e2.printStackTrace();
		        }
		}

		
}
}