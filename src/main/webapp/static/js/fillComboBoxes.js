/**
 * Created by Alexey on 05.09.2017.
 */

function fillComboBoxInApplicationForm(data) {
    for (var i = 0; i < data.length; i++) {
        $("select#booksToBuy").append($("<option>" + data[i].title + "</option>"));
    }
}