const express = require("express");
const ObjectId = require("mongodb").ObjectId;
const commentaireRoutes = express.Router();
const Commentaire = require("../models/Commentaire");

commentaireRoutes.post("/creerCommentaire",async  (req, res) => {
  let { idEvenement, idUtilisateur, contenu, dateCom } = req.body;

    const newCommentaire =  new Commentaire({ idEvenement: idEvenement,
        idUtilisateur: idUtilisateur, 
        contenu: contenu, 
        dateCom : dateCom});
  newCommentaire
    .save()
    .then(() => {
      res.json({
        status: "EN COURS",
        message: "Création  Commentaire effectué!",
      });
    })
    .catch((err) => {
      res.json({
        status: "ECHEC",
        message: "Une erreur s'est produit lors de la création de la Commentaire! "+err.message,
      });
    });
});

commentaireRoutes.get("getCommentaireByIdEventAndIdUtilisateur", (req, res) => {
    const {idEvenement, idUtilisateur}  = req.query;
    Commentaire.find({ $and : [
           { idEvenement : {$eq : ObjectId(idEvenement)}},
           { idUtilisateur : {$eq : ObjectId(idUtilisateur)}},
        ]})
        .populate('idEvenement')
        .populate('idUtilisateur')
        then((result) => {
            if (result.length > 0) {
            res.json(result);
            } else {
            res.json({
                status: "ECHEC",
                message: "Aucun Commentaire",
            });
            }
        })
        .catch(() => {
            res.json({
            status: "ECHEC",
            message: "Une erreur s'est produit lors de l'obtention des Commentaires!",
            });
        });
});

commentaireRoutes.get("/getCommentaireByIdEvent", (req, res) => {
    const idEvenement = req.query.idEvenement;
    Commentaire.find({idEvenement : ObjectId(idEvenement)})
        .populate('idEvenement')
        .populate('idUtilisateur')
        .then((result) => {
            if (result.length > 0) {
            res.json(result);
            } else {
            res.json({
                status: "ECHEC",
                message: "Aucun Commentaire",
            });
            }
        })
        .catch(() => {
            res.json({
            status: "ECHEC",
            message: "Une erreur s'est produit lors de l'obtention des Commentaires!",
            });
        });
});

commentaireRoutes.get("/getCommentaire", (req, res) => {
    Commentaire.find({})
      .populate('idEvenement')
      .populate('idUtilisateur')
      .then((result) => {
        if (result.length > 0) {
          res.json(result);
        } else {
          res.json({
            status: "ECHEC",
            message: "Aucun Commentaire",
          });
        }
      })
      .catch(() => {
        res.json({
          status: "ECHEC",
          message: "Une erreur s'est produit lors de l'obtention des Commentaires!",
        });
      });
  });

module.exports = commentaireRoutes;