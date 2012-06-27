<%--
  Created by IntelliJ IDEA.
  User: pritom
  Date: 6/26/12
  Time: 3:12 PM
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
    <div class="title"><fmt:message key="vCardAddition.title"/><%--${authentication.gameName} khelechen ?--%>
    </div>
    <div class="entry">
        <form:form method="post" commandName="vCardCmd" action="">
            <table>
                <tr class="spaceunder2">
                    <td width="50%">
                        <fmt:message key="vCardAddition.name"/> :

                    </td>
                    <td width="50%">
                        <form:input path="name"/>
                    </td>
                    <td width="50%">
                        <form:errors path="name" cssClass="error"/>
                    </td>
                </tr>
                <tr class="spaceunder2">
                    <td>
                        <fmt:message key="vCardAddition.fullName"/> :
                    </td>
                    <td>
                        <form:input path="fullName"/>
                    </td>
                    <td>
                        <form:errors path="fullName" cssClass="error"/>
                    </td>
                </tr>
                <tr class="spaceunder2">

                    <td>
                        <fmt:message key="vCardAddition.Org"/> :
                    </td>
                    <td>

                        <form:input path="org"/>
                    </td>
                    <td>
                        <form:errors path="org" cssClass="error"/>
                    </td>
                </tr>
                <tr class="spaceunder2">
                    <td>
                        <fmt:message key="vCardAddition.jobTitle"/> :
                    </td>
                    <td>
                        <form:input path="title"/>
                    </td>

                    <td>
                        <form:errors path="title" cssClass="error"/>
                    </td>
                </tr>

                <tr class="spaceunder2">
                    <td>
                        <fmt:message key="vCardAddition.photoUrl"/> :
                    </td>
                    <td>
                        <form:input path="photoUrl"/>
                    </td>

                    <td>
                        <form:errors path="photoUrl" cssClass="error"/>
                    </td>
                </tr>
                <tr class="spaceunder2">
                    <td>
                        <fmt:message key="vCardAddition.telWork"/> :
                    </td>
                    <td>
                        <form:input path="telephoneWork"/>
                    </td>

                    <td>
                        <form:errors path="telephoneWork" cssClass="error"/>
                    </td>
                </tr>
                <tr class="spaceunder2">
                    <td>
                        <fmt:message key="vCardAddition.telHome"/> :
                    </td>
                    <td>
                        <form:input path="telephoneHome"/>
                    </td>

                    <td>
                        <form:errors path="telephoneHome" cssClass="error"/>
                    </td>
                </tr>
                <tr class="spaceunder2">
                    <td>
                        <fmt:message key="vCardAddition.addressWork"/> :
                    </td>
                    <td>
                        <form:textarea path="addressWork" cols="40" rows="10"/>
                    </td>

                    <td>
                        <form:errors path="addressWork" cssClass="error"/>
                    </td>
                </tr>

                <tr class="spaceunder2">
                    <td>
                        <fmt:message key="vCardAddition.email"/> :
                    </td>
                    <td>
                        <form:input path="email"/>
                    </td>

                    <td>
                        <form:errors path="email" cssClass="error"/>
                    </td>
                </tr>
            </table>
            <table>
                <tr>
                    <td width="50%">
                        <input type="submit" align="right" value="<fmt:message key="vCardAddition.button"/>"
                               class="nicebutton">
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</div>

</body>
</html>