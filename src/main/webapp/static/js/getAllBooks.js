/**
 * Created by Alexey on 05.09.2017.
 */

//show all book on page
function allBooks() {
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
    hideAppFormInFirstTime();
    fillAllSelects();
}