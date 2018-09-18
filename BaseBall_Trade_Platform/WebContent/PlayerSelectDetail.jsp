<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="stage.Stage" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <center>
      <table>
         <c:forEach items="${playerDetail }" var="alpdto">
            <tr align="center" height="5">
               <td>${alpdto.result }</td>
               <td>${alpdto.name }</td>
               <td>${alpdto.position }</td>
            </tr>
         </c:forEach>
      </table>
      
      <form action="TeamSelect.nam">
      	<input type="submit" value="확인">
      </form>
      
      
   </center>
</body>
</html>