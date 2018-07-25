let _accno,_name,_balance;
function Account(accno,name,balance){
    _accno=accno;
    _name=name;
    _balance=balance;
    this.deposit=function(amt){
        balance+=amt;
    }
    this.toString=function(){
        console.log("Account no: "+_accno+", Name: "+_name+", Balance: "+_balance);
    }
}
module.exports=Account;