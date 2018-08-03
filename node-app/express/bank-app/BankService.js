var BankRepository=require('./BankRepository');
var repository=new BankRepository();
function BankService(){
    this.addMaster=function(newMaster){
        repository.addMaster(newMaster);
    }
    this.authenticateUser=function(user,callback){
        repository.authenticateUser(user,(authenticationRes)=>{
            callback(authenticationRes);
        });
    }
    this.doAction=function(action){
        repository.doAction(action);
    }
    this.getPassbook=function(callback){
            repository.getPassbook((passbook)=>{
               callback(passbook);
        });
   }
}
module.exports=BankService;