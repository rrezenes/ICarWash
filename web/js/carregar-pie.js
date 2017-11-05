var config_pie = {
    type: 'pie',
    data: {
        datasets: [{
                data: [
                    10, 5, 40, 10, 15
                ],
                backgroundColor: [
                    window.chartColors.red,
                    window.chartColors.orange,
                    window.chartColors.yellow,
                    window.chartColors.green,
                    window.chartColors.blue
                ],
                label: 'Dataset 1'
            }],
        labels: [
            "Em Processo",
            "Em Analise",
            "Finalizado",
            "Avaliado",
            "Cancelado"
        ]
    },
    options: {
        responsive: true
    }
};
