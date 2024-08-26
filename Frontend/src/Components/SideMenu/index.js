import { Menu } from "antd"
import {
  DashboardOutlined,
  ShopOutlined,
  ClusterOutlined,
  BookOutlined,
  ContainerOutlined,
  ReadOutlined,
  CompassOutlined,
  ClockCircleOutlined
} from "@ant-design/icons"
import { useNavigate } from "react-router-dom";

function SideMenu({ currentRole }) {
  const navigate = useNavigate();

  return (
    <div className="SideMenu">
      <Menu
        className="SideMenuVertical"
        theme="dark"
        onClick={(item) => {
          navigate(item.key);
        }}
        mode="inline"
        items={[
          {
            label: "Dashbaord",
            icon: <DashboardOutlined />,
            key: "/",
          },
          (currentRole === "admin" ||
            currentRole === "moderator") ? {
            label: "Settlement",
            icon: <ShopOutlined />,
            children: [
              {
                key: '/clientposition',
                label: 'Client Position',
              },
              {
                key: '/sfcrule22',
                label: 'SFC Rule 22',
              },
            ],
          } : null,
          (currentRole === "admin" ||
            currentRole === "user") ? {
            label: "Operation",
            icon: <ClusterOutlined />,
            children: [
              {
                key: "/monthlystatementreminder",
                label: 'Monthly Statement Reminder',
              },
              {
                key: "/negcashbalance",
                label: '-ve Cash Balance',
              },
            ],
          } : null,
          currentRole === "admin" ? {
            label: "Risk",
            icon: <ContainerOutlined />,
            key: "/risk",
          } : null,
          currentRole === "admin" ? {
            label: "Finance",
            icon: <ReadOutlined />,
            key: "/finance",
          } : null,
          currentRole === "admin" ? {
            label: "IT",
            icon: <CompassOutlined />,
            children: [
              {
                key: "/omdcreport",
                label: 'OMDC Report',
              },
            ],
          } : null,
          currentRole === "admin" ? {
            label: "Reports",
            icon: <BookOutlined />,
            children: [
              {
                key: '/fundmarketvalue',
                label: 'Fund Market Value',
              },
              {
                key: '/dailynavbymarketbyaeid',
                label: 'Daily NAV by Market by AEID',
              },
            ],
          } : null,
          currentRole === "admin" ? {
            label: "Prediction",
            icon: <ClockCircleOutlined />,
            key: "/prediction",
          } : null,
        ]}>
      </Menu>
    </div>
  )
} export default SideMenu;