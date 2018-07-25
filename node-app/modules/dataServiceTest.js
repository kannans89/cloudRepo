var service=require('./dataService');
let data=service();
data.setData(100);
data.process();
console.log(data.getData());