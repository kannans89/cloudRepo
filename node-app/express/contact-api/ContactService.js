var ContactRepository=require('./ContactRepository');
var contactRepository=new ContactRepository();
function ContactService(){
    
    
    this.getContacts=function(callback){
        
         contactRepository.getContacts((contactObj)=>{
                callback(contactObj);
         });
        
    }
    this.getContact=function(phone,callback){
        
        contactRepository.getContact(phone,(contactObj)=>{
                
               callback(contactObj);
        });
       
   }
    this.addContact=function(newContact){
        
        contactRepository.addContact(newContact);
    }
    this.removeContact=function(phone){
        console.log("REMOVE "+phone);
        contactRepository.removeContact(phone);
    }
    this.updateContact=function(phone,updateContact){
        console.log("UPDATE: "+phone);
        contactRepository.updateContact(phone,updateContact);
    }

    this.authenticate=function(details,callback){
        contactRepository.authenticate(details,(authenticationRes)=>{
            callback(authenticationRes);
        });
    }
    
}
module.exports=ContactService;