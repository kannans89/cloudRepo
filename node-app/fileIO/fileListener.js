var fs = require('fs');
fs.watch('./hello.txt',function(){
    console.log("file changed");
});
