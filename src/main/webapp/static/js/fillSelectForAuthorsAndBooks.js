/**
 * Created by Alexey on 05.09.2017.
 */

function fillAllSelects() {

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

}