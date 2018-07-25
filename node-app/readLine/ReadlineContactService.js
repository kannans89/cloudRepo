var chalk = require('chalk');
var fs = require('fs');

var contactService=function(){
    
    var obj={};
    var contact=[];

    obj.addContact=function(name,number){
        var contactToAdd={};
        contactToAdd.name=name;
        contactToAdd.no=number;
        
        var getJson = JSON.parse(fs.readFileSync('contacts.json', 'utf8'));
        contact.push(contactToAdd);
        for(var i=0;i<getJson.length;i++){
            contact.push(getJson[i]);
        }
    }

    obj.display=function(){
        var getJson = JSON.parse(fs.readFileSync('contacts.json', 'utf8'));
        for(var i=0;i<getJson.length;i++){
            console.log(chalk.green(getJson[i].name)+" : " + chalk.blue(getJson[i].no));
        }
    }

    obj.save=function(){
        var json=JSON.stringify(contact);
        fs.writeFileSync('./contacts.json', json,function(err){
            console.log("contact saved");
        });
    }

    return obj;
}
module.exports=contactService;