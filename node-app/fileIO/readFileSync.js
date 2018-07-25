var fs=require('fs');
var data=fs.readFileSync('./hello.txt','utf8');
console.log(data);