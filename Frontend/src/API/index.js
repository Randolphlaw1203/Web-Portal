import axios from 'axios';
// import { SHA256 } from 'crypto-js';

export const getClientPosition = (tradingid) => {
  return axios.get(`http://localhost:8086/webportal/api/v1/clientposition?tradingid=${tradingid}`)
    .then(response => response.data);
}

export const getEmailContact = (tradingid) => {
  return axios.get(`http://localhost:8086/webportal/api/v1/emailcontact?tradingid=${tradingid}`)
    .then(response => response.data);
}

export const getFundMarketValue = (startdate, enddate) => {
  return axios.get(`http://localhost:8088/webportal/api/v1/fundmarketvalue?startdate=${startdate}&enddate=${enddate}`)
    .then(response => response.data);
}

export const getAccountType = () => {
  return axios.get(`http://localhost:8086/webportal/api/v1/accounttype`)
    .then(response => response.data);
}

export const sendEmail = (tradingid, email, subject, html, attachment) => {
  const Html = encodeURIComponent(html);
  return axios.get(`http://localhost:8087/send?tradingid=${tradingid}&email=${email}&subject=${subject}&html=${Html}&attachment=${attachment}`)
    .then(response => response.data);
}

export const listClientPositionTradingIds = () => {
  return axios.get(`http://localhost:8087/listclientpositiontradingids`)
    .then(response => response.data);
}

export const saveClientPositionTradingIds = (tradingid) => {
  return axios.get(`http://localhost:8087/saveclientpositiontradingids?tradingid=${tradingid}`)
    .then(response => response.data);
}

export const getMarketValue = () => {
  return axios.get(`http://localhost:8086/webportal/api/v1/marketvalue`)
    .then(response => response.data);
}

export const getNumOfAccount = () => {
  return axios.get(`http://localhost:8086/webportal/api/v1/numofaccount`)
    .then(response => response.data);
}

export const getMonthlyStatement = () => {
  return axios.get(`http://localhost:8086/webportal/api/v1/monthlystatement`)
    .then(response => response.data);
}

export const getSFCRule22 = (instrumentid) => {
  return axios.get(`http://localhost:8086/webportal/api/v1/sfcrule22?instrumentid=${instrumentid}`)
    .then(response => response.data);
}

export const uploadFile = (formData) => {
  return axios.post(`http://localhost:8087/upload`, formData, {
    headers: {
      'Content-Type': 'multipart/form-data',
    },
  }).then(response => response.data);
}

export const listSFCRule22InstrumentIds = () => {
  return axios.get(`http://localhost:8087/listsfcrule22instrumentids`)
    .then(response => response.data);
}

export const saveSFCRule22InstrumentIds = (instrumentid) => {
  return axios.get(`http://localhost:8087/savesfcrule22instrumentids?instrumentid=${instrumentid}`)
    .then(response => response.data);
}

export const getDailyNav = (startdate, enddate) => {
  return axios.get(`http://localhost:8088/webportal/api/v1/dailynav?startdate=${startdate}&enddate=${enddate}`)
    .then(response => response.data);
}

export const getOMDC = (startdate, enddate) => {
  return axios.get(`http://localhost:8088/webportal/api/v1/omdc?startdate=${startdate}&enddate=${enddate}`)
    .then(response => response.data);
}

export const getRole = (q) => {
  return axios.get(`https://dummyjson.com/users/search?q=${q}`)
    .then(response => response.data);
}

export const getLogin = async (username, password) => {
  // const hashedPassword = SHA256(values.password).toString();
  const response = await axios.post('https://dummyjson.com/auth/login', {
    username,
    password,
    // password: hashedPassword
  });
  return response;
}