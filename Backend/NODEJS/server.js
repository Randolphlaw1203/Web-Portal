const express = require('express');
const cors = require('cors');
const mongoose = require("mongoose");
const emailController = require('./controller/EmailController');
const ClientPositionTradingIdController = require("./controller/ClientPositionTradingIdController");
const uploadController = require('./controller/UploadController');
const SFCRule22InstrumentIds = require('./controller/SFCRule22InstrumentIdController');
const app = express();

app.use(cors({ origin: "*" }));

// Route to handle file upload
app.post('/upload', uploadController.uploadFile);

app.get('/send', emailController.sendEmail);

app.get("/listclientpositiontradingids", ClientPositionTradingIdController.listClientPositionTradingIds);

app.get("/saveclientpositiontradingids", ClientPositionTradingIdController.saveClientPositionTradingIds);

app.get("/listsfcrule22instrumentids", SFCRule22InstrumentIds.listSFCRule22InstrumentIds);

app.get("/savesfcrule22instrumentids", SFCRule22InstrumentIds.saveSFCRule22InstrumentIds);

mongoose.connect("mongodb://localhost:27017/nodejsdb")
  .then(function () {
    console.log("DB Connected");
  });

app.listen(8087, () => {
  console.log('Server is Running on Port: 8087');
});