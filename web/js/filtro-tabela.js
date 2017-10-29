$("#buscar").keyup(function () {

    //split the current value of searchInput
    var data = this.value.toLowerCase().split(" ");
    console.log(data);
    //create a jquery object of the rows
    var linha = $("tbody").find("tr");
    if (this.value == "") {
        linha.show();
        return;
    }

    //hide all the rows
    linha.hide();

    //Recusively filter the jquery object to get results.
    linha.filter(function (i, v) {
        var t = $(this);
        for (var d = 0; d < data.length; ++d) {
            if ($(v).html().toLowerCase().indexOf(data[d].val()) > -1 && data[d].val()) {
                return true;
            }
        }
        return false;
    })
            //show the rows that match.
            .show();
}).focus(function () {
    this.value = "";
    $(this).css({
        "color": "black"
    });
    $(this).unbind('focus');
}).css({
    "color": "#C0C0C0"
});