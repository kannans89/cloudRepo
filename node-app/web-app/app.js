var http = require('http');
var fs = require('fs');

http.createServer(function (req, res) {
  res.writeHead(200, {'Content-Type': 'text/html'});
  var readstream=fs.createReadStream('./index.html');
  readstream.pipe(res);
}).listen(5555);
