<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%String before_rate = (String) request.getAttribute("before_rate");
String after_rate = (String) request.getAttribute("after_rate");

%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <center>
      <table>
         <c:forEach items="${before_pdtos }" var="b_pdtos">
            <tr align="center" height="5">
               <td>${b_pdtos.result }</td>
               <td>${b_pdtos.name }</td>
               <td>${b_pdtos.position }</td>
            </tr>
         </c:forEach>
      </table>
      
      <table>
         <c:forEach items="${before_hdtos }" var="b_hdtos">
            <tr align="center" height="5">
               <td>${b_hdtos.result }</td>
               <td>${b_hdtos.name }</td>
               <td>${b_hdtos.position }</td>
            </tr>
         </c:forEach>
         
         <tr>
         <td><%=before_rate %></td>
         </tr>
      </table>
      
      <table>
         <c:forEach items="${after_pdtos }" var="a_pdtos">
            <tr align="center" height="5">
               <td>${a_pdtos.result }</td>
               <td>${a_pdtos.name }</td>
               <td>${a_pdtos.position }</td>
            </tr>
         </c:forEach>
      </table>
      
      <table>
      
         <c:forEach items="${after_hdtos }" var="a_hdtos">
            <tr align="center" height="5">
               <td>${a_hdtos.result }</td>
               <td>${a_hdtos.name }</td>
               <td>${a_hdtos.position }</td>
            </tr>
         </c:forEach>
          <tr>
         <td><%=after_rate %></td>
         </tr>
      </table>
      
      <form action="main.nam">
      	<input type="submit" value="확인">
      </form>
   </center>
</body>
</html>