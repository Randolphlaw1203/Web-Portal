import { useState } from "react";
import { getClientPosition } from "../../../API";
import ExportToCSV from "./ExportToCSV";
import { Table, Button, Space } from "antd";
import { ThousandSeparator } from "../../../Components/Tool/ThousandSeparator";

function ClientPositionSummary({ tradingid }) {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(false);

  const getClientPositionData = async () => {
    setLoading(true);
    try {
      const data = await getClientPosition(tradingid);
      setData(data);
      console.log(data);
    } catch (error) {
      console.error("Error fetching client position:", error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div>
      <br></br>
      <Space direction="vertical">
        <Space>
          <Button type="primary"
            onClick={getClientPositionData} disabled={loading}>Retrieve</Button>
          <Button type="primary"
            onClick={() => ExportToCSV(data)}>Export To CSV</Button>
        </Space>
        <Table
          loading={loading}
          columns={[
            {
              title: "Trading A/C",
              dataIndex: "subAccountId",
            },
            {
              title: "Trading Name",
              dataIndex: "subAccountName",
            },
            {
              title: "Date",
              dataIndex: "date",
            },
            {
              title: "Market ID",
              dataIndex: "marketId",
            },
            {
              title: "Instrument ID",
              dataIndex: "instrumentId",
            },
            {
              title: "Instrument Name",
              dataIndex: "instrumentName",
            },
            {
              title: "Qty",
              dataIndex: "qty",
            },
            {
              title: "Closing Price",
              dataIndex: "closingPrice",
            },
            {
              title: "Market Value",
              dataIndex: "marketValue",
              render: ThousandSeparator,
            },
            {
              title: "CCY",
              dataIndex: "ccy",
            },
          ]}
          dataSource={data}
          pagination={true}
          bordered
        />
      </Space>
    </div>
  );
}

export default ClientPositionSummary;