import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { Space, Typography, Button } from "antd";

function AppHeader() {
  const [displayUsername, setDisplayUsername] = useState('');
  const navigate = useNavigate();

  useEffect(() => {
    const username = sessionStorage.getItem('username');
    setDisplayUsername(username);
  }, []);

  const handleLogout = () => {
    sessionStorage.clear();
    navigate('/login');
  };

  return (
    <div className="AppHeader">
      <a href="/">
        <img width={180} src="/A-05-05-04-02.png" alt="Error" />
      </a>
      <Space>
        <Typography.Text strong>Welcome <b>{displayUsername}</b></Typography.Text>
        <Button type="link" onClick={handleLogout}>Logout</Button>
      </Space>
    </div>
  );
}

export default AppHeader;