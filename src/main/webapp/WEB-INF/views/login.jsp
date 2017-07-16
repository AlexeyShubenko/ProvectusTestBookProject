<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>

<head>
    <link rel="stylesheet" href="./static/css/cssfile.css">
</head>

<body>

<div class="error">
    ${error}
</div>

    <form:form action="" modelAttribute="admin" method="post">
        <div>
            <div>
                <label for="login"><spring:message code="login"/></label>
            </div>
            <div>
                <form:input path="login" />
            </div>
                <form:errors path="login" cssClass="error"/>
        </div>

        <div>
            <div>
                <label for="password"><spring:message code="password"/></label>
            </div>
            <div>
                <form:password  path="password" />
            </div>
            <form:errors path="password" cssClass="error"/>
        </div>

        <button type="submit"><spring:message code="button.login"/></button>

    </form:form>


</body>
</html>