var chartData = {

    datasets: [{
            type: 'bar',
            label: 'Em Processo',
            borderColor: window.chartColors.blue,
            borderWidth: 2,
            fill: false,
            data: [
                10
            ]
        },
        {
            type: 'bar',
            label: 'Em Análise',
            borderColor: window.chartColors.red,
            borderWidth: 2,
            fill: false,
            data: [
                25
            ]
        },
        {
            type: 'bar',
            label: 'Finalizado',
            borderColor: window.chartColors.yellow,
            borderWidth: 2,
            fill: false,
            data: [
                100
            ]
        },
        {
            type: 'bar',
            label: 'Avaliado',
            borderColor: window.chartColors.blue,
            borderWidth: 2,
            fill: false,
            data: [
                80
            ]
        },
        {
            type: 'bar',
            label: 'Cancelado',
            borderColor: window.chartColors.orange,
            borderWidth: 2,
            fill: false,
            data: [
                5
            ]
        }]
};
