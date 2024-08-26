import React, { useState, useEffect } from 'react';
import { Card } from 'antd';
import { getMarketValue } from '../../API';
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
  ArcElement
} from 'chart.js';
import { Doughnut } from 'react-chartjs-2';

ChartJS.register(
  ArcElement,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);

function DashbaordDoughtnut() {
  const [data, setData] = useState([]);

  useEffect(() => {
    getMarketValue().then((data) => {
      setData(data);
      console.log(data);
    });
  }, []);

  const options = {
    responsive: true,
    plugins: {
      legend: {
        position: 'bottom',
      },
      title: {
        display: true,
        text: "Client's Stock Holding Value Distribution (HKD)",
      },
    },
  };

  const chartData = {
    labels: data.map((item) => item.marketId),
    datasets: [
      {
        label: "Market Value (HKD)",
        data: data.map((item) => item.marketValue_HKD),
        backgroundColor: [
          'rgba(255, 99, 132, 0.8)',  // Red
          'rgba(54, 162, 235, 0.8)',  // Blue
          'rgba(255, 206, 86, 0.8)',  // Yellow
          'rgba(75, 192, 192, 0.8)',  // Teal
          'rgba(153, 102, 255, 0.8)', // Purple
          'rgba(255, 159, 64, 0.8)',  // Orange
          'rgba(199, 199, 199, 0.8)', // Grey
          'rgba(83, 102, 255, 0.8)',  // Dark Blue
          'rgba(255, 99, 255, 0.8)',  // Pink
          'rgba(99, 255, 132, 0.8)',  // Light Green
        ],
      },
    ],
  };

  return (
    <Card style={{ width: 515 }}>
      <Doughnut options={options} data={chartData} />
    </Card>
  );
}

export default DashbaordDoughtnut;