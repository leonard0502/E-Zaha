const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const RegionSchema = new Schema({
  intitule : {type : String, required : true}
});

module.exports = mongoose.model("Region", RegionSchema);