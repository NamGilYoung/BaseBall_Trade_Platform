<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>2page</title>
<meta charset="utf-8">
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">


      <meta name="description" content="chart created using Dataplanet live editor" />
      
      <!-- Dataplanet javascript sources -->
      <script type="text/javascript" src="http://dplive.dataplanet.co.kr//lib/3/dataplanet.js"></script>
      <script type="text/javascript" src="http://dplive.dataplanet.co.kr/lib/3/radar.js"></script>
      <script type="text/javascript" src="http://dplive.dataplanet.co.kr//lib/3/themes/dark.js"></script>
<style>
@import url(https://fonts.googleapis.com/css?family=Raleway:600);
body { 
background: #0A122A; 
   font-family: 'Raleway', sans-serif;
   display: grid;
   grid-template-areas: 
    "header header header"
    "nav section section2"
    "footer2 footer2 footer2";
   grid-template-rows: 130px 1fr 50px;
   grid-template-columns: 20% 1fr 40%;
   grid-gap: 5px;
  height: 100vh;
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

center{
  color: #000;
  font-family: 'Raleway', sans-serif;
  font-size: 32px;
  font-weight: 600;
  text-transform: uppercase;
  text-align: center;
  letter-spacing: 0.3ex;
  text-transform: uppercase;
  margin: 5px;
  font-color: #fff;
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
   background: #0A122A;
   grid-area: nav; 
   margin: 10px;    
}

section {
   background: #ABABAB;
   border: 0px solid #fff;
   border-radius:4px;
   grid-area: section;
   margin: 10px; 
   height: auto;
}

section2 {
   background: #ABABAB;
   border: 0px solid #fff;
   border-radius:4px;
   grid-area: section2;
   margin: 10px; 
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

header,  section, section2, aside{
   padding: 30px;
}

nav, footer1, footer2 {
   padding: 0px;
}




table {
font-family: 'Nanum Gothic', sans-serif;
font-weight: 700;
  border-collapse: separate;
  border-spacing: 0;
  width: 100%;
  margin: auto;
  background: #fff;
  border-radius:4px;
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


img {
   display: block;
   width: 100%;
}


a {text-decoration: none;}
a:link{
color: #000000;
}
a:visited{
color: #000000;
}

.text > span.wrap::after {
  content: "|";
  color: #f61;
}

img:hover {
   transform: scale(1.7, 1.7);
   transition: .3s transform;
}
</style>
</head>
<body>
 <%
      String tname = (String) session.getAttribute("tname2");
   %>
<!-- Note: This example only works with Windows Insider Preview Builds 16237+. -->
<header><div class= "text" data-speed="150" data-period="2000"
    data-type='[ 
                  "TEAM STATUS"
                ]'></div></header>
<nav> <img src='./Team_card/Team_card_<%=tname %>.png' onmouseover="this.src='./Text_Mining/<%=tname %>.PNG'" onmouseout="this.src='./Team_card/Team_card_<%=tname %>.png'">
<div id="chartdiv" style="width: 100%; height: 400px; background-color: #0A122A;" ></div>
</nav>
<section>
<center>Hitter</center>
<table>
  <thead>
    <tr>
      <th>Name</th>
      <th>Position</th>
      <th>Ability</th>
    </tr>
  </thead>
  <tbody>
    
               
               
               <c:forEach items="${hitterList }" var="hdtos">
                  <tr>
                     <td><a href="HListViewDetail.nam?idx=${hdtos.idx }">${hdtos.name }</a></td>
                     <td>${hdtos.position }</td>
                     <td>${hdtos.result }</td>
                  </tr>
               </c:forEach>
    
   
  </tbody>
</table></section>

<section2>
<center>Pitcher</center>
<table>
  <thead>
    <tr>
      <th>Name</th>
      <th>Position</th>
      <th>Ability</th>
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
               
               
           
    
   
  </tbody>
</table></section2>
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

      <script type="text/javascript">
         Dataplanet.makeChart("chartdiv",
            {
               "type": "radar",
               "categoryField": "country",
               "startDuration": 2,
               "theme": "dark",
               "graphs": [
                  {
                     "balloonText": "[[value]] litres of beer per year",
                     "bullet": "round",
                     "id": "AmGraph-1",
                     "valueField": "litres"
                  }
               ],
               "guides": [],
               "valueAxes": [
                  {
                     "axisTitleOffset": 20,
                     "gridType": "circles",
                     "id": "ValueAxis-1",
                     "minimum": 0,
                     "axisAlpha": 0.15
                  }
               ],
               "balloon": {},
               "titles": [],
               "dataProvider": [
                  {
                     "country": "Czech Republic",
                     "litres": 156.9
                  },
                  {
                     "country": "Ireland",
                     "litres": 131.1
                  },
                  {
                     "country": "Germany",
                     "litres": 115.8
                  },
                  {
                     "country": "eng",
                     "litres": 109.9
                  },
                  {
                     "country": "Austria",
                     "litres": 108.3
                  },
                  {
                     "country": "UK",
                     "litres": 99
                  },
                  {
                     "country": "Happy",
                     "litres": 88
                  },
                  {
                     "country": null,
                     "litres": null
                  },
                  {
                     "country": null,
                     "litres": null
                  },
                  {
                     "country": null,
                     "litres": null
                  }
               ]
            }
         );
      </script>


</html>