<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    <meta charset="utf-8" />
    <meta http-equiv="x-ua-compatible" content="ie=edge" />
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="manifest" href="site.webmanifest" /> 

 
    <link
      rel="shortcut icon"
      type="image/x-icon"
      href="/resources/assets/img/jarvis/jarvis_logo.png"
    />
    <!-- 카카오 로그인 -->
    <script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
    <!-- 제이쿼리  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- CSS here -->
    <link rel="stylesheet" href="/resources/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/resources/assets/css/owl.carousel.min.css" />
    <link rel="stylesheet" href="/resources/assets/css/flaticon.css" />
    <link rel="stylesheet" href="/resources/assets/css/slicknav.css" />
    <link rel="stylesheet" href="/resources/assets/css/animate.min.css" />
    <link rel="stylesheet" href="/resources/assets/css/magnific-popup.css" />
    <link rel="stylesheet" href="/resources/assets/css/fontawesome-all.min.css" />
    <link rel="stylesheet" href="/resources/assets/css/themify-icons.css" />
    <link rel="stylesheet" href="/resources/assets/css/slick.css" />
    <link rel="stylesheet" href="/resources/assets/css/nice-select.css" />
    <link rel="stylesheet" href="/resources/assets/css/style.css" />
    
<!-- 우편함 css -->
   <style type="text/css">

      .dropdown {
        display: inline-block;
        position: relative;
      }

      .letter {
        background-color: #fff;
        border: none;
        border-radius: 5px;
        font-size: 18px;
        padding: 0px 10px;
        cursor: pointer;
      }
      .letter img {
        width: 18px;
      }
      .letter:hover {
        color: #ff2020;
        img {
          content: url(/resources/assets/img/jarvis/messageiconCutRed.png);
        }
      }

      .dropdown-options {
        display: none;
        position: absolute;
        overflow: auto;
        background-color: #fff; 
        border-radius: 5px;
        z-index: 1;
        width: 350px;
        padding: 10px;
        left: auto;
        right: 0;
      }
      .dropdown-options .letter-group{
		border: 1px solid rgba(0, 0, 0, 0.1);
		padding-top: 5px;
      }
      html *::-webkit-scrollbar{
		width: 5px;
      }
  	html *::-webkit-scrollbar-thumb {
    	background-color: grey;
  	}


      .dropdown-options .letter-box {
        display: block;
        color: #000000;
        padding: 5px;
        text-decoration: none;
        padding: 0px 5px;
      }

      .dropdown-options .letter-box:hover {
        color: #0a0a23;
        background-color: #d8d8d8;
        border-radius: 5px;
      }
      
      .dropdown-options .letter-box div{
        margin-bottom: 5px;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
      }
      .dropdown-options hr {
        margin: 5px
      }

      
      
      
      
.nav-counter {
    position: absolute;
    top: -8px; /* 조정 필요 */
    left: 20px; /* 이미지 폭 + 여백 조정 필요 */
    min-width: 8px;
    line-height: 20px;
    padding: 0 6px;
    font-weight: normal;
    font-size: small;
    color: white;
    text-align: center;
    background: #ff003c;
    border-radius: 11px;
    background-image: -webkit-linear-gradient(top, #e8616c, #dd202f);
    background-image: -moz-linear-gradient(top, #e8616c, #dd202f);
    background-image: -o-linear-gradient(top, #e8616c, #dd202f);
    background-image: linear-gradient(to bottom, #e8616c, #dd202f);
    -webkit-box-shadow: inset 0 0 1px 1px rgba(255, 255, 255, 0.1), 0 1px rgba(0, 0, 0, 0.12);
    box-shadow: inset 0 0 1px 1px rgba(255, 255, 255, 0.1), 0 1px rgba(0, 0, 0, 0.12);
}



    </style>
   