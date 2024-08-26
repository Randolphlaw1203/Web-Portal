import { Card, Space, Statistic } from "antd";

function DashbaordCard({ title, value, icon }) {
  return (
    <Card style={{ width: 750 }}>
      <Space direction="horizontal">
        {icon}
        <Statistic
          title={title}
          value={value} >
        </Statistic>
      </Space>
    </Card>
  )
} export default DashbaordCard