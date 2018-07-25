var EventEmitter=require('events');
let emitter=new EventEmitter();
let id,name;
let balance;
function Account(id,name,balance){
    this.id=id;
    this.name=name;
    this.balance=balance

    this.deposit=function(deposit){
        this.balance+=deposit;
        emitter.emit('balanceChanged',this.balance);
    }
    this.getId=function(){
        return this.id;
    }
    this.getName=function(){
        return this.name;
    }

    this.addListener=function(callback){
        emitter.on('balanceChanged',callback);
    }
    this.send=function(msg){
        console.log("sending "+msg)
    }
}
module.exports=Account;

