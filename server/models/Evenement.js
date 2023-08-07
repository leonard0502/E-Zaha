const mongoose = require("mongoose");
const Schema = mongoose.Schema;
const ObjectId = require("mongodb").ObjectId;

const EvenementSchema = new Schema({
  description: {type: String, required:true},
  debut : {type:Date, required:true},
  fin : {type:Date, required:true},
  idSite: {type: ObjectId,ref: "Site", required:true},
  nomImage : {type: String, required:true}
});

module.exports = mongoose.model("Evenement", EvenementSchema);