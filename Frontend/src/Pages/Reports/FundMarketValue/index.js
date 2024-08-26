import { useState } from "react";
import { getFundMarketValue } from "../../../API";
import { Table, Typography, Button, Space, DatePicker, message } from "antd";
import Papa from "papaparse";
import moment from "moment";
import { saveAs } from "file-saver";
import Search from "../../../Components/Tool/Search";
import { ThousandSeparator } from "../../../Components/Tool/ThousandSeparator";

function FundMarketValue() {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(false);
  const [enddate, setEndDate] = useState(moment().subtract(1, "day"));
  const [startdate, setStartDate] = useState(moment(enddate).startOf("month"));
  const [filteredData, setFilteredData] = useState([]);
  const { getColumnSearchProps } = Search();

  const columns = [
    {
      title: "Trade Date",
      dataIndex: "tradeDate",
    },
    {
      title: "Client ID",
      dataIndex: "clientId",
      ...getColumnSearchProps('clientId'),
    },
    {
      title: "Market Value (HKD)",
      dataIndex: "marketValue",
      render: ThousandSeparator,
    },
    {
      title: "Instrument ID",
      dataIndex: "instrumentId",
      ...getColumnSearchProps('instrumentId'),
    },
    {
      title: "Instrument Name",
      dataIndex: "instrumentName",
    },
    {
      title: "Instrument Chinese Name",
      dataIndex: "instrumentChineseName",
    },
  ];

  const searchFundMarketValue = async () => {
    if (!startdate || !enddate) {
      message.error("Please select both start date and end date.");
      return;
    }

    setLoading(true);
    const response = await getFundMarketValue(
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
    saveAs(csvBlob, `Fund_Market_Value_${startdate.format("YYYYMMDD")}_${enddate.format("YYYYMMDD")}.csv`);
  };

  const handleTableChange = (pagination, filters, sorter, extra) => {
    setFilteredData(extra.currentDataSource); // Update filtered data
  };

  return (
    <div>
      <Typography.Title>Fund Market Value</Typography.Title>
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
          <Button type="primary" onClick={searchFundMarketValue}>
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
}

export default FundMarketValue;