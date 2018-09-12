package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.PlayerDto;

public class PlayerDao {
	DataSource dataSource;

	public PlayerDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/final");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<PlayerDto> playerList(int team) {
		ArrayList<PlayerDto> pdtos = new ArrayList<PlayerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();

			String query = "select player.backNum, player.playerName, player.position from team, player where team.tIdx = player.team and player.team = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, team);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int backNum = rs.getInt("backNum");
				String playerName = rs.getString("playerName");
				String position = rs.getString("position");

				PlayerDto pdto = new PlayerDto(backNum, playerName, position);

				pdtos.add(pdto);
			}
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
		return pdtos;
	}

	public ArrayList<PlayerDto> getPlayerDetailInfo(int teamIdx, int back) {
		ArrayList<PlayerDto> alpdto = new ArrayList<PlayerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();

			String query = "select player.backNum, player.playerName, player.position from player where player.team = "
					+ teamIdx + " and player.backNum = " + back + "";
			pstmt = conn.prepareStatement(query);
//			pstmt.setInt(1, teamIdx);
			System.out.println(query);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int backNum = rs.getInt("backNum");
				String playerName2 = rs.getString("playerName");
				String position = rs.getString("position");

				PlayerDto pdto = new PlayerDto(backNum, playerName2, position);
				alpdto.add(pdto);
			}
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
		return alpdto;
	}
}
