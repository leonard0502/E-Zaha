const express = require("express");
const bcrypt = require("bcryptjs");
const utilisateurRoutes = express.Router();
const Utilisateur = require("../models/Utilisateur");
const maxAge = 3 * 24 * 60 * 60 * 1000;
const SECRET_KEY = "NOTESAPI"; //cle de securite ze tina atao fa tsy votery io NOTES... io
const jwt = require("jsonwebtoken");

utilisateurRoutes.post("/login", async (req, res) => {

  let {mail, mdp } = req.body;
  try {
      const existClient = await Utilisateur.findOne({
          mail: mail
      });
      if (!existClient) {
          return res.status(200).json({
              message: "Utilisateur introuvable"
          });
      }
      const verifMdp = await bcrypt.compare(mdp, existClient.mdp);
      console.log(verifMdp);
      if (!verifMdp) {
          return res.status(200).json({
              message: "mots de passe ou mail incorrecte"
          });
      }
      const token = jwt.sign({
          mail: existClient.mail,
          id: existClient._id,
          date: new Date()
      }, SECRET_KEY, {
          expiresIn: maxAge
      });
      res.cookie('jwt', token, {
          httpOnly: false,
          maxAge: maxAge
      });
      res.status(201).json({
        idUtilisateur:existClient._id,
          nom: existClient.nom,
          prenom: existClient.prenom,
          mail: existClient.mail,
          token: token
      });
  } catch (error) {
      console.log(error);
      res.status(200).json({
          message: "Erreur dans votre code de connexion",
          error
      });
  }
});

utilisateurRoutes.post("/inscription", async (req, res) => {

  const {
      nom,prenom,dateDN,mail,mdp,numero,idRegion
  } = req.body;
  try {
      const existClient = await Utilisateur.findOne({
          mail: mail
      });
      if (existClient) {
          return res.status(200).json({
              message: "address e-mail déjà utilisé"
          });
      }
      console.log(mdp);
      const salt = bcrypt.genSaltSync(10);
    const hasshedPassord = bcrypt.hashSync(mdp, salt);
      console.log(hasshedPassord);
      new Utilisateur({
          nom: nom,
          prenom: prenom,
          dateDN: dateDN,
          mail: mail,
          mdp: hasshedPassord,
          numero: numero,
          idRegion: idRegion
      }).save().then(function (Utilisateur) {
          const token = jwt.sign({
              mail: Utilisateur.mail,
              id: Utilisateur._id
          }, SECRET_KEY, {
              expiresIn: maxAge
          });
          res.cookie('jwt', token, {
              httpOnly: true,
              maxAge
          });
          res.status(201).json({
                idUtilisateur:Utilisateur._id,
              nom: Utilisateur.nom,
              prenom: Utilisateur.prenom,
              mail: Utilisateur.mail,
              token: token

          })
      });

  } catch (error) {
      console.log(error);
      res.status(200).json({
          message: "Erreur d'inscription",
          error
      });
  }
});


// utilisateurRoutes.post("/creerUtilisateur", (req, res) => {
//     let { type, nom, prenom, mail, mdp, numero } = req.body;
//     const salt = bcrypt.genSaltSync(10);
//     const hash = bcrypt.hashSync(mdp, salt);
//     const newUtilisateur = new Utilisateur({ type: type, nom:nom, prenom:prenom, mail: mail, mdp : hash, numero:numero});
//     newUtilisateur
//       .save()
//       .then(() => {
//         res.json({
//           status: "EN COURS",
//           message: "Création d' Utilisateur effectué!",
//         });
//       })
//       .catch(() => {
//         res.json({
//           status: "ECHEC",
//           message: "Une erreur s'est produit lors de la création d' Utilisateur'!",
//         });
//       });
//   });
module.exports = utilisateurRoutes;
