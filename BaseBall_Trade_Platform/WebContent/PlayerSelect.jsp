<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선수 선택 페이지</title>
<link rel="stylesheet" type="text/css" href="./css/playerselect.css">
</head>

<body>
	까꿍
	<%
	String tname = (String) session.getAttribute("tname");
%>
	<%=tname%>

	<div class="div-test">
		<h1>TEAM STATUS</h1>
	</div>
	<br>
	<div class="div-wrapper">
		<div class="div-one">
			<img src='./Team_card/Team_card_<%=tname%>.png' />
		</div>
		<div class="div-two">
			<table>
				<thead>
					<tr>
						<th>Number</th>
						<th>Player</th>
						<th>Position</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${playerList }" var="pdtos">
						<tr align="center" height="5">
							<td>${pdtos.backNum }</td>
							<td>${pdtos.playerName }</td>
							<td>${pdtos.position }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
s
