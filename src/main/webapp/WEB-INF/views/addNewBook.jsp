<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link rel="stylesheet" href="./static/css/cssfile.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>
        $(document).ready(function() {
            $.ajax({
                url: 'getAllAuthors',
                type: 'GET',
                contentType:"application/json",
                dataType : "json",
                success: function(data){
                    var ul = document.createElement("ul");
                    for(i in data){
                        $(ul).append($("<li>" +data[i].name+"</li>"));
                    }
                    $("div#authors").append(ul);
                }
            });
        });
    </script>
    <script>
        $(document).ready(function() {
            $.ajax({
                url: 'getAllGenres',
                type: 'GET',
                contentType:"application/json",
                dataType : "json",
                success: function(data){
                    var ulTag = document.createElement("ul");
                    for(i in data){
                        var li = document.createElement("li");
                        li.innerText=data[i].name;
                        ulTag.appendChild(li);
                    }
                    document.getElementById("genres").appendChild(ulTag);
                }
            });
        });

//        function logOut() {
//            $.ajax({
//                url:'logout',
//                type: 'GET'
//            });
//        }

    </script>

</head>

<body>

<div>
    <div class="existed">Authors and Genres which already exist</div>
    <table>
        <tr>
            <td>Authors</td>
            <td>Genres</td>
        </tr>
        <tr>
            <td><div id="authors"></div></td>
            <td><div id="genres"></div></td>
        </tr>
    </table>

</div>


    <div>
    <h2>Add new book</h2>

        <div>
            <a href="${spring:mvcUrl('addNewAuthor').build()}">Add new author</a>
            <a href="${spring:mvcUrl('addNewGenre').build()}">Add new genres</a>
        </div>

        <div>
            <sf:form modelAttribute="newBook" action="">
                    <div >

                        <div class="error">
                                ${error}
                        </div>

                        <div>
                            <label for="title"><s:message code="book.title"></s:message></label>
                           <div>
                               <sf:input path="title"/>
                           </div>
                            <div>
                            <sf:errors path="title" cssClass="error"/>
                            </div>
                        </div>

                        <div>
                            <label for="description"><s:message code="book.description"></s:message></label>
                            <div>
                                <sf:input path="description"/>
                            </div>
                            <div>
                                <sf:errors path="description" cssClass="error"/>
                            </div>
                        </div>


                        <div>
                            <label for="price"><s:message code="book.price"/></label>
                            <div>
                                <sf:input path="price"/>
                            </div>
                            <div>
                                <sf:errors path="price" cssClass="error"/>
                            </div>
                        </div>

                        <div>
                            <label for="authors"><s:message code="book.authors"/></label>
                            <div>
                                <sf:input path="authors"/>
                            </div>
                            <div>
                                <sf:errors path="authors" cssClass="error"/>
                            </div>
                        </div>

                        <div>
                            <label for="genres"><s:message code="book.genres"/></label>
                            <div>
                                <sf:input path="genres"/>
                            </div>
                            <div>
                                <sf:errors path="genres" cssClass="error"/>
                            </div>
                        </div>

                    </div>

                    <div>
                        <input type="submit" value="<s:message code="button.submit"/>"/>
                    </div>

            </sf:form>
        </div>

</div>

<%--<div>--%>
    <%--<button type="button" onclick="logOut()">Log out from admin page!</button>--%>
<%--</div>--%>
<div>
    <a href="${spring:mvcUrl('logout').build()}">Log out from admin page!</a>
</div>

</body>
</html>