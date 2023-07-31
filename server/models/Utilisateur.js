const mongoose = require("mongoose");
const Schema = mongoose.Schema;
const ObjectId = require("mongodb").ObjectId;

const UtilisateurSchema = new Schema({
  nom: { type: String, required: true },
  prenom: { type: String, required: true },
  dateDN: { type: Date, required: true },
  mail: { type: String, required: true },
  mdp: { type: String, required: true },
  numero: { type: String, required: true },
  idRegion: { type: ObjectId,ref: "Region", required: true, }
});

module.exports = mongoose.model("Utilisateur", UtilisateurSchema);