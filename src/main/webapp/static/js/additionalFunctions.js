/**
 * Created by Alexey on 05.09.2017.
 */

function clearPreviousInformation(elementId) {
    document.getElementById(elementId).innerHTML = "";
}

function hideAppFormInFirstTime() {
    $("div#bookOrder").hide();
}

//toggle detail book information

function showHideBookDetails() {
    $("div#info").toggle();
}
//toggle application form
function showHideApplicationForm() {
    $("div#bookOrder").toggle();
}


// $("div#details").click(function () {
//
// });
// $("input#showForm").click(function () {
//     $("div#bookOrder").toggle();
// });
