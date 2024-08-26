const ClientPositionTradingIdModel = require("../model/ClientPositionTradingIdModel")

module.exports.listClientPositionTradingIds = function (req, res) {
  ClientPositionTradingIdModel.find({}).then(function (result) {
    res.json(result);
  });
};

module.exports.saveClientPositionTradingIds = async (req, res) => {

  var tradingId = req.query.tradingid;

  await ClientPositionTradingIdModel.deleteMany({});

  var tradingId = new ClientPositionTradingIdModel({ tradingId: tradingId });

  await tradingId.save(tradingId).then((result) => {
    res.json(result);
  });
}


