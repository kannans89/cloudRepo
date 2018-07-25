var fs = require('fs');
fs.appendFile("./hello.txt", "| appended data from writeFileAsync |", function(err) {
    if(err) {
        return console.log(err);
    }
    console.log("The file was saved!");
}); 
