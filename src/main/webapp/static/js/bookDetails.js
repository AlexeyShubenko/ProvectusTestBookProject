/**
 * Created by Alexey on 05.09.2017.
 */

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