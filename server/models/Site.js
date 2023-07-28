const mongoose = require("mongoose");
const Schema = mongoose.Schema;
const ObjectId = require("mongodb").ObjectId;

const SiteSchema  = new Schema({
  nom: { type: String ,required: true},
  idRegion: { type: ObjectId,ref: "Region", required: true},
  description: { type: String, required : true},
  ouvert: { type: Date, required : true},
  fermer: { type: Date, required : true},
  activite: { type: String, required : true}
});

module.exports = mongoose.model("Site", SiteSchema);