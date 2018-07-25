var Account=require('./account')
let acc=new Account(10,"deval",1000);
acc.deposit(100);
console.log(acc.toString());
