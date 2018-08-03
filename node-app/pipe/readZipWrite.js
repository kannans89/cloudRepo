var fs=require('fs');
var zlib=require('zlib');
var gzip = zlib.createGzip();
var readstream=fs.createReadStream('./hello.txt');
var writestream=fs.createWriteStream('./hello_zip.txt.gz');
readstream.pipe(gzip)
          .pipe(writestream);
console.log("End of program");