function resultAnalyzer(){
    var obj={};

    obj.board;
	var n="";
	
	obj.result="INPROGRESS";
	var win;
	obj.createResultAnalyzer=function(b) {
		obj.board=b;
	}
	obj.getResult=function(){
		return obj.result;
	}
	obj.getWinner=function(){
		return win;
	}
	obj.checkResult=function(){
		console.log(obj.board.cells[0].getValue);
		
		if(obj.board.cells[0].getValue()!=n&&obj.board.cells[1].getValue()!=n&&obj.board.cells[2].getValue()!=n&&obj.board.cells[3].getValue()!=n&&obj.board.cells[4].getValue()!=n&&obj.board.cells[5].getValue()!=n&&obj.board.cells[6].getValue()!=n&&obj.board.cells[7].getValue()!=n&&obj.board.cells[8].getValue()!=n)
		{
			obj.result="DRAW";
		}
		verticalCheck();
		horizontalCheck();
		diagonalCheck();		
	}
	function diagonalCheck() {
		if(obj.board.cells[0].getValue()=="X"&&obj.board.cells[4].getValue()=="X"&&obj.board.cells[8].getValue()=="X"){
			obj.result="WIN";win=1;
		}
		else if(obj.board.cells[2].getValue()=="X"&&obj.board.cells[4].getValue()=="X"&&obj.board.cells[6].getValue()=="X"){
			obj.result="WIN";win=1;
		}
		
		if(obj.board.cells[0].getValue()=="0"&&obj.board.cells[4].getValue()=="0"&&obj.board.cells[8].getValue()=="0"){
			obj.result="WIN";win=2;
		}
		else if(obj.board.cells[2].getValue()=="0"&&obj.board.cells[4].getValue()=="0"&&obj.board.cells[6].getValue()=="0"){
			obj.result="WIN";win=2;
		}
	}
	function horizontalCheck(){
		if(obj.board.cells[0].getValue()=="X"&&obj.board.cells[1].getValue()=="X"&&obj.board.cells[2].getValue()=="X"){
			obj.result="WIN";win=1;
		}
		else if(obj.board.cells[3].getValue()=="X"&&obj.board.cells[4].getValue()=="X"&&obj.board.cells[5].getValue()=="X"){
			obj.result="WIN";win=1;
		}
		else if(obj.board.cells[6].getValue()=="X"&&obj.board.cells[7].getValue()=="X"&&obj.board.cells[8].getValue()=="X"){
			obj.result="WIN";win=1;
		}
		
		if(obj.board.cells[0].getValue()=="0"&&obj.board.cells[1].getValue()=="0"&&obj.board.cells[2].getValue()=="0"){
			obj.result="WIN";win=2;
		}
		else if(obj.board.cells[3].getValue()=="0"&&obj.board.cells[4].getValue()=="0"&&obj.board.cells[5].getValue()=="0"){
			obj.result="WIN";win=2;
		}
		else if(obj.board.cells[6].getValue()=="0"&&obj.board.cells[7].getValue()=="0"&&obj.board.cells[8].getValue()=="0"){
			obj.result="WIN";win=2;
		}
	}
	function verticalCheck(){
		if(obj.board.cells[0].getValue()=="X"&&obj.board.cells[3].getValue()=="X"&&obj.board.cells[6].getValue()=="X"){
			obj.result="WIN";
			win=1;
		}
		else if(obj.board.cells[1].getValue()=="X"&&obj.board.cells[4].getValue()=="X"&&obj.board.cells[7].getValue()=="X"){
			obj.result="WIN";
			win=1;
		}
		else if(obj.board.cells[2].getValue()=="X"&&obj.board.cells[5].getValue()=="X"&&obj.board.cells[8].getValue()=="X"){
			obj.result="WIN";
			win=1;
		}
		
		if(obj.board.cells[0].getValue()=="0"&&obj.board.cells[3].getValue()=="0"&&obj.board.cells[6].getValue()=="0"){
			obj.result="WIN";
			win=2;
		}
		else if(obj.board.cells[1].getValue()=="0"&&obj.board.cells[4].getValue()=="0"&&obj.board.cells[7].getValue()=="0"){
			obj.result="WIN";
			win=2;
		}
		else if(obj.board.cells[2].getValue()=="0"&&obj.board.cells[5].getValue()=="0"&&obj.board.cells[8].getValue()=="0"){
			obj.result="WIN";
			win=2;
		}
	}

    return obj;
}
module.exports=resultAnalyzer;