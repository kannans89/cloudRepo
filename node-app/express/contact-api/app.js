var express = require('express');
var ContactController = require('./ContactController');
var app=express();
new ContactController(app);
app.use(express.static('public'));