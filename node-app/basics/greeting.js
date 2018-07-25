function greet(hours){ 
    
    if(hours<12){
        console.log("Good morning");
    }
    else if(hours<17){
        console.log("Good afternoon");
    }
    else if(hours<24){
        console.log("Good evening")
    }

}
var date=new Date();
greet(date.getHours());