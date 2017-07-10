<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<html>
<head>
</head>
<link rel="stylesheet" href="./static/css/cssfile.css">
<body>

    <div>
    <h2>Add new author</h2>

        <div>
            <sf:form modelAttribute="newAuthor" action="">
                    <div>

                        <div class="error">
                            ${error}
                        </div>

                        <div>
                            <label for="name"><s:message code="author.name"/></label>
                           <div>
                               <sf:input path="name"/>
                           </div>
                            <sf:errors path="name" cssClass="error"/>
                        </div>

                    </div>

                    <div>
                        <button type="submit" ><s:message code="button.submit"/></button>
                 </div>

            </sf:form>
        </div>
</div>



</body>
</html>