function cell(){
    var obj={};

    var cellValue="";

	obj.getValue=function() {
		if(this.cellValue==""){
			return null;
		}
		return cellValue;
	}

	obj.setValue=function(mark) {
		if(cellValue=="")
		    cellValue=mark;
		else
            console.log("Cell already marked");
	}

    return obj;
}
module.exports=cell;