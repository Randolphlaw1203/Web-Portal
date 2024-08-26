import { Table, Typography, Button, Space } from "antd";
import { useEffect, useState } from "react";
import { getMonthlyStatement, sendEmail } from "../../../API";
import { subject, html } from "./para";

function MonthlyStatementReminder() {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);
    getMonthlyStatement().then((data) => {
      setData(data);
      console.log(data);
      setLoading(false);
    });
  }, []);

  const sendEmails = async () => {
    setLoading(true);
    const results = await Promise.all(
      data.map(item => sendEmail("", item.addressLine7, subject, html, ""))
    );
    console.log(results);
    const updatedData = data.map((item, index) => ({
      ...item,
      status: results[index][0].status,
      message: results[index][0].message,
    }));
    setData(updatedData);
    alert('All Emails Have Been Sent');
    setLoading(false);
  };

  return (
    <div>
      <Typography.Title>Monthly Statement Reminder</Typography.Title>
      <Space direction="vertical">
        <Space>
          <Button type="primary"
            onClick={sendEmails} disabled={loading}>Send Email</Button>
        </Space>
        <Table
          loading={loading}
          columns={[
            {
              title: "Client ID",
              dataIndex: "clientId",
            },
            {
              title: "Client Name",
              dataIndex: "clientName",
            },
            {
              title: "Client Chinese Name",
              dataIndex: "clientChineseName",
            },
            {
              title: "Email Address",
              dataIndex: "addressLine7",
            },
            {
              title: "Statement Date",
              dataIndex: "statementDate",
            },
            {
              title: "Status",
              dataIndex: "status",
            },
            {
              title: "Error Message",
              dataIndex: "message",
            }
          ]}
          dataSource={data}
          pagination={false}
          bordered
        ></Table>
      </Space>
    </div>
  );
}

export default MonthlyStatementReminder;