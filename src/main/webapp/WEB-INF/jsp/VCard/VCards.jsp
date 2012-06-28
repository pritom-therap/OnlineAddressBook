<%--
  Created by IntelliJ IDEA.
  User: pritom
  Date: 6/26/12
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/jmesa" prefix="jmesa" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head><title>Simple jsp page</title></head>
<body>
<div class="post">
    <fieldset>
        <legend><h2><fmt:message key="vCardsView.title"/></h2></legend>
        <table class="playedGameTable">
            <tr>
                <th>
                    Full Name
                </th>
                <th>
                    Organization
                </th>
                <th>
                    JobTitle
                </th>
                <th>
                    Telephone(Work)
                </th>
                <th>
                    Telephone(Home)
                </th>
                <th>
                    Email
                </th>
            </tr>
            <c:forEach items="${vCardList}" var="vCard">
                <c:url value="/VCard.htm" var="vCardURL">
                    <c:param name="vCardId" value="${vCard.vCardId}"/>
                </c:url>
                <tr>
                    <td>
                        <a href="${vCardURL}">${vCard.fullName}</a>
                    </td>

                    <td>
                            ${vCard.org}
                    </td>
                    <td>
                            ${vCard.title}
                    </td>
                    <td>
                            ${vCard.telephoneWork}
                    </td>
                    <td>
                            ${vCard.telephoneHome}
                    </td>
                    <td>
                            ${vCard.email}
                    </td>
                </tr>
                <br>
            </c:forEach>
        </table>
    </fieldset>
</div>
</body>
</html>