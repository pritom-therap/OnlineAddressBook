<%--
  Created by IntelliJ IDEA.
  User: pritom
  Date: 6/26/12
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head><title>Simple jsp page</title></head>
<body>

<div class="post">
    <div class="title"><fmt:message key="vCardSearch.title"/><%--${authentication.gameName} khelechen ?--%>
    </div>
    <div class="entry">
        <form:form method="post" commandName="searchCmd" action="">
            <table>
                <tr class="spaceunder2">
                    <td width="50%">
                        <fmt:message key="vCardSearch.search"/> :
                    </td>
                    <td width="50%">
                        <form:input path="searchString"/>
                    </td>
                    <td width="50%">
                        <form:errors path="searchString" cssClass="error"/>
                    </td>
                </tr>
            </table>

            <table>

                <tr>
                    <td width="50%">
                        <input type="submit" align="right" value="<fmt:message key="vCardSearch.button"/>"
                               class="nicebutton">
                    </td>
                </tr>
            </table>

        </form:form>
    </div>

</body>
</html>