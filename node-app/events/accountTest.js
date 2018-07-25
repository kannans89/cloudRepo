let Account=require('./account');
var acc1=new Account(101,"abc",100);
var sms="sms";
var email="email";

acc1.addListener(acc1.send,sms);
acc1.addListener(acc1.send,email);
acc1.deposit(100);

 