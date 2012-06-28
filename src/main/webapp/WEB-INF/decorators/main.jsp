<%--
  Created by IntelliJ IDEA.
  User: pritom
  Date: 5/30/12
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/jmesa" prefix="jmesa" %>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>Online Address Book</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="css/jmesa.css"/>


</head>
<body>
<div id="wrapper">
    <div id="logo">
        <h1><a href="#">Online Address Book</a></h1>


        <p><em>Keep your contacts Safe and always at your grasp</em></p>


    </div>
    <hr/>
    <!-- end #logo -->
    <div id="header">
        <div id="menu">
        </div>
        <!-- end #menu -->
        <div id="search">
            <c:if test="${not empty User}">
                <label style="font-size:15px; color:#FFFFFF">
                    Hello, ${User.userName} <a href="/gamerschoice/Logout.htm">Log out</a>
                </label>
            </c:if>
        </div>
        <!-- end #search -->
    </div>
    <!-- end #header -->
    <!-- end #header-wrapper -->
    <div id="page">
        <div id="page-bgtop">
            <div id="content">
                <div>
                    <decorator:body/>
                </div>
            </div>
            <!-- end #content -->
            <div id="sidebar">
                <ul>
                    <li>
                        <h2 style="background-color:#1b63d2;color:#dedef5;font-weight:bold;">Features</h2>
                        <ul>
                            <%--<li><a href="/gamerschoice/Welcome.htm">Home</a></li>--%>
                            <c:if test="${not empty User}">
                                <li><a href="/gamerschoice/VCardAddition.htm">Add VCard</a></li>
                                <li><a href="/gamerschoice/VCards.htm">View VCards</a></li>
                                <li><a href="/gamerschoice/Search.htm">Search VCards</a></li>
                                <li><a href="/gamerschoice/UploadVCard.htm">Upload VCards</a></li>
                                <li><a href="/gamerschoice/Users.htm">View Users</a></li>
                            </c:if>
                            <c:if test="${empty User}">
                                <li><a href="/gamerschoice/Login.htm">Log In</a></li>
                                <li><a href="/gamerschoice/Register.htm">Register</a></li>
                            </c:if>
                        </ul>
                    </li>
                </ul>
                <br>
                <br>
            </div>
            <!-- end #sidebar -->
            <div style="clear: both;">&nbsp;</div>
        </div>
    </div>
    <!-- end #page -->
    <div id="footer-bgcontent">
        <div id="footer">
            <p>Copyright (c) 2012 Therap. All rights reserved. Developed by <a
                    href="https://www.facebook.com/pritomahmed.pritom">Pritom</a>
        </div>
    </div>
    <!-- end #footer -->
</div>
</body>
</html>
