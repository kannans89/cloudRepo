var Account=require('./accountInheritance');
var accountObj=new Account();
accountObj.on('balanceChange',sendSms);
accountObj.on('balanceChange',sendEmail);
accountObj.deposit(100);
function sendSms(balance){
    console.log("Sending sms, updated balance: "+balance);
}
function sendEmail(balance){
    console.log("Sending email, updated balance: "+balance);
}