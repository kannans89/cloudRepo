var fs=require('fs');
var readstream=fs.createReadStream('./hello.txt');
var writestream=fs.createWriteStream('./hello_copy.txt');
readstream.pipe(writestream);
console.log("End of program");