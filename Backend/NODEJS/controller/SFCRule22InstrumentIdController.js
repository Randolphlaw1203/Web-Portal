const SFCRule22InstrumentIdModel = require("../model/SFCRule22InstrumentIdModel")

module.exports.listSFCRule22InstrumentIds = function (req, res) {
  SFCRule22InstrumentIdModel.find({}).then(function (result) {
    res.json(result);
  });
};

module.exports.saveSFCRule22InstrumentIds = async (req, res) => {

  var instrumentId = req.query.instrumentid;

  await SFCRule22InstrumentIdModel.deleteMany({});

  var instrumentId = new SFCRule22InstrumentIdModel({ instrumentId: instrumentId });

  await instrumentId.save(instrumentId).then((result) => {
    res.json(result);
  });
}


