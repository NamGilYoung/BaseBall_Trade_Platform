<%@page import="java.sql.*"%>
<%-- JDBC API 임포트 작업 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DBTest</title>
</head>
<body>
	<%
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://192.168.100.153:3306/final";
		String id = "final";
		String pwd = "0000";

		try {
			//[1] JDBC 드라이버 로드
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			out.println("Where is your mysql jdbc driver?");
			e.printStackTrace();
			return;
		}
		out.print("mysql jdbc Driver registered!!");

		//[2]데이터베이스 연결
		Connection conn = DriverManager.getConnection(url, id, pwd);
		out.println("DB연결성공");

		//[3]데이터베이스 연결 해제
		conn.close();
	%>
</body>
</html>