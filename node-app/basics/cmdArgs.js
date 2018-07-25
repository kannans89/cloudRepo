function sayHello(){
    for(var i=2;i<process.argv.length;i++){
        console.log("hello "+process.argv[i]);
    }
}
if(process.argv.length<3){
    console.log("Please enter arguments");
}
else{
    sayHello();
}