var dataService=function(){
    var _data;
    var obj={};
    obj.setData=function(data){
        _data=data;
    }
    obj.getData=function(num){
        var promise1= new Promise(function(resolve) {   
            num=num*2+5;  
            resolve(num);
        });
        return promise1;
    }

    obj.toString=function(){
        console.log("The data is : "+_data);
    }
    return obj;
}
module.exports=dataService;