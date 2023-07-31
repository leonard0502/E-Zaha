const express = require("express");
const app = express();
const port = 3050;
app.use(express.json());

const cors = require("cors");
app.use(cors());
app.use("/evenement", require("./routes/evenement"));
app.use("/region", require("./routes/region"));
app.use("/site", require("./routes/site"));
app.use("/utilisateur", require("./routes/utilisateur"));
require("./db/connection");
require('dotenv').config();

app.listen(port, () => {
  
  console.log("SERVER is running on port: ".concat(port));
});
