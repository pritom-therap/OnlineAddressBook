<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Simple jsp page</title>
</head>
<body>

<div class="post">
    <div class="title"><fmt:message key="vCardUpload.title"/><%--${game.gameName} khelechen ?--%>
    </div>
    <div class="entry">
        <form:form method="post" commandName="vCardUploadCmd" enctype="multipart/form-data">
            <table>

                <tr class="spaceunder2">
                    <td>
                        <label style="font-weight:bold"><fmt:message key="vCardUpload.upload"/>:</label>
                    </td>
                    <td>
                        <input type="file" name="file"/>
                    </td>
                    <td>
                        <form:errors path="file" cssClass="error"/>
                    </td>
                </tr>

                <tr class="spaceunder2">
                    <td>
                        <input type="submit" value="<fmt:message key="vCardUpload.button"/>" class="nicebutton"/>
                    </td>
                </tr>
            </table>


        </form:form>
    </div>
</div>
</body>
</html>