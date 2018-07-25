var EventEmmiter = require('events');
class Account extends EventEmmiter{
    
    constructor(){
        super();
        this.balance=10;
    }
    deposit(amount){
        this.balance+=amount;
        this.emit('balanceChange',this.balance);
    }

}
module.exports=Account;