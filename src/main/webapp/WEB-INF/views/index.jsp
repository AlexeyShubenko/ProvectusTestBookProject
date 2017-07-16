<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<body>

<a href="${spring:mvcUrl('login').build()}">Add new Book</a>
<a href="${spring:mvcUrl('showAllBooks').build()}">Show all books</a>

</body>
</html>