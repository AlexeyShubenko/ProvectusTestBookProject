/**
 * Created by Alexey on 05.09.2017.
 */

//handle click on 'Find' button by author name
// $("input#findBooksByAuthorName").click(function () {
function findBooksByAuthorName() {
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
}
// });
//handle click on 'Find' button by genre name
// $("input#findBooksByGenreName").click(function () {
function findBooksByGenreName(){
    clearPreviousInformation("booksByGenre");
    var genreName = $("select#selectFindBooksByGenreName option:selected").text();
    console.log(genreName);
    var outData = {};
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
}
// });