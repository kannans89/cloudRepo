var express = require('express');
var app=express();
app.use(express.static('public'));
app.get('/api', (req, res) => { res.sendfile('./customer.json') } )
.listen(5555, () => console.log('app listening on port 5555'))