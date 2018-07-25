function doProcessing(data,callback){
    console.log("doing processing");
    console.log("process completed "+data);
    callback("success");
}
function display(msg){
    console.log(msg);
}
doProcessing(500,display);

doProcessing(100,function(msg){
    console.log("in callback");
    console.log(msg);
});

doProcessing(200,(m) => console.log("Arrow "+ m));

setTimeout(function(){
    console.log("In set timeout");
    console.log("success");
},1000);


let nos=[10,20,30,40,50];

nos.map((val) => {
    console.log(val);
  });

var no = nos.map(val => val * 2);
console.log(no);

let stringArr=["deval","vora","hello","hi"];
var upperCaseArr = stringArr.map(val => val.toUpperCase());
console.log(upperCaseArr);
