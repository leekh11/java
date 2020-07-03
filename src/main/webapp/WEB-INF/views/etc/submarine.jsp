<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="apple-touch-icon" type="image/png" href="https://static.codepen.io/assets/favicon/apple-touch-icon-5ae1a0698dcc2402e9712f7d01ed509a57814f994c660df9f7a952f3060705ee.png">
<meta name="apple-mobile-web-app-title" content="CodePen">
<link rel="shortcut icon" type="image/x-icon" href="https://static.codepen.io/assets/favicon/favicon-aec34940fbc1a6e787974dcd360f2c6b63348d4b1f4e06c77743096d55480f33.ico">
<link rel="mask-icon" type="" href="https://static.codepen.io/assets/favicon/logo-pin-8f3771b1072e3c38bd662872f6b673a722f4b3ca2421637d5596661b4e2132cc.svg" color="#111">
<title>CodePen - A Pen by  윤현웅</title>
<style>
    html, body {
      background: #130560;
      overflow: hidden;
    }
    
    .seaContainer {
      position: absolute;
      top: 0%;
      left: 0%;
      width: 100%;
      height: 100%;
      background: #130560;
      overflow: hidden;
    }
    
    .submarine__container {
      position: absolute;
      top: 50%;
      left: 50%;
      width: 400px;
      height: 200px;
      transform: translate(-50%, -50%);
    }
    
    .submarine__body {
      position: absolute;
      top: 50%;
      left: 50%;
      width: 250px;
      height: 80px;
      background: #e30449;
      border-radius: 50px;
      transform: translate(-50%, -50%);
    }
    
    .submarine__propeller {
      position: absolute;
      left: 80%;
      top: 50%;
      width: 30px;
      height: 50px;
      transform: translate(0%, -50%);
      perspective: 600px;
    }
    
    .propeller__perspective {
      width: 100%;
      height: 100%;
      transition: transform 1s;
      transform-style: preserve-3d;
      animation: rotateInfinite 1s linear infinite;
      cursor: pointer;
    }
    
    .submarine__propeller-parts {
      position: absolute;
      left: 0%;
      width: 100%;
      height: 100%;
      top: 0%;
      perspective: 1000px;
      transform-style: preserve-3d;
    }
    
    .darkOne {
      top: 0%;
      background: #f7ac08;
      transform: rotateY(180deg) rotateX(225deg);
    }
    
    .lightOne {
      top: 0%;
      background: #f7e349;
      transform: rotateX(45deg);
    }
    
    .submarine__sail {
      position: absolute;
      top: 40%;
      left: 50%;
      width: 90px;
      height: 50px;
      transform: translate(-50%, -100%);
      background: #c6003d;
      clip-path: polygon(0% 0%, 70% 0%, 100% 100%, 0% 100%);
    }
    
    .submarine__sail-shadow {
      position: absolute;
      width: 160%;
      height: 10%;
      background: #a10532;
      border-radius: 5px;
    }
    
    .dark1 {
      left: 0%;
      top: 0%;
      transform: translate(0%, -33%);
    }
    
    .dark2 {
      left: 0%;
      top: 50%;
    }
    
    .light1 {
      left: 20%;
      top: 20%;
      width: 50%;
      background: #ef689e;
    }
    
    .submarine__window {
      width: 25px;
      height: 25px;
      border-radius: 100%;
      background-image: linear-gradient(45deg, #c9e5d9, #fff);
      border: 8px solid #a10532;
      z-index: 10;
      animation: shadow-change 1s linear infinite;
    }
    
    .one,
    .two {
      position: absolute;
      top: 50%;
      transform: translate(-50%, -50%);
    }
    
    .one {
      left: 40%;
    }
    
    .two {
      left: 20%;
    }
    
    .submarine__shadow-dark {
      position: absolute;
      left: 70%;
      top: 50%;
      width: 70px;
      height: 10px;
      border-radius: 5px;
      transform: translate(-50%, -50%);
      background: #a10532;
    }
    
    .submarine__shadow-light {
      position: absolute;
      left: 35%;
      top: 13%;
      width: 100px;
      height: 6px;
      border-radius: 5px;
      transform: translate(-50%, -50%);
      background: #ef689e;
    }
    
    .submarine__shadow-arcLight {
      position: absolute;
      top: 65%;
      left: 80%;
      width: 20px;
      height: 20px;
      border-radius: 50%;
      background: #ef689e;
    }
    
    .submarine__periscope {
      position: absolute;
      top: 0%;
      left: 40%;
      width: 20px;
      height: 50px;
      border-right: 10px solid #e92d77;
      border-top: 10px solid #c6003d;
      border-left: 0px solid transparent;
      border-bottom: 0px solid transparent;
      border-top-right-radius: 10px;
    }
    
    .submarine__periscope-glass {
      position: absolute;
      left: 40%;
      top: 0%;
      width: 5px;
      height: 15px;
      background: #f7ac08;
      transform: translate(-50%, -15%);
    }
    
    .light {
      position: absolute;
      top: 0%;
      left: 0%;
      width: 500px;
      height: 100px;
      background: linear-gradient(to left, #817E97, #130560);
      /* The points are: centered top, left bottom, right bottom */
      clip-path: polygon(0% 0%, 50% 45%, 50% 55%, 0% 100%);
      transform: translate(-18%, -45%);
    }
    
    .bubbles__container {
      position: absolute;
      top: 50%;
      left: 55%;
      width: 100px;
      height: 50px;
      transform: translate(100%, -50%);
    }
    
    .bubbles {
      position: absolute;
      width: 10px;
      height: 10px;
      border-radius: 100%;
      left: 5%;
      top: 5%;
      background: #fff;
      opacity: 0.8;
    }
    
    .bubble-1 {
      top: 15%;
      left: 1%;
      opacity: 0;
      animation: move-right 1s infinite linear;
      animation-delay: 0.25s;
    }
    
    .bubble-2 {
      top: 30%;
      left: 1%;
      opacity: 0;
      animation: move-right 1s infinite linear;
      animation-delay: 0.5s;
    }
    
    .bubble-3 {
      top: 45%;
      left: 1%;
      opacity: 0;
      animation: move-right 1s infinite linear;
      animation-delay: 0.75s;
    }
    
    .bubble-4 {
      top: 60%;
      left: 1%;
      opacity: 0;
      animation: move-right 1s infinite linear;
      animation-delay: 1s;
    }
    
    .ground__container {
      position: absolute;
      top: 75%;
      left: 0%;
      width: 100%;
      height: 25%;
      background: #08003b;
      margin-top: 20px;
    }
    
    .ground1 {
      top: 75%;
      height: 100%;
      background: #0c0051;
    }
    
    .ground2 {
      position: absolute;
      top: 35%;
      width: 100%;
      height: 100%;
      background: #08003b;
    }
    
    .ground span {
      position: absolute;
      width: 60px;
      height: 60px;
      border-radius: 100%;
    }
    
    .ground1 span {
      background: #0c0051;
    }
    
    .ground2 span {
      background: #08003b;
      width: 80px;
      height: 80px;
      border-radius: 100%;
      transform: translateY(30%);
    }
    
    .up-1 {
      left: 0%;
      top: -2px;
      animation: moveThegroundRight 3s infinite linear;
    }
    
    .up-2 {
      left: -10%;
      top: -4px;
      animation: moveThegroundRight 4s infinite linear;
    }
    
    .up-3 {
      left: -20%;
      top: -6px;
      animation: moveThegroundRight 5s infinite linear;
    }
    
    .up-4 {
      left: -30%;
      top: -8px;
      animation: moveThegroundRight 6s infinite linear;
    }
    
    .up-5 {
      left: -40%;
      top: -10px;
      animation: moveThegroundRight 7s infinite linear;
    }
    
    .up-6 {
      left: -50%;
      top: -12px;
      animation: moveThegroundRight 8s infinite linear;
    }
    
    .up-7 {
      left: -60%;
      top: -14px;
      animation: moveThegroundRight 9s infinite linear;
    }
    
    .up-8 {
      left: -70%;
      top: -16px;
      animation: moveThegroundRight 10s infinite linear;
    }
    
    .up-9 {
      left: -80%;
      top: -18px;
      animation: moveThegroundRight 11s infinite linear;
    }
    
    .up-10 {
      left: -90%;
      top: -20px;
      animation: moveThegroundRight 12s infinite linear;
    }
    
    .up-11 {
      left: -100%;
      top: -22px;
      animation: moveThegroundRight 13s infinite linear;
    }
    
    .up-12 {
      left: -110%;
      top: -24px;
      animation: moveThegroundRight 14s infinite linear;
    }
    
    .up-13 {
      left: -120%;
      top: -26px;
      animation: moveThegroundRight 15s infinite linear;
    }
    
    .up-14 {
      left: -130%;
      top: -28px;
      animation: moveThegroundRight 16s infinite linear;
    }
    
    .up-15 {
      left: -140%;
      top: -30px;
      animation: moveThegroundRight 17s infinite linear;
    }
    
    .up-16 {
      left: -150%;
      top: -32px;
      animation: moveThegroundRight 18s infinite linear;
    }
    
    .up-17 {
      left: -160%;
      top: -34px;
      animation: moveThegroundRight 19s infinite linear;
    }
    
    .up-18 {
      left: -170%;
      top: -36px;
      animation: moveThegroundRight 20s infinite linear;
    }
    
    .up-19 {
      left: -180%;
      top: -38px;
      animation: moveThegroundRight 21s infinite linear;
    }
    
    .up-20 {
      left: -190%;
      top: -40px;
      animation: moveThegroundRight 22s infinite linear;
    }
    
    @keyframes shadow-change {
      0%,100% {
        background-image: linear-gradient(45deg, #c9e5d9 0%, #c9e5d9 20%, #fff 21%, #fff 39%, #c9e5d9 40%, #fff 41%, #fff 59%, #c9e5d9 60%);
      }
      20% {
        background-image: linear-gradient(45deg, #c9e5d9 20%, #c9e5d9 40%, #fff 41%, #fff 59%, #c9e5d9 60%, #fff 61%, #fff 79%, #c9e5d9 80%);
      }
      40% {
        background-image: linear-gradient(45deg, #c9e5d9 40%, #c9e5d9 60%, #fff 61%, #fff 79%, #c9e5d9 80%, #fff 81%, #fff 99%, #c9e5d9 0%);
      }
      60% {
        background-image: linear-gradient(45deg, #c9e5d9 60%, #c9e5d9 80%, #fff 81%, #fff 99%, #c9e5d9 0%, #fff 1%, #fff 19%, #c9e5d9 20%);
      }
      80% {
        background-image: linear-gradient(45deg, #c9e5d9 80%, #c9e5d9 0%, #fff 1%, #fff 19%, #c9e5d9 20%, #fff 21%, #fff 39%, #c9e5d9 40%);
      }
    }
    @keyframes move-right {
      0% {
        opacity: 0;
      }
      10% {
        opacity: 0.4;
        transform: translate(10%, 10%);
      }
      50% {
        opacity: 0.2;
        transform: translate(450%, 25%);
      }
      80% {
        opacity: 0;
        transform: translateX(555%);
      }
      100% {
        opacity: 0;
        left: 0%;
        top: 0%;
      }
    }
    @keyframes rotateInfinite {
      0% {
        transform: rotateX(0deg);
      }
      50% {
        transform: rotateX(180deg);
      }
      100% {
        transform: rotateX(360deg);
      }
    }
    @keyframes moveThegroundRight {
      90% {
        opacity: 1;
        left: 100%;
      }
      95%,100% {
        left: 1050%;
        opacity: 0;
      }
    }
    </style>
    <script>
      window.console = window.console || function(t) {};
    </script>
    <script>
      if (document.location.search.match(/type=embed/gi)) {
        window.parent.postMessage("resize", "*");
      }
    </script>
    </head>
    <body translate="no">
    <div class="seaContainer">
    <div class="submarine__container">
    <div class="light"></div>
    <div class="submarine__periscope"></div>
    <div class="submarine__periscope-glass"></div>
    <div class="submarine__sail">
    <div class="submarine__sail-shadow dark1">
    </div>
    <div class="submarine__sail-shadow light1"></div>
    <div class="submarine__sail-shadow dark2"></div>
    </div>
    <div class="submarine__body">
    <div class="submarine__window one">
    </div>
    <div class="submarine__window two">
    </div>
    <div class="submarine__shadow-dark"></div>
    <div class="submarine__shadow-light"></div>
    <div class="submarine__shadow-arcLight"></div>
    </div>
    <div class="submarine__propeller">
    <div class="propeller__perspective">
    <div class="submarine__propeller-parts darkOne"></div>
    <div class="submarine__propeller-parts lightOne"></div>
    </div>
    </div>
    </div>
    <div class="bubbles__container">
    <span class="bubbles bubble-1"></span>
    <span class="bubbles bubble-2"></span>
    <span class="bubbles bubble-3"></span>
    <span class="bubbles bubble-4"></span>
    </div>
    <div class="ground__container">
    <div class="ground ground1">
    <span class="up-1"></span>
    <span class="up-2"></span>
    <span class="up-3"></span>
    <span class="up-4"></span>
    <span class="up-5"></span>
    <span class="up-6"></span>
    <span class="up-7"></span>
    <span class="up-8"></span>
    <span class="up-9"></span>
    <span class="up-10"></span>
    </div>
    <div class="ground ground2">
    <span class="up-1"></span>
    <span class="up-2"></span>
    <span class="up-3"></span>
    <span class="up-4"></span>
    <span class="up-5"></span>
    <span class="up-6"></span>
    <span class="up-7"></span>
    <span class="up-8"></span>
    <span class="up-9"></span>
    <span class="up-10"></span>
    <span class="up-11"></span>
    <span class="up-12"></span>
    <span class="up-13"></span>
    <span class="up-14"></span>
    <span class="up-15"></span>
    <span class="up-16"></span>
    <span class="up-17"></span>
    <span class="up-18"></span>
    <span class="up-19"></span>
    <span class="up-20"></span>
    </div>
    </div>
    </div>
    <script src="https://static.codepen.io/assets/editor/iframe/iframeRefreshCSS-e03f509ba0a671350b4b363ff105b2eb009850f34a2b4deaadaa63ed5d970b37.js"></script>

</body>
</html>