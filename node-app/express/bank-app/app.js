var express = require('express');
var BankController = require('./BankController');
var app=express();
new BankController(app);
app.use(express.static('public'));