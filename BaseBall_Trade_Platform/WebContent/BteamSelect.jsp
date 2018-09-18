<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
<meta charset="UTF-8">
<title>1page</title>
</head>

<style>
@import url(https://fonts.googleapis.com/css?family=Raleway:600);
* {
   margin: 0;
   padding: 0;
   box-sizing: border-box;
}

body {
   font: 14px/1 'Open Sans', sans-serif;
   background: #0A122A; 
    overflow: hidden;   
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
}

.gallery {
   width: 810px;
   margin: 0 auto;
   padding: 5px;
   background: rgb(255, 255, 255);
   box-shadow: 0 1px 2px rgba(0, 0, 0, .3);
   border-radius:5px;
}

.gallery>div {
   position: relative;
   float: left;
   padding: 5px;
}

.gallery>div>img {
   display: block;
   width: 150px;
   transition: .1s transform;
   transform: translateZ(0); /* hack */
}

.gallery>div>a {
   display: block;
   width: 150px;
   transition: .1s transform;
   transform: translateZ(0); /* hack */
}

.gallery>div>a>img {
   display: block;
   width: 150px;
   transition: .1s transform;
   transform: translateZ(0); /* hack */
}

.gallery>div:hover {
   z-index: 1;
}

.gallery>div:hover>img {
   transform: scale(1.7, 1.7);
   transition: .3s transform;
}

.gallery>div:hover>a {
   transform: scale(1.7, 1.7);
   transition: .3s transform;
}

.cf:before, .cf:after {
   display: table;
   content: "";
   line-height: 0;
}

.cf:after {
   clear: both;
}

h1 {
   margin: 40px 0;
   font-size: 30px;
   font-weight: 300;
   text-align: center;
}

/* 제목 */
h3 {
   text-align: center;
   font: 800 1.5rem Montserrat, sans-serif;
   letter-spacing: -0.07ex;
}

h4 {
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

h5 {
   text-align: center;
   font: 800 0.5rem Montserrat, sans-serif;
   letter-spacing: -0.07ex;
   animation: anim 1.5s infinite alternate ease-in-out;
}

@keyframes anim {
  from {
    text-shadow: 0 0 5px transparent;
  }
  to {
    text-shadow: 0 18px 40px rgba(0, 0, 0, 0.5);
  }
}

</style>

<body>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   <h3></h3>
   <h4>WHAT IF ..</h4>
   <br>
   <br>
   <br>
   <br>
   <div class="gallery cf">
      <div>
         <a href="PListView.nam?tname=1"> <img src="Team_card/Team_card_hanhwa.png" />
         </a>
      </div>
      <div>
         <a href="PListView.nam?tname=2"> <img src="Team_card/Team_card_doosan.png" />
         </a>
      </div>
      <div>
         <a href="PListView.nam?tname=3"> <img src="Team_card/Team_card_kia.png" />
         </a>
      </div>
      <div>
         <a href="PListView.nam?tname=4"> <img src="Team_card/Team_card_kt.png" />
         </a>
      </div>
      <div>
         <a href="PListView.nam?tname=5"> <img src="Team_card/Team_card_lg.png" />
         </a>
      </div>
      <div>
         <a href="PListView.nam?tname=6"> <img src="Team_card/Team_card_lotte.png" />
         </a>
      </div>
      <div>
         <a href="PListView.nam?tname=7"> <img src="Team_card/Team_card_nc.png" />
         </a>
      </div>
      <div>
         <a href="PListView.nam?tname=8"> <img src="Team_card/Team_card_nexen.png" />
         </a>
      </div>
      <div>
         <a href="PListView.nam?tname=9"> <img src="Team_card/Team_card_sk.png" />
         </a>
      </div>
      <div>
         <a href="PListView.nam?tname=10"> <img src="Team_card/Team_card_ss.png" />
         </a>
      </div>

   </div>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<h5>TEAM5</h5>
<br>
<br>
<br>
<br>

   



</body>
</html>