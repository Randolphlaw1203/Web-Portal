import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Form, Input, Button, Typography, message } from 'antd';
import { UserOutlined, LockOutlined } from '@ant-design/icons';
import 'antd/dist/reset.css';
import { getLogin, getRole } from "../../API";

function Login() {
  const [userName, setUserName] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const proceedLogin = async () => {
    try {
      const res = await getLogin(userName, password);
      console.log(res);
      message.success('Login Successful');
      sessionStorage.clear();
      sessionStorage.setItem('username', userName);

      const data = await getRole(userName);
      console.log('API Response:', data);

      const user = data.users.find(user => user.username === userName);
      if (user) {
        console.log(`Role: ${user.role}`);
        sessionStorage.setItem('currentRole', user.role);
      }

      navigate('/');
    } catch (err) {
      if (err.response) {
        console.log(err.response.data);
        message.error('Login Failed: ' + err.response.data.message);
      } else {
        console.log(err);
        message.error('Login Failed: Unknown error');
      }
    }
  };

  return (
    <div style={{ maxWidth: '300px', margin: 'auto', padding: '50px' }}>
      <Typography.Title level={2}>LOGIN</Typography.Title>
      <Form
        name="login"
        initialValues={{ remember: true }}
        onFinish={proceedLogin}
      >
        <Form.Item
          name="username"
          rules={[{ required: true, message: 'Please Enter Your Username' }]}
        >
          <Input
            prefix={<UserOutlined />}
            placeholder="Username"
            value={userName}
            onChange={e => setUserName(e.target.value)}
          />
        </Form.Item>
        <Form.Item
          name="password"
          rules={[{ required: true, message: 'Please Enter Your Password' }]}
        >
          <Input
            prefix={<LockOutlined />}
            type="password"
            placeholder="Password"
            value={password}
            onChange={e => setPassword(e.target.value)}
          />
        </Form.Item>
        <Form.Item>
          <Button type="primary" htmlType="submit" style={{ width: '100%' }}>
            Login
          </Button>
        </Form.Item>
      </Form>
    </div>
  );
};

export default Login;