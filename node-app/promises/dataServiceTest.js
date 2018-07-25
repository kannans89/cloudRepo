var Dataservice=require('./dataService');
let service=Dataservice();
service.getData(100)
.then(r=> console.log(r));