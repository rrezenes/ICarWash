function filterTable(event) {
            var filter = event.target.value.toUpperCase();
            var rows = document.querySelector("#tabela7 tbody").rows;

            for (var i = 0; i < rows.length; i++) {

                var primeira = rows[i].cells[0].textContent.toUpperCase();
                var segunda = rows[i].cells[1].textContent.toUpperCase();
                var terceira = rows[i].cells[2].textContent.toUpperCase();
                var quarta = rows[i].cells[3].textContent.toUpperCase();
                var quinta = rows[i].cells[4].textContent.toUpperCase();
                var sexta = rows[i].cells[5].textContent.toUpperCase();
                var setema = rows[i].cells[6].textContent.toUpperCase();

                if (primeira.indexOf(filter) > -1 || segunda.indexOf(filter) > -1 || terceira.indexOf(filter) > -1 || quarta.indexOf(filter) > -1 || quinta.indexOf(filter) > -1 || sexta.indexOf(filter) > -1 || setema.indexOf(filter) > -1) {
                    rows[i].style.display = "";
                } else {
                    rows[i].style.display = "none";
                }
            }
        }

function filterTable(event) {
        var filter = event.target.value.toUpperCase();
        var rows = document.querySelector("#tabela2 tbody").rows;

        for (var i = 0; i < rows.length; i++) {

            var primeira = rows[i].cells[0].textContent.toUpperCase();
            var segunda = rows[i].cells[1].textContent.toUpperCase();


            if (primeira.indexOf(filter) > -1 || segunda.indexOf(filter) > -1) {
                rows[i].style.display = "";
            } else {
                rows[i].style.display = "none";
            }
        }
    }

    function filterTable(event) {
        var filter = event.target.value.toUpperCase();
        var rows = document.querySelector("#tabela3 tbody").rows;

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
