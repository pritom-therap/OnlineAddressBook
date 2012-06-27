<%--
  Created by IntelliJ IDEA.
  User: pritom
  Date: 6/26/12
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head><title>Simple jsp page</title></head>
<body>

<div class="post">
    <div class="title"><fmt:message key="vCardAddition.title"/><%--${authentication.gameName} khelechen ?--%>
    </div>


    <div class="entry">
        <form:form commandName="vCard" method="post">

            <table>
                <tr class="spaceunder2">
                    <td>
                        <label style="font-weight:bold;"><fmt:message key="vCardAddition.name"/>: </label>
                    </td>
                    <td>
                            ${vCard.name}
                    </td>
                </tr>
                <tr class="spaceunder2">
                    <td>
                        <label style="font-weight:bold;"><fmt:message
                                key="vCardAddition.fullName"/>: </label>
                    </td>
                    <td>
                            ${vCard.fullName}
                    </td>
                </tr>

                <tr class="spaceunder2">
                    <td>
                        <label style="font-weight:bold;"><fmt:message key="vCardAddition.Org"/>: </label>
                    </td>
                    <td>
                            ${vCard.org}
                    </td>

                </tr>
                <tr class="spaceunder2">
                    <td>
                        <label style="font-weight:bold;"><fmt:message
                                key="vCardAddition.jobTitle"/>: </label>
                    </td>
                    <td>
                            ${vCard.title}
                    </td>

                </tr>

                <tr class="spaceunder2">
                    <td>
                        <label style="font-weight:bold;"><fmt:message
                                key="vCardAddition.telHome"/>: </label>
                    </td>
                    <td>
                            ${vCard.telephoneHome}
                    </td>

                </tr>

                <tr class="spaceunder2">
                    <td>
                        <label style="font-weight:bold;"><fmt:message
                                key="vCardAddition.telWork"/>: </label>
                    </td>
                    <td>
                            ${vCard.telephoneWork}
                    </td>

                </tr>

                <tr class="spaceunder2">
                    <td>
                        <label style="font-weight:bold;"><fmt:message
                                key="vCardAddition.addressWork"/>: </label>
                    </td>
                    <td>
                            ${vCard.addressWork}
                    </td>

                </tr>
                <tr class="spaceunder2">
                    <td>
                        <label style="font-weight:bold;"><fmt:message key="vCardAddition.email"/>: </label>
                    </td>
                    <td>
                            ${vCard.email}
                    </td>

                </tr>

            </table>

            <table>

                <tr>
                    <td width="50%">
                        <input type="submit" value="<fmt:message key="vCard.updateButton"/>"
                               class="nicebutton" name="update">
                    </td>

                    <td>
                        <input type="submit" value="<fmt:message key="vCard.deleteButton"/>"
                               class="nicebutton" name="delete">
                    </td>
                       <td>
                        <input type="submit" value="<fmt:message key="vCard.exportButton"/>"
                               class="nicebutton" name="export">
                    </td>
                </tr>
            </table>


        </form:form>
    </div>
</div>
</body>
</html>