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
   <%
      String tname = (String) session.getAttribute("tname");
   %>

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
                  <th>Name</th>
                  <th>Position</th>
                  <th>P</th>
               </tr>
            </thead>
            <tbody>

               <c:forEach items="${pitcherList }" var="pdtos">
                  <tr>
                     <td><a href="PListViewDetail.nam?idx=${pdtos.idx }">${pdtos.name }</a></td>
                     <td>${pdtos.position }</td>
                     <td>${pdtos.result }</td>
                  </tr>
               </c:forEach>
               
               
               <c:forEach items="${hitterList }" var="hdtos">
                  <tr>
                     <td><a href="HListViewDetail.nam?idx=${hdtos.idx }">${hdtos.name }</a></td>
                     <td>${hdtos.position }</td>
                     <td>${hdtos.result }</td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>
   </div>

</body>
</html>
