<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <link rel="stylesheet" href="./static/css/cssfile.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            //show all book in page
            $.ajax({
                type: 'GET',
                url: 'showAllBooks',
                contentType: 'application/json',
                success: function (data) {
                    console.log(data);
                    var ul = document.createElement("ul");
                    for (var i = 0; i < data.length; i++) {
                        var li = document.createElement("li");
                        var div = document.createElement("div");
                        div.id = "info" + i;
                        li.innerText = data[i].title;
                        li.addEventListener("click", showInfo);
                        li.id = i;
                        li.appendChild(div);
                        ul.appendChild(li);
                    }
                    document.getElementById("allBooks").innerHTML = "";
                    document.getElementById("allBooks").appendChild(ul);

                    fillComboBoxInApplicationForm(data);
                }
            });

            function fillComboBoxInApplicationForm(data) {
                for (var i = 0; i < data.length; i++) {
                    $("select#booksToBuy").append($("<option>" + data[i].title + "</option>"));
                }
            }

            //show details of clicked book
            function showInfo(event) {
                var i = event.currentTarget.id;
                clearPreviousInformation("info");
                $.ajax({
                    type: 'GET',
                    contentType: 'application/json',
                    url: 'showAllBooks',
                    success: function (data) {
                        $("div#info").append($("<div>" + "Title: " + data[i].title + "</div>"));
                        $("div#info").append($("<div>" + "Description: " + data[i].description + "</div>"));
                        $("div#info").append($("<div>" + "Price: " + data[i].price + "</div>"));
                        $("div#info").append($("<div>" + "Genres: " + data[i].genres + "</div>"));
                        $("div#info").append($("<div>" + "Authors: " + data[i].authors + "</div>"));

                    }
                });
            };
            hideAppFormInFirstTime();

            //handle button click in application form
            $("input#order").click(function () {
                var firstName = $("input#firstName").val();
                var lastName = $("input#lastName").val();
                var bookTitle = $("select#booksToBuy option:selected").text();
                var address = $("input#address").val();
                var booksQuantity = $("input#quantity").val();

                if (isNaN(booksQuantity) || booksQuantity == "") {
                    alert("Quantity is not a number!");
                } else if (firstName == "" || lastName == "" || address.equals == "") {
                    alert("Fill all information in application form!")
                } else {

                    var data = {};
                    data["firstName"] = firstName;
                    data["lastName"] = lastName;
                    data["bookTitle"] = bookTitle;
                    data["address"] = address;
                    data["booksQuantity"] = booksQuantity;

                    $.ajax({
                        type: 'POST',
                        url: 'saveOrder',
                        contentType: 'application/json',
                        dataType: "json",
                        data: JSON.stringify(data),
                        success: function (data) {
                            alert(data.firstName + " " + data.lastName + ": " + data.message);
                            $("input#firstName").innerText = "";
                            $("input#lastName").innerText = "";
                            $("input#address").innerText = "";
                            $("input#booksQuantity").innerText = "";
                        }
                    });
                }
                ;
            });

            function hideAppFormInFirstTime() {
                $("div#bookOrder").hide();
            }

            //toggle detail book information
            $("div#details").click(function () {
                $("div#info").toggle();
            });
            //toggle application form
            $("input#showForm").click(function () {
                $("div#bookOrder").toggle();
            });

            //fill select by all author name
            $.ajax({
                type: 'GET',
                url: 'getAllAuthors',
                contentType: 'application/json',
                dataType: "json",
                success: function (data) {
                    for (var i = 0; i < data.length; i++) {
                        $("select#selectFindByAuthorName").append($("<option>" + data[i].name + "</option>"));
                    }
                }
            });
            //fill select by all genre name
            $.ajax({
                type: 'GET',
                url: 'getAllGenres',
                contentType: 'application/json',
                success: function (data) {
                    for (var i = 0; i < data.length; i++) {
                        $("select#selectFindBooksByGenreName").append($("<option>" + data[i].name + "</option>"));
                    }
                }
            });

            //handle click on 'Find' button by author name
            $("input#findBooksByAuthorName").click(function () {
                clearPreviousInformation("booksByAuthor");
                var authorName = $("select#selectFindByAuthorName option:selected").text();
                console.log(authorName);
                var outData = {};
                outData["parameter"] = authorName;
                outData["searchBy"] = "byAuthorName";
                $.ajax({
                    type: 'POST',
                    url: 'showAllBooksByParameter',
                    contentType: 'application/json',
                    data: JSON.stringify(outData),
                    success: function (data) {
                        for (var i = 0; i < data.length; i++) {
                            $("div#booksByAuthor").append($("<div>" + data[i].title + "</div>"));
                        }
                    }
                });
            });
            //handle click on 'Find' button by genre name
            $("input#findBooksByGenreName").click(function () {
                clearPreviousInformation("booksByGenre");
                var genreName = $("select#selectFindBooksByGenreName option:selected").text();
                console.log(genreName);
                var outData =  {};
                outData["parameter"] = genreName;
                outData["searchBy"] = "byGenreName";
                $.ajax({
                    type: 'POST',
                    url: 'showAllBooksByParameter',
                    contentType: 'application/json',
                    data: JSON.stringify(outData),
                    success: function (data) {
                        for (var i = 0; i < data.length; i++) {
                            $("div#booksByGenre").append($("<div>" + data[i].title + "</div>"));
                        }
                    }
                });
            });

            function clearPreviousInformation(elementId) {
                document.getElementById(elementId).innerHTML = "";
            }
        });

    </script>
</head>

<div>

    <div id="allBooks">
    </div>

    <div id="details" class="existed">Show/Hide Additional Information</div>
    <div id="info" class="addInf"></div>

    <div class="appForm">
        <div><input type="button" id="showForm" value="Show/Hide application form"/></div>
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
        <input type="submit" id="findBooksByAuthorName" value="Find"/>
        <select id="selectFindByAuthorName"></select>
    </div>
    <div id="booksByAuthor">
    </div>
</div>


<div>List of book by genre</div>
<div>
    <div>
        <input type="submit" id="findBooksByGenreName" value="Find"/>
        <select id="selectFindBooksByGenreName"></select>
    </div>
    <div id="booksByGenre">
    </div>
</div>

</body>
</html>