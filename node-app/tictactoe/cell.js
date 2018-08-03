function cell(){
    var obj={};

    obj.cellValue="";

	obj.getValue=function() {
		if(obj.cellValue==""){
			return "";
		}
		return obj.cellValue;
	}

	obj.setValue=function(mark) {
		if(obj.cellValue=="")
		    obj.cellValue=mark;
		else
			console.log("Cell already marked");
			
	}

    return obj;
}
module.exports=cell;