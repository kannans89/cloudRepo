const fs = require('fs');

fs.appendFileSync('./hello.txt', ' | appended data from writeFileSync |',function(err){
    console.log("Data appended");
});
