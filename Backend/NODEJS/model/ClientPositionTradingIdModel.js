const mongoose = require("mongoose");

var ClientPositionTradingIdSchema = mongoose.Schema({
  tradingId: String
})

var ClientPositionTradingIdModel = mongoose.model("clientpositiontradingids", ClientPositionTradingIdSchema)

module.exports = ClientPositionTradingIdModel;