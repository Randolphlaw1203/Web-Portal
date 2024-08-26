import React, { useEffect, useState } from "react";
import { Typography, Tabs, Space, Input, Button } from "antd";
import EmailContact from "./EmailContact";
import ClientPositionSummary from "./ClientPositionSummary";
import { listClientPositionTradingIds, saveClientPositionTradingIds } from "../../../API";

function ClientPosition() {
  const [tradingid, setTradingId] = useState('');

  useEffect(() => {
    listClientPositionTradingIds().then((data) => {
      setTradingId(data[0].tradingId);
      console.log(data[0]);
    });
  }, []);

  const saveTradingId = async () => {
    const data = await saveClientPositionTradingIds(tradingid);
    console.log(data);
    alert("Trading ID Saved");
  };

  const items = [
    {
      key: '1',
      label: 'Client Position Summary',
      children: (
        <div>
          <Space direction="vertical">
            <Space>
              <Typography.Text strong>Trading ID (use "," to separate)</Typography.Text>
              <Button type="primary"
                onClick={saveTradingId}>Save Trading ID</Button>
            </Space>
            <Input style={{ width: '500px' }}
              value={tradingid}
              onChange={e => setTradingId(e.target.value)} />
          </Space>
          <ClientPositionSummary tradingid={tradingid} />
        </div>
      )
    },
    {
      key: '2',
      label: 'Email Address',
      children: (
        <div>
          <Space direction="vertical">
            <EmailContact tradingid={tradingid} />
          </Space>
        </div>
      )
    },
  ];

  // if (Current_role !== "admin") {
  //   return <div>
  //     <Typography.Title>You don't have access to this page</Typography.Title>
  //   </div>;
  // }

  return (
    <div>
      <Typography.Title>Client Position</Typography.Title>
      <Tabs defaultActiveKey="1" items={items} />
    </div>
  );
}

export default ClientPosition;