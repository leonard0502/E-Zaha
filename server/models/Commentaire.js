const mongoose = require("mongoose");
const Schema = mongoose.Schema;
const ObjectId = require("mongodb").ObjectId;

const CommentaireSchema  = new Schema({
  idEvenement: { type: String,ref:"Evenement", required : true },
  idUtilisateur : {type : String,ref:"Utilisateur", required : true },
  contenu : {type : String, required : true },
  dateCom : {type : Date, default: Date.now , required : true },
  
});

module.exports = mongoose.model("Commentaire", CommentaireSchema);