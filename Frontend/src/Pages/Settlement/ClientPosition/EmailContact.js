import { useEffect, useState } from "react";
import { getEmailContact, sendEmail } from "../../../API";
import { Table, Button, Space } from "antd";
import moment from "moment";

function EmailContact({ tradingid }) {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(false);
  const html = '<p>尊敬的客户:</p>现附上阁下/贵司之持仓数据供阁下/贵司参考，谢谢'

  useEffect(() => {
    setLoading(true);
    getEmailContact(tradingid).then((data) => {

      const today = moment().format("YYYYMMDD");
      const modifiedData = data.map((item) => ({
        ...item,
        subject: `${item.subAccountId} 持仓数据(仅供参考)`,
        //attachment: `C:/Client position/${today}/${item.subAccountId}_Position_${today}.csv`
        attachment: `Client position/${today}/${item.subAccountId}_Position_${today}.csv`
      }));
      setData(modifiedData);
      console.log(modifiedData);
      setLoading(false);
    });
  }, [tradingid]);

  const sendEmails = async () => {
    setLoading(true);
    const results = await Promise.all(
      data.map(item => sendEmail(item.subAccountId, item.email, item.subject, html, item.attachment))
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
      <Space direction="vertical">
        <Button type="primary"
          onClick={sendEmails} disabled={loading}>Send Email</Button>
        <Table
          loading={loading}
          columns={[
            {
              title: "Client ID",
              dataIndex: "clientId",
            },
            {
              title: "SubAccount ID",
              dataIndex: "subAccountId",
            },
            {
              title: "Email",
              dataIndex: "email",
            },
            {
              title: "Subject",
              dataIndex: "subject",
            },
            {
              title: "Attachment",
              dataIndex: "attachment",
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
        />
      </Space>
    </div>
  );
}

export default EmailContact;