var http = require('http');
var fs = require('fs');
var path = require('path')
http.createServer((req, response) => {
    response.writeHead(200, { 'Content-Type': 'text/html' });
    var readstream;
    console.log(req.url);
    if (req.url == "/") {
        readstream = fs.createReadStream('./index.html');
        readstream.pipe(response);
    }
    else {
        fs.readdir('.' + req.url, (err, files) => {
            if (err) {
                if (fs.existsSync('.' + req.url)) {
                    displayFile(response, req);
                }
                else {
                    noSuchFileError(response);
                }
            }
            else {
                selectAFile(response, files);
            }
        })

    }
}).listen(5555, () => {
    console.log("started");
});
function selectAFile(response, files) {
    response.write("select one of the following files:");
    files.forEach(file => {
        response.write('<br>' + file);
    });
}
function noSuchFileError(response) {
    readstream = fs.createReadStream('./error404.html');
    readstream.pipe(response);
}
function displayFile(response, req) {
    var extension = path.extname(req.url);
    if (extension == ".png" || extension == ".jpg")
        response.writeHead(200, { 'Content-Type': 'image' });
    else
        response.writeHead(200, { 'Content-Type': 'text/html' });
    readstream = fs.createReadStream('.' + req.url);
    readstream.pipe(response);
}