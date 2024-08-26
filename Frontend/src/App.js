import './App.css';
import AppHeader from "./Components/AppHeader";
import SideMenu from "./Components/SideMenu";
import PageContent from "./Components/PageContent";
import AppFooter from "./Components/AppFooter";
import Login from './Pages/Login';
import { useState, useEffect } from "react";
import { useLocation, useNavigate } from "react-router-dom";

function App() {
  const [showMenu, setShowMenu] = useState(false);
  const navigate = useNavigate();
  const location = useLocation();

  useEffect(() => {
    if (location.pathname === '/login') {
      setShowMenu(false);
      console.log('false');
    } else {
      setShowMenu(true);
      console.log('true');
      const username = sessionStorage.getItem('username');
      if (username === '' || username === null) {
        navigate('/login');
        console.log('login');
      }
    }
  }, [location, navigate]);

  const currentRole = sessionStorage.getItem('currentRole');

  return (
    <div>
      {!showMenu &&
        <Login></Login>
      }
      {showMenu &&
        <div className="App">
          <AppHeader></AppHeader>
          <div className="SideMenuAndPageContent">
            <SideMenu currentRole={currentRole}></SideMenu>
            <PageContent></PageContent>
          </div>
          <AppFooter></AppFooter>
        </div>
      }
    </div>
  );
}

export default App;