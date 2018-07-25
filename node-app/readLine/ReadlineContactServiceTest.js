var readlineSync = require('readline-sync');
var service=require('./ReadlineContactService');
let contacts=service();
var index;
while(index!=3){
options = ['Add Contact', 'Display Contacts', 'Save','Exit'],
index = readlineSync.keyInSelect(options, 'What would you like to do?');
let selectedOption=options[index];
if(selectedOption=="Add Contact"){
    var name = readlineSync.question('What is the contact name? ');
    var number = readlineSync.question('What is '+ name +'`s contact number? ');
    contacts.addContact(name,number);
}
else if(selectedOption=="Display Contacts"){
    contacts.display();
}
else if(selectedOption=="Save"){
    contacts.save();
}
}
