import { useEffect, useState } from "react";
import { Table } from "antd";
import { getSFCRule22 } from "../../../API";

function SFCRule22Summary({ instrumentid }) {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);
    getSFCRule22(instrumentid).then((data) => {
      setData(data);
      console.log(data);
      setLoading(false);
    });
  }, [instrumentid]);

  return (
    <div>
      <Table
        loading={loading}
        columns={[
          {
            title: "Date",
            dataIndex: "tranDate",
          },
          {
            title: "Purchase/Sale",
            dataIndex: "bs",
          },
          {
            title: "Number of shares",
            dataIndex: "qty",
          },
          {
            title: "Price per share",
            dataIndex: "price",
          }
        ]}
        dataSource={data}
      ></Table>
    </div>
  )



} export default SFCRule22Summary