const express = require("express");
const ObjectId = require("mongodb").ObjectId;
const siteRoutes = express.Router();
const Site = require("../models/Site");

siteRoutes.post("/creerSite",async  (req, res) => {
  let { nom, idRegion, description, ouvert, fermer, activite } = req.body;

    const newSite =  new Site({ nom: nom, idRegion : ObjectId(idRegion), 
        description: description, ouvert : ouvert, 
        fermer : fermer, activite : activite});
  newSite
    .save()
    .then(() => {
      res.json({
        status: "EN COURS",
        message: "Création de Site effectué!",
      });
    })
    .catch((err) => {
      res.json({
        status: "ECHEC",
        message: "Une erreur s'est produit lors de la création de la Site! "+err.message,
      });
    });
});

siteRoutes.get("/getSite", (req, res) => {
    Site.find({})
      .populate('idRegion')
      .then((result) => {
        if (result.length > 0) {
          res.json(result);
        } else {
          res.json({
            status: "ECHEC",
            message: "Aucun Site",
          });
        }
      })
      .catch(() => {
        res.json({
          status: "ECHEC",
          message: "Une erreur s'est produit lors de l'obtention des Sites!",
        });
      });
  });

  siteRoutes.get("getSiteByIdRegion/:idRegion", (req, res) => {
  Site.find(
      { idRegion : {$eq : ObjectId(req.params.idRegion)}})
      .populate('idRegion')
      then((result) => {
          if (result.length > 0) {
          res.json(result);
          } else {
          res.json({
              status: "ECHEC",
              message: "Aucun Site",
          });
          }
      })
      .catch(() => {
          res.json({
          status: "ECHEC",
          message: "Une erreur s'est produit lors de l'obtention des Sites!",
          });
      });
});
module.exports = siteRoutes;