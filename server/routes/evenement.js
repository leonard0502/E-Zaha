const express = require("express");
const ObjectId = require("mongodb").ObjectId;
const evenementRoutes = express.Router();
const Evenement = require("../models/Evenement");

evenementRoutes.post("/creerEvenement",async  (req, res) => {
  let { description, debut, fin, idSite, listeImage } = req.body;

    const newEvenement =  new Evenement({ description: description,
        debut: new Date(debut), 
        fin: new Date(fin), 
        idSite : ObjectId(idSite), 
        listeImage : listeImage});
  newEvenement
    .save()
    .then(() => {
      res.json({
        status: "EN COURS",
        message: "Création d' Evenement effectué!",
      });
    })
    .catch((err) => {
      res.json({
        status: "ECHEC",
        message: "Une erreur s'est produit lors de la création de la Evenement! "+err.message,
      });
    });
});

evenementRoutes.get("/recherche", (req, res) => {
  res.json({
            status: "ECHEC",
            message: "Aucun Evenement",
          });
  // Evenement.find({})
  //   .populate('idSite')
  //   .then((result) => {
  //     if (result.length > 0) {
  //       res.json(result);
  //     } else {
  //       res.json({
  //         status: "ECHEC",
  //         message: "Aucun Evenement",
  //       });
  //     }
  //   })
  //   .catch(() => {
  //     res.json({
  //       status: "ECHEC",
  //       message: "Une erreur s'est produit lors de l'obtention des Evenements!",
  //     });
  //   });
});

evenementRoutes.get("/getEvenement", (req, res) => {
    Evenement.find({})
      .populate('idSite')
      .then((result) => {
        if (result.length > 0) {
          res.json(result);
        } else {
          res.json({
            status: "ECHEC",
            message: "Aucun Evenement",
          });
        }
      })
      .catch(() => {
        res.json({
          status: "ECHEC",
          message: "Une erreur s'est produit lors de l'obtention des Evenements!",
        });
      });
  });

  evenementRoutes.get("/getEvenementById", (req, res) => {
    Evenement.find({ _id : {$eq : ObjectId(req.query.idEvenement)}})
    .populate('idSite')
      .then((result) => {
        if (result.length > 0) {
          res.json(result);
        } else {
          res.json({
            status: "ECHEC",
            message: "Aucun Evenement",
          });
        }
      })
      .catch(() => {
        res.json({
          status: "ECHEC",
          message: "Une erreur s'est produit lors de l'obtention de l'evenement!",
        });
      });
  });
  evenementRoutes.get("getEvenementByDate", (req, res) => {
    const date = new Date(req.query.date);
    Evenement.find({$and : [
              { debut: { $gte: new Date(date).toISOString() } },
              { fin: { $lte: new Date(date).toISOString() } }
        ]})
        .populate('idRegion')
        .then((result) => {
            if (result.length > 0) {
            res.json(result);
            } else {
            res.json({
                status: "ECHEC",
                message: "Aucun Evenement",
            });
            }
        })
        .catch(() => {
            res.json({
            status: "ECHEC",
            message: "Une erreur s'est produit lors de l'obtention des Evenements!",
            });
        });
  });

module.exports = evenementRoutes;