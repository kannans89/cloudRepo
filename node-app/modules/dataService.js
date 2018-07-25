var dataService=function(){
    var _data;
    var obj={};
    obj.setData=function(data){
        _data=data;
    }
    obj.process=function(){
        console.log("Data in process");
        console.log("Data processed");
    }
    obj.getData=function(){
        return _data;
    }
    
    obj.toString=function(){
        console.log("The data is : "+_data);
    }
    return obj;
}
module.exports=dataService;