const fs = require('fs');
fs.readdir('./tp', (err, files) => {
    console.log("Total no of files: "+files.length);
  files.forEach(file => {
    console.log(file);
  });
})