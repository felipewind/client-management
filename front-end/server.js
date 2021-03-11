const express = require("express");

const app = express();

app.use("/", express.static("./dist/front-end"));

app.listen(80, () => console.log("HTTP Server running on port 80"));

