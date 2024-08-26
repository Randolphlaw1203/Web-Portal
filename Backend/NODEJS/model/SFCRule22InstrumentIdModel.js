const mongoose = require("mongoose");

var SFCRule22InstrumentIdSchema = mongoose.Schema({
  instrumentId: String
})

var SFCRule22InstrumentIdModel = mongoose.model("sfcrule22instrumentids", SFCRule22InstrumentIdSchema)

module.exports = SFCRule22InstrumentIdModel;