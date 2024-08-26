import React, { useState, useEffect } from 'react';
import { Card } from "antd";
import { getNumOfAccount } from '../../API';
import FutAccountsData from "./DummyData/FutAccountsData.json"
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from "chart.js";
import { Bar } from "react-chartjs-2";
ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);

function DashbaordChart() {

  const [SecAccountsData, setSecAccountsData] = useState([]);

  useEffect(() => {
    getNumOfAccount().then((data) => {
      setSecAccountsData(data);
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
        text: 'Numbers of Account Opening in 2024',
      },
    },
  };

  const chartdata = {
    labels: SecAccountsData.map((data) => data.month),
    datasets: [
      {
        label: 'Securities',
        data: SecAccountsData.map((data) => data.numOfAccounts),
        backgroundColor: 'rgba(255, 99, 132, 0.5)',
      },
      {
        label: 'Futures',
        data: FutAccountsData.map((data) => data.noOfAccounts),
        backgroundColor: 'rgba(53, 162, 235, 0.5)',
      },
    ],
  };
  return (
    <Card style={{ width: 985 }}>
      <Bar options={options} data={chartdata} />
    </Card>
  )

} export default DashbaordChart