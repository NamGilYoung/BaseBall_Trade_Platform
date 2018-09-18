<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
<title>3page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
@import url(https://fonts.googleapis.com/css?family=Raleway:600);
body { 
background: #0A122A; 
   font-family: 'Raleway', sans-serif;
   display: grid;
   grid-template-areas: 
    "header"
    "section";
   grid-template-rows: 1fr;
   grid-template-columns: 1fr;
   grid-gap: 5px;
  margin: 50px 350px;  
}


header {
   background: #0A122A;
   grid-area: header;
     color: #fff;
  font-family: 'Raleway', sans-serif;
  font-size: 52px;
  font-weight: 600;
  text-transform: uppercase;
  text-align: center;
  letter-spacing: 0.3ex;
}

.text{
  color: #fff;
  font-family: 'Raleway', sans-serif;
  font-size: 72px;
  font-weight: 600;
  text-transform: uppercase;
  text-align: center;
  letter-spacing: 0.3ex;
  text-transform: uppercase;
  text-shadow: 7px 5px rgb(255, 92, 51, 0.7);
}



nav {
   background: #ABABAB;
   grid-area: nav; 
   margin: 10px;    
}

section {
   background: #ABABAB;
   border: 0px solid #fff;
   border-radius:5px;
   grid-area: section;
   height: auto;
}

footer1 {
   background: #0A122A;
   grid-area: footer1;
   height: 300px;
   margin: 1px;
}

footer2 {
   background: #0A122A;
   grid-area: footer2;
   height: 300px;
   margin: 1px 0px;   
}

header,  section, aside{
   padding: 30px;
}

nav, footer1, footer2 {
   padding: 0px;
}

.text > span.wrap::after {
  content: "|";
  color: #f61;
}

table {
font-family: 'Nanum Gothic', sans-serif;
font-weight: 700;
  border-collapse: separate;
  border-spacing: 0;
  width: 100%;
  margin: auto;
  background: #fff;
  border-radius: 4px;
}
th,
td {
  padding: 6px 15px;
  text-align: center;
}
th {
  background: #0A122A;
  color: #fff;
  text-align: center;
  height: 25px;
}
tr:first-child th:first-child {
  border-top-left-radius: 4px;
}
tr:first-child th:last-child {
  border-top-right-radius: 4px;
}
td {
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
}
td:first-child {
  border-left: 1px solid transparent;
}
tr:nth-child(even) td {
  background: #eaeaed;
}
tr:last-child td:first-child {
  border-bottom-left-radius: 4px;
}
tr:last-child td:last-child {
  border-bottom-right-radius: 4px;
}

td{
height: 100px;
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
  content: '\2039';
  position: absolute;
  opacity: 0;
  top: 0;
  left: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-left: 25px;
}

.button:hover span:after {
  opacity: 1;
  left: 0;
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
</head>
<body>

<header><div class= "text" data-speed="150" data-period="2000"
    data-type='[ 
                  "PLAYER"
                ]'></div></header>
<section>

<table>
  <thead>
    <tr>
      <th>Name</th>
      <th>Position</th>
      <th>Result</th>
    </tr>
  </thead>
  <tbody>
      <c:forEach items="${playerDetail }" var="alpdto">
            <tr align="center" height="5">
               
               <td>${alpdto.name }</td>
               <td>${alpdto.position }</td>
               <td>${alpdto.result }</td>
            </tr>
         </c:forEach>
  
    
   
  </tbody>
</table>
</section>

<br>
<br>
<center>
<a href="Result.nam"><button class="button1" style="vertical-align:middle"><span>CONFIRM</span></button></a>
</center>
<center>
<a href='javascript:history.back()'><button class="button" style="vertical-align:middle"><span>BACK</span></button></a>
</center>

</body>

<script>
window.onload = function() {
     let elements = document.getElementsByClassName('text');
     for (let i = 0; i < elements.length; ++i) {
       let messages = elements[i].getAttribute('data-type');
       let speed    = elements[i].getAttribute('data-speed');
       let period   = elements[i].getAttribute('data-period');
       if (messages) new Typewriter(elements[i], JSON.parse(messages), speed, period);
     }
   };

   function Typewriter(el, messages, speed, period) {
     this.el = el;
     this.messages = messages;
     this.speed  = parseInt(speed, 10)  || 200;
     this.period = parseInt(period, 10) || 2000;
     this.txt = '';
     this.loops = 0;
     this.isClearing = false;
     this.tick();
   }

   Typewriter.prototype.tick = function() {
     let msg  = this.messages[this.loops % this.messages.length];
     let edge = this.isClearing ? this.txt.length-1 : this.txt.length+1;
     this.txt = msg.substring(0, edge);
     this.el.innerHTML = '<span class="wrap">' + this.txt + '</span>';

     var delta = this.speed/2 + Math.random() * this.speed;
     if (this.isClearing) delta /= 2;

     if (!this.isClearing && this.txt === msg) {
       this.isClearing = true;
       delta = this.period;
     } else if (this.isClearing && this.txt === '') {
       this.loops++;
       this.isClearing = false;
       delta = this.period / 2;
     }
     setTimeout(() => this.tick(), delta);
   };

</script>





</html>