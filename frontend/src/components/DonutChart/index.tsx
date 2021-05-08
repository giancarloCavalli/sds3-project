import axios from 'axios';
import Chart from 'react-apexcharts';
import { AmountBySeller } from 'types/sale';
import { BASE_URL } from 'utils/requests';

type ChartData = {
    labels: string[],
    series: number[]
}

const DonutChart = () => {

    //FORMA ERRADA
    let chartData: ChartData = { labels: [], series: []};
    
    //FORMA ERRADA
    axios.get(`${BASE_URL}/sales/amount-by-seller`)
        .then(response => {
            const data = response.data as AmountBySeller[];
            chartData.labels = data.map(x => x.sellerName);
            chartData.series = data.map(x => x.sum);
            console.log(chartData);
        });

    const mockData = {
        series: [477138, 499928, 444867, 220426, 473088],
        labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    }
    
    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart
            options={{ ...options, labels: chartData.labels}}
            series={chartData.series}
            type="donut"
            height="240"
        />
    )
}

export default DonutChart;