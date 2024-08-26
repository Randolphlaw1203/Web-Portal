import { Space, Typography } from "antd";
import { UserOutlined } from "@ant-design/icons";
import DashbaordCard from "./DashbaordCard";
import DashbaordChart from "./DashbaordChart";
import DashbaordDoughnut from "./DashbaordDoughnut";
import { getAccountType } from "../../API";
import { useEffect, useState } from "react";

function Dashbaord() {


  const [data, setData] = useState([]);

  useEffect(() => {
    getAccountType().then((data) => {
      setData(data[0]);
      console.log(data);
    });
  }, []);

  return (
    <div>
      <Typography.Title>Dashbaord</Typography.Title>
      <Space direction="vertical">
        <div>
          <Space direction="horizontal">
            <DashbaordCard
              title={"Securities Margin Accounts"}
              value={data.margin}
              icon={<UserOutlined style={{
                color: "green",
                backgroundColor: "rgba(0,255,0,0.25)",
                borderRadius: 60,
                fontSize: 60,
                padding: 8
              }} />} />
            <DashbaordCard
              title={"Securities Cash Accounts"}
              value={data.cash}
              icon={<UserOutlined style={{
                color: "purple",
                backgroundColor: "rgba(0,255,255,0.25)",
                borderRadius: 60,
                fontSize: 60,
                padding: 8
              }} />} />
          </Space>
        </div>
        <div>
          <Space direction="horizontal">
            <DashbaordCard
              title={"Securities DVP Accounts"}
              value={data.dvp}
              icon={<UserOutlined style={{
                color: "blue",
                backgroundColor: "rgba(0,0,255,0.25)",
                borderRadius: 60,
                fontSize: 60,
                padding: 8
              }} />} />
            <DashbaordCard
              title={"Futures Accounts"}
              value={35696}
              icon={<UserOutlined style={{
                color: "red",
                backgroundColor: "rgba(255,0,0,0.25)",
                borderRadius: 60,
                fontSize: 60,
                padding: 8
              }} />} />
          </Space>
        </div>
        <Space>
          <DashbaordChart />
          <DashbaordDoughnut />
        </Space>
      </Space>
    </div>
  )

} export default Dashbaord;