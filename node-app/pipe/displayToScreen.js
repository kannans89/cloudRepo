var fs=require('fs');
var readstream=fs.createReadStream('./hello.txt');
readstream.pipe(process.stdout);
console.log("End of program");