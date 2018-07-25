var readlineSync = require('readline-sync');
 
var userName = readlineSync.question('What is your name? ');
console.log('Hi ' + userName + '!');
if (readlineSync.keyInYN('Do you want this module?')) {
    console.log('Installing now...');
  } else {
    console.log('Searching another...');
  }
  
animals = ['Lion', 'Elephant', 'Crocodile', 'Giraffe', 'Hippo'],
index = readlineSync.keyInSelect(animals, 'Which animal?');
console.log('Ok, ' + animals[index] + ' goes to your room.');
