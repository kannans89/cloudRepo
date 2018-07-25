var fs = require('fs');
var read=fs.createReadStream('./hello.txt');
read.on('data',function(data) {
    console.log(` ${data}`);
  });
read.on('open',function(){
    console.log("file is opened");
});
read.on('close',function(){
    console.log("file is closed");
});

