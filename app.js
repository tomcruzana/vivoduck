const http = require("http");
const fs = require("fs");
const express = require("express");
const gs = require("./scripts/gsAPI"); 

const app = express();

//middleware.
app.set("view engine", "ejs"); //template engine

app.use("/styles", express.static("styles")); //static files css 
app.use("/scripts", express.static("scripts")); //static files js

//routes
app.get("/", (req, res)=>{ 
	gs.authenticate(gs.gsAppend, req.query);
	res.render("index");
});

//port of the server
app.listen(9000); 