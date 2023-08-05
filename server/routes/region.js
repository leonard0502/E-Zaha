const express = require("express");
const ObjectId = require("mongodb").ObjectId;
const regionRoutes = express.Router();
const Region = require("../models/Region");


regionRoutes.post("/creerRegion",async  (req, res) => {
  let { intitule } = req.body;

    const newRegion =  new Region({ intitule : intitule},);
  newRegion
    .save()
    .then(() => {
      res.json({
        status: "EN COURS",
        message: "Création de Region effectué!",
      });
    })
    .catch((err) => {
      res.json({
        status: "ECHEC",
        message: "Une erreur s'est produit lors de la création de la Region! "+err.message,
      });
    });
});

regionRoutes.get("/getRegionById", (req, res) => {
  Region.find({ _id : {$eq : ObjectId(req.params.idRegion)}})
    .then((result) => {
      if (result.length > 0) {
        res.json(result);
      } else {
        res.json({
          status: "ECHEC",
          message: "Aucun Region",
        });
      }
    })
    .catch(() => {
      res.json({
        status: "ECHEC",
        message: "Une erreur s'est produit lors de l'obtention des Regions!",
      });
    });
});

regionRoutes.get("/getRegion", (req, res) => {
    Region.find({})
      .then((result) => {
        if (result.length > 0) {
          res.json(result);
        } else {
          res.json({
            status: "ECHEC",
            message: "Aucun Region",
          });
        }
      })
      .catch(() => {
        res.json({
          status: "ECHEC",
          message: "Une erreur s'est produit lors de l'obtention des Regions!",
        });
      });
  });
  
module.exports = regionRoutes;