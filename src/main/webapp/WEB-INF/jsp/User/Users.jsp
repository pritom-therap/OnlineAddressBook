<%--
  Created by IntelliJ IDEA.
  User: pritom
  Date: 6/12/12
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/jmesa" prefix="jmesa" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head><title>Registered Users</title></head>
<body>
<div class="post">
    <div class="title"><fmt:message key="users.title"/><%--${authentication.gameName} khelechen ?--%>
    </div>
    <div>
        <form name="UserListForm">
            <jmesa:tableModel id="tag" items="${users}" var="user">
                <jmesa:htmlTable width="800px" styleClass="jmesa" cellpadding="15px" cellspacing="5px">
                    <jmesa:htmlRow>
                        <jmesa:htmlColumn property="userName">
                            ${user.userName}</a>
                        </jmesa:htmlColumn>
                        <jmesa:htmlColumn property="email"/>
                        <jmesa:htmlColumn property="vCardCount" title="No. of VCards"/>
                    </jmesa:htmlRow>
                </jmesa:htmlTable>
            </jmesa:tableModel>
        </form>
    </div>
</div>
</body>
</html>