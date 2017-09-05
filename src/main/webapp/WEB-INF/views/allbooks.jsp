<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <link rel="stylesheet" href="./static/css/cssfile.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

    <script src="./static/js/additionalFunctions.js"></script>
    <script src="./static/js/applicationForm.js"></script>
    <script src="./static/js/getAllBooks.js"></script>
    <script src="./static/js/fillComboBoxes.js"></script>
    <script src="./static/js/bookDetails.js"></script>
    <script src="./static/js/fillSelectForAuthorsAndBooks.js"></script>
    <script src="./static/js/findBooksByAuthorOrGenre.js"></script>
    <script src="./static/js/windowLoadAllBookPage.js"></script>

</head>

<body>

<div>

    <div id="allBooks">
    </div>

    <div id="details" class="existed" onclick="showHideBookDetails()">Show/Hide Additional Information</div>
    <div id="info" class="addInf"></div>

    <div class="appForm">
        <div><input type="button" id="showForm" value="Show/Hide application form" onclick="showHideApplicationForm()"/></div>
        <div id="bookOrder">
            <p class="appheader">Application form</p>
            <div>
                <label>First name:</label>
                <div><input type="text" id="firstName"></div>
            </div>
            <div>
                <label>Last name:</label>
                <div><input type="text" id="lastName"></div>
            </div>
            <div>
                <label>Book:</label>
                <div>
                    <select id="booksToBuy"></select>
                </div>
            </div>
            <div>
                <label>Address:</label>
                <div><input type="text" id="address"></div>
            </div>
            <div>
                <label>Quantity:</label>
                <div><input type="text" id="quantity"></div>
            </div>
            <div>
                <input type="submit" id="order" value="Order"/>
            </div>
        </div>
    </div>
</div>
>
<div>List of book by author</div>
<div>
    <div>
        <input type="submit" id="findBooksByAuthorName" value="Find" onclick="findBooksByAuthorName()"/>
        <select id="selectFindByAuthorName"></select>
    </div>
    <div id="booksByAuthor">
    </div>
</div>


<div>List of book by genre</div>
<div>
    <div>
        <input type="submit" id="findBooksByGenreName" value="Find" onclick="findBooksByGenreName()"/>
        <select id="selectFindBooksByGenreName"></select>
    </div>
    <div id="booksByGenre">
    </div>
</div>

</body>
</html>