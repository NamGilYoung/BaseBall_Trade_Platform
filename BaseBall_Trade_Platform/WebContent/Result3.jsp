<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
<title>4page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>

@import url(https://fonts.googleapis.com/css?family=Raleway:600);
body { 
background: #0A122A; 
   font-family: 'Raleway', sans-serif;
   display: grid;
   grid-template-areas: 
    "header header"
    "nav nav"
    "section2 section"
    "footer footer";
   grid-template-rows: 1fr;
   grid-template-columns: 1fr;
   grid-gap: 5px;
  margin: 50px 250px;  
}
k.
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

header {
   background: transparent;
   grid-area: header;
     color: #fff;
  font-family: 'Raleway', sans-serif;
  font-size: 52px;
  font-weight: 600;
  text-transform: uppercase;
  letter-spacing: 0.3ex;
  margin: 50px;
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
background: transparent;
   border: 0px solid #fff;
   border-radius:0px;
   grid-area: nav;
   height: auto;    
   font-size: 40px;
   font-family: 'Raleway', sans-serif;
  font-weight: 600;
  text-transform: uppercase;
  text-align: center;
  letter-spacing: 0.3ex;
  text-transform: uppercase;
  margin: 5px;
  color: #fff;
}

section {
   background: #fff;
   border: 0px solid #fff;
   border-radius:0px;
   grid-area: section;
   height: auto;
   border-radius:4px;
}

section2 {
   background: #ABABAB;
   border: 0px solid #fff;
   border-radius:0px;
   grid-area: section2;
   height: auto;
   padding: 20px;
   margin: 0 0 0 20px;
   width: 450px;
   border-radius:4px;
}


footer {
   background: transparent;
   border: 0px solid #fff;
   border-radius:0px;
   grid-area: footer;
   height: 30px;
   margin: 10px;
   item-align: center;
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


centered {
  position: relative;
  display: inline-block;
  width: 100%;
  background: blue;
  vertical-align: middle;
     top: 16.5%;
     margin:0;
     padding:0px;
}

.text > span.wrap::after {
  content: "|";
  color: #f61;
}


$colorBlue: rgb(56, 177, 204);
$colorGreen: rgb(44, 178, 153);
$colorViolet: rgb(142, 93, 159);

.box {
  float: left;
  background: rgba(0,0,0,0.13);
  -webkit-border-radius: 4px;
  -moz-border-radius: 4px;
  border-radius: 4px;
  font-size: 12px;
}

.skillBarContainer {
  width: 900px;
  max-width: 100%;
  height:30px;
  background: #e6eae3;
  background: rgba(8,102,220,.2);
  overflow: hidden;
  border-radius:5px;
  margin: 0;
  margin-bottom: 1px;
}


.skillBarContainer.green {
   background: rgb(29, 53, 124,.2);
   overflow: hidden;
   border-radius:5px;
   margin: 0;
   margin-bottom: 5px;
}

.skillBarContainer.violet {
   background: #e6eae3;;
   background:rgb(255, 92, 51,.2);
   overflow: hidden;
   border-radius:5px;
   margin: 0;
   margin-bottom: 5px;
}



.skillBarValue {
 height:100%;
  float: left;
  background:rgba(8,102,220);
  background: rgba(8,102,220,.75);
  text-align: right; /* Right-align text */
  color: white; /* White text color */
  margin: 0;
}


.skillBarValue.green {
  float: left;
  background:$colorGreen;
  background: rgb(29, 53, 124,.75);
  margin: 0;
  font-size: 20px;
}

.skillBarValue.violet {
  float: left;
  background:$colorViolet;
  background: rgb(255, 92, 51,.75);
  margin: 0;
  font-size: 20px;
}


/* Allowed values for the css skill bars */
.value-00  { width: 0;    }
.value-05  { width: 5%;    }
.value-10  { width: 10%;  }
.value-15  { width: 15%;  }
.value-20  { width: 20%;  }
.value-25  { width: 25%;  }
.value-30  { width: 30%;  }
.value-35  { width: 35%;  }
.value-40  { width: 40%;  }
.value-45  { width: 45%;  }
.value-50  { width: 50%;  }
.value-55  { width: 55%;  }
.value-60  { width: 60%;  }
.value-65  { width: 65%;  }
.value-70  { width: 70%;  }
.value-75  { width: 75%;  }
.value-80  { width: 80%;  }
.value-85  { width: 85%;  }
.value-90  { width: 90%;  }
.value-95  { width: 95%;  }
.value-100 { width: 100%; }

/*///////////////////////////////////////////////////
    // Animation \\ 
///////////////////////////////////////////////////*/
@-webkit-keyframes slideIn {
  0% { width: 0; }
  25% { width:100%; }
  100% { width: normal; }
}
@-moz-keyframes slideIn {
  0% { width: 0; }
  25% { width:100%; }
  100% { width: normal; }
}
@-ms-keyframes slideIn {
  0% { width: 0; }
  25% { width:100%; }
  100% { width: normal; }
}
@-o-keyframes slideIn {
  0% { width: 0; }
  25% { width:100%; }
  100% { width: normal; }
}
@keyframes slideIn {
  0% { width: 0; }
  25% { width:100%; }
  100% { width: normal; }
}
.skillBarValue {
  -webkit-animation: slideIn 2s;
  -moz-animation: slideIn 2s;
  -o-animation: slideIn 2s;
  animation: slideIn 2s;
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

table {
font-family: 'Nanum Gothic', sans-serif;
font-size: 20px;
font-weight: 700;
font-color: #000;
  border-collapse: separate;
  border-spacing: 0;
  width: 100%;
  background: rgb(255, 255, 255);
  border-radius:4px;
}
th,
td {
  padding: 6px 15px;
  text-align: center;
  height: 40px;
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
  background: rgb(234, 234, 237);
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


</style>
</head>
<body>
<header><div class= "text" data-speed="150" data-period="2000"
    data-type='[ 
                  "RESULT"
                ]'></div></header>
  <nav>
   Hello, Hanhwa
  </nav>
  
  <section2>
  <div class="centered">
<center>You are trading ..</center>
<br>
<table>
<tbody>
    <tr>
      <td>김동글</td>
      <td>↔</td>
      <td>이참새</td>
    </tr>
       <tr>
      <td>안담배</td>
      <td>↔</td>
      <td>남고양</td>
    </tr>
       <tr>
      <td>김다연</td>
      <td>↔</td>
      <td>못바꿈</td>
    </tr>
    
   
  </tbody>
</table>
</div>

</section2>
  
  
  
  
  
  
  <section>
  <div class="centered">
  <center>before</center>
    <div class="skillBarContainer green">
      <div class="skillBarValue green value-55">55%&nbsp&nbsp</div>
    </div>   
    <br>
    <br>
  <center>after</center>
    <div class="skillBarContainer violet">
      <div class="skillBarValue violet value-80">80%&nbsp&nbsp</div>
    </div>
    </div>
    </section>

<footer>
<center>
<a href="Test_00.jsp"><button class="button1" style="vertical-align:middle"><span>HOME</span></button></a>
</center>
</footer>

<
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