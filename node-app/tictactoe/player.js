function player(){
    var obj={};

    obj.name="";
	obj.mark="";
	obj.createPlayer=function(playerNo,name){
		if(playerNo==1){
			obj.mark="X";
		}
		else{
			obj.mark="0";
		}
	    obj.name=name;
    }
    
    return obj;
}
module.exports=player;