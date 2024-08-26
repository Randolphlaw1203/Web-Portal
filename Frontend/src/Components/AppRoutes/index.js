import { Route, Routes } from "react-router-dom"
import Dashbaord from "../../Pages/DashBarod";
import Login from "../../Pages/Login";
import ClientPosition from "../../Pages/Settlement/ClientPosition";
import SFCRule22 from "../../Pages/Settlement/SFCRule22";
import MonthlyStatementReminder from "../../Pages/Operation/MonthlyStatementReminder";
import FundMarketValue from "../../Pages/Reports/FundMarketValue";
import DailyNAVbyMarketbyAEId from "../../Pages/Reports/DailyNAV";
import Risk from "../../Pages/Risk";
import Finance from "../../Pages/Finance";
import OMDCReport from "../../Pages/IT/OMDCReport";
import NegCashBalance from "../../Pages/Operation/NegCashBalance";
import Prediction from "../../Pages/Prediction";

function AppRoutes() {

  return (
    <Routes>
      <Route path="/" element={<Dashbaord />}></Route>
      <Route path="/login" element={<Login />}></Route>
      <Route path="/clientposition" element={<ClientPosition />}></Route>
      <Route path="/sfcrule22" element={<SFCRule22 />}></Route>
      <Route path="/monthlystatementreminder" element={<MonthlyStatementReminder />}></Route>
      <Route path="/negcashbalance" element={<NegCashBalance />}></Route>
      <Route path="/risk" element={<Risk />}></Route>
      <Route path="/omdcreport" element={<OMDCReport />}></Route>
      <Route path="/fundmarketvalue" element={<FundMarketValue />}></Route>
      <Route path="/dailynavbymarketbyaeid" element={<DailyNAVbyMarketbyAEId />}></Route>
      <Route path="/finance" element={<Finance />}></Route>
      <Route path="/prediction" element={<Prediction />}></Route>
    </Routes>
  )

} export default AppRoutes;