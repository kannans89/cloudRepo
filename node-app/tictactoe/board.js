var cellService=require('./cell');
// let cell=cellService();
function board(){
        var obj={};
        obj.cells=[];
        obj.createBoard=function(){
        for(var i=0;i<9;i++){
            obj.cells[i]=cellService();
        }
    }

    obj.cellSet=function(i, mark){
        obj.cells[i].setValue(mark);		
    }
    return obj;
}
module.exports=board;
