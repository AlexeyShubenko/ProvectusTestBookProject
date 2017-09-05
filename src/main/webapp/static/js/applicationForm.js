/**
 * Created by Alexey on 05.09.2017.
 */

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