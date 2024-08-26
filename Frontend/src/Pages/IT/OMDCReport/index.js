import { useState } from "react";
import { getOMDC } from "../../../API";
import { Table, Typography, Button, Space, DatePicker, message } from "antd";
import Papa from "papaparse";
import moment from "moment";
import { saveAs } from "file-saver";
import Search from "../../../Components/Tool/Search";

function OMDCReport() {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(false);
  const [enddate, setEndDate] = useState(moment().subtract(1, "month").endOf("month"));
  const [startdate, setStartDate] = useState(moment().subtract(1, "month").endOf("month"));
  const [filteredData, setFilteredData] = useState([]);
  const { getColumnSearchProps } = Search();

  const columns = [
    {
      title: "Trade Date",
      dataIndex: "tradeDate",
    },
    {
      title: "Operator ID",
      dataIndex: "operatorId",
    },
    {
      title: "Operator Name",
      dataIndex: "operatorName",
    },
    {
      title: "Operator Group ID",
      dataIndex: "operatorGroupId",
    },
    {
      title: "Market Data",
      dataIndex: "marketData",
      ...getColumnSearchProps('marketData'),
    },
    {
      title: "Activation Date",
      dataIndex: "activationDate",
    },
    {
      title: "Termination Date",
      dataIndex: "terminationDate",
    },
    {
      title: "Operator Status",
      dataIndex: "operatorStatus",
      ...getColumnSearchProps('operatorStatus'),
    },
  ];

  const searchOMDC = async () => {
    if (!startdate || !enddate) {
      message.error("Please select both start date and end date.");
      return;
    }

    setLoading(true);
    const response = await getOMDC(
      startdate.format("YYYYMMDD"), enddate.format("YYYYMMDD")
    );
    setData(response);
    setFilteredData(response); // Initialize filtered data with the full dataset
    setLoading(false);
  };

  const exportToCSV = () => {
    const csvHeaders = columns.map(col => col.title);
    const csvData = filteredData.map(row => columns.map(col => row[col.dataIndex]));
    const csvContent = Papa.unparse([csvHeaders, ...csvData]);
    const bom = "\uFEFF";
    const csvBlob = new Blob([bom + csvContent], { type: "text/csv;charset=utf-8" });
    saveAs(csvBlob, `OMDC_${startdate.format("YYYYMMDD")}_${enddate.format("YYYYMMDD")}.csv`);
  };

  const handleTableChange = (pagination, filters, sorter, extra) => {
    setFilteredData(extra.currentDataSource); // Update filtered data
  };

  return (
    <div>
      <Typography.Title>OMDC Report</Typography.Title>
      <Space direction="vertical">
        <Space>
          Start Date:
          <DatePicker
            value={startdate}
            onChange={(date) => setStartDate(date)}
            format="YYYYMMDD"
          />
          End Date:
          <DatePicker
            value={enddate}
            onChange={(date) => setEndDate(date)}
            format="YYYYMMDD"
          />
          <Button type="primary" onClick={searchOMDC}>
            Search
          </Button>
          <Button type="primary" onClick={exportToCSV}>Export to CSV</Button>
        </Space>
        <Table
          loading={loading}
          columns={columns}
          dataSource={data}
          onChange={handleTableChange}
          bordered
          pagination={{ defaultPageSize: 20 }}
        />
      </Space>
    </div>
  );
} export default OMDCReport;