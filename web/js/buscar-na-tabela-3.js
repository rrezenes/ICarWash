function filterTable(event) {
    var filter = event.target.value.toUpperCase();
    var rows = document.querySelector("#tabela tbody").rows;

    for (var i = 0; i < rows.length; i++) {

        var primeira = rows[i].cells[0].textContent.toUpperCase();
        var segunda = rows[i].cells[1].textContent.toUpperCase();
        var terceira = rows[i].cells[2].textContent.toUpperCase();

        if (primeira.indexOf(filter) > -1 || segunda.indexOf(filter) > -1 || terceira.indexOf(filter) > -1) {
            rows[i].style.display = "";
        } else {
            rows[i].style.display = "none";
        }
    }
}
document.querySelector('#buscar').addEventListener('keyup', filterTable, false);