<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="utf-8" />
    <meta http-equiv="x-ua-compatible" content="ie=edge" />
    <title>Watch shop | eCommers</title>
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="manifest" href="site.webmanifest" />
    <link
      rel="shortcut icon"
      type="image/x-icon"
      href="/resources/assets/img/favicon.ico"
    />

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
      .cnt {
        position: relative;
      }

      .cnt::before {
        position: absolute;
        content: "${cnt}";
        background: #ff003c;
        color: #fff;
        text-align: center;
        border-radius: 8px;
        font-size: 10px;
        top: -5px;
        left: 20px;
        transition: 0.2s;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
        padding: 1px 3px;
        text-transform: uppercase;
        letter-spacing: 1px;
        font-weight: 500;
      }
    </style>
   