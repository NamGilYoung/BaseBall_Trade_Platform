<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="stage.Stage" %>

<!DOCTYPE html>
<html>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
<head>
<meta charset="UTF-8">
<title>0page</title>
</head>
<style>
@import url(https://fonts.googleapis.com/css?family=Raleway:600);
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  width: 100%;
  height: 100vh;
  align-items: center;
  justify-content: center;
  justify-direction: row;
  background-color: #0A122A;
  align-content: center;
  
}

h1 {
  color: #fff;
  font-family: 'Raleway', sans-serif;
  font-size: 72px;
  font-weight: 600;
  text-transform: uppercase;
  text-align: center;
  
}
h1 span {
  display: inline-block
  ;
  opacity: 0;
  transform: translateY(20px) rotate(90deg);
  transform-origin: left;
  animation: in 0.5s forwards;
}
h1 span:nth-child(1) {
  animation-delay: 0.1s;
}
h1 span:nth-child(2) {
  animation-delay: 0.2s;
}
h1 span:nth-child(3) {
  animation-delay: 0.3s;
}
h1 span:nth-child(4) {
  animation-delay: 0.4s;
}
h1 span:nth-child(5) {
  animation-delay: 0.5s;
}
h1 span:nth-child(6) {
  animation-delay: 0.6s;
}
h1 span:nth-child(7) {
  animation-delay: 0.7s;
}

@keyframes in {
  0% {
    opacity: 0;
    transform: translateY(50px) rotate(90deg);
  }
  100% {
    opacity: 1;
    transform: translateY(0) rotate(0);
  }
}

.button {
  display: inline-block;
  border-radius: 4px;
  background-color: #e7e7e7;
  border: none;
  color: #000000;
  text-align: center;
  font-size: 23px;
  width: 180px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
  height: 50px;
  font-family: 'Raleway', sans-serif;
  font-weight: 300;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}

.button1 {
  display: inline-block;
  border-radius: 4px;
  background-color: #ff5c33;
  border: none;
  color: #000000;
  text-align: center;
  font-size: 23px;
  width: 180px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
  height: 50px;
  font-family: 'Raleway', sans-serif;
  font-weight: 300;
}

.button1 span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button1 span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button1:hover span {
  padding-right: 25px;
}

.button1:hover span:after {
  opacity: 1;
  right: 0;
}

.div-wrapper {
  background: transparent;
  border: 0;
  margin: 0 auto;
  padding: 10px;
  width: 900px;
  vertical-align: middle;
}
</style>
<body>
<br>
<br>
<br>
<br>
<BR>
<BR>
<BR>
<BR>
<BR>
<BR>
<BR>
<br>
<br>
<br>
<br>
<div class="div-wrapper">
<h1>
   <span>w</span>
   <span>e</span>
   <span>l</span>
   <span>c</span>
   <span>o</span>
   <span>m</span>
   <span>e</span>
</h1>
</div>
<BR>
<BR>

<%-- <%if( Stage.COUNT == 0) { %> --%>
<center>
<a href="Reset.nam"><button class="button1" style="vertical-align:middle"><span>START</span></button></a>
</center>
<%-- <%} else { %>
<center>
<a href="Reset.nam"><button class="button1" style="vertical-align:middle"><span>START</span></button></a>
</center>

<center>
<a href="Continue.nam"><button class="button" style="vertical-align:middle"><span>CONTINUE</span></button></a>
</center>
<%} %> --%>
</body>
</html>