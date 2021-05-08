import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SuccessRateBySeller } from 'types/sale';
import { round } from 'utils/format';
import { BASE_URL } from 'utils/requests';

type ChartData = {
    labels: {
        categories: string[]
    },
    series: [
        {
            name: string,
            data: number[]
        }
    ]
}

const BarChart = () => {

    const [chartData, setChartData] = useState<ChartData>({
        labels: {
            categories: []
        },
        series: [
            {
                name: "",
                data: []
            }
        ]
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/sales/success-rate-by-seller`)
            .then(response => {
                const data = response.data as SuccessRateBySeller[];
                const myCategories = data.map(x => x.sellerName);
                const mySeriesData = data.map(x => round((x.deals/x.visited)*100, 1));
                setChartData({
                    labels: {
                        categories: myCategories
                    },
                    series: [
                        {
                            name: "% Sucesso",
                            data: mySeriesData
                        }
                    ]
                })
                
            })

    }, [])

    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };

    return (
        <Chart 
            options={{ ...options, xaxis: chartData.labels}}
            series={chartData.series}
            type="bar"
            height="240"
        />
    )
}

export default BarChart;