package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.HitterDto;

public class HitterDao {
   DataSource dataSource;

   public HitterDao() {
      try {
         Context context = new InitialContext();
         dataSource = (DataSource) context.lookup("java:comp/env/jdbc/final");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   //
   public ArrayList<HitterDto> getHitterList(int team) {
      ArrayList<HitterDto> hdtos = new ArrayList<HitterDto>();

      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      try {
         conn = dataSource.getConnection();

         String query = "select idx, name, position, result from player_hitter_2018 where team = ?";
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, team);

         rs = pstmt.executeQuery();

         while (rs.next()) {
            int idx = rs.getInt("idx");
            String name = rs.getString("name");
            String position = rs.getString("position");
            double result = rs.getDouble("result");

            HitterDto hdto = new HitterDto(idx, name, position, result);

            hdtos.add(hdto);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }  finally {
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
      return hdtos;

   }
   
   public ArrayList<HitterDto> getHitterDetailInfo(int teamIdx, int idx) {
		ArrayList<HitterDto> alhdto = new ArrayList<HitterDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();

			String query = "select player_hitter_2018.idx, player_hitter_2018.name, player_hitter_2018.position, player_hitter_2018.result from player_hitter_2018 where player_hitter_2018.team = "
					+ teamIdx + " and player_hitter_2018.idx = " + idx + "";
			pstmt = conn.prepareStatement(query);
//			pstmt.setInt(1, teamIdx);
			System.out.println(query);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int idx2 = rs.getInt("idx");
				String name = rs.getString("name");
				String position = rs.getString("position");
				double result2 = rs.getDouble("result");

				HitterDto hdto = new HitterDto(idx2, name, position, result2);
				alhdto.add(hdto);
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
		return alhdto;
	}
   
   public ArrayList<HitterDto> getHitterList_2019(int team) {
	      ArrayList<HitterDto> hdtos = new ArrayList<HitterDto>();

	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;

	      try {
	         conn = dataSource.getConnection();

	         String query = "select idx, name, position, result from player_hitter_2019 where team = ?";
	         pstmt = conn.prepareStatement(query);
	         pstmt.setInt(1, team);

	         rs = pstmt.executeQuery();

	         while (rs.next()) {
	            int idx = rs.getInt("idx");
	            String name = rs.getString("name");
	            String position = rs.getString("position");
	            double result = rs.getDouble("result");

	            HitterDto hdto = new HitterDto(idx, name, position, result);

	            hdtos.add(hdto);
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
	      return hdtos;
}

public void tradeHitter(int tname, int tname2, int idx) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try {
		conn = dataSource.getConnection();

		String query = "update player_hitter_2019 set team = ? where team = ? and idx = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, tname2);
		pstmt.setInt(2, tname);
		pstmt.setInt(3, idx);
		

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

public void tradeHitterToHitter(int tname, int tname2, int idx, int idx2) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try {
		conn = dataSource.getConnection();

		String query = "update player_hitter_2019 set team = ? where team = ? and idx = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, tname2);
		pstmt.setInt(2, tname);
		pstmt.setInt(3, idx);
		

		pstmt.executeUpdate();
		
		query = "update player_hitter_2019 set team = ? where team = ? and idx = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, tname);
		pstmt.setInt(2, tname2);
		pstmt.setInt(3, idx2);

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

public double get2018TeamHitterStat(int team) {
    double hitterStat = 0;

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
       conn = dataSource.getConnection();

       String query = "select sum(result) from player_hitter_2018 where team = ?";
       pstmt = conn.prepareStatement(query);
       pstmt.setInt(1, team);

       rs = pstmt.executeQuery();

       while (rs.next()) {
          String sum = rs.getString(1);
          hitterStat = Double.parseDouble(sum);
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
    return hitterStat;
 }
 
 public double get2019TeamHitterStat(int team) {
    double hitterStat = 0;

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
       conn = dataSource.getConnection();

       String query = "select sum(result) from player_hitter_2019 where team = ?";
       pstmt = conn.prepareStatement(query);
       pstmt.setInt(1, team);

       rs = pstmt.executeQuery();

       while (rs.next()) {
          String sum = rs.getString(1);
          hitterStat = Double.parseDouble(sum);
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
    return hitterStat;
 }

public void reset2019() {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try {
		conn = dataSource.getConnection();

		String query = "drop table player_hitter_2019";
		pstmt = conn.prepareStatement(query);
				
		pstmt.executeUpdate();
		
		query = "create table player_hitter_2019 (select * from player_hitter_2018)";
		pstmt = conn.prepareStatement(query);
		
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

public double getResult_2018(int idx2) {
	double pitcherStat = 0;

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
       conn = dataSource.getConnection();

       String query = "select result from player_hitter_2018 where idx = ?";
       pstmt = conn.prepareStatement(query);
       pstmt.setInt(1, idx2);

       rs = pstmt.executeQuery();

       while (rs.next()) {
          String sum = rs.getString(1);
          pitcherStat = Double.parseDouble(sum);
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
    return pitcherStat;
 }

public void updateResult_2019(int idx2, double result) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try {
		conn = dataSource.getConnection();

		String query = "update player_hitter_2019 set result = ? where idx = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setDouble(1, result);
		pstmt.setInt(2, idx2);
		

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
}