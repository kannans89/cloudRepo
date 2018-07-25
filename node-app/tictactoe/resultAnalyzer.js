var player=require('./player');
var boardObj=require('./board');
var resultAnalyzerObj=require('./resultAnalyzer');
function resultAnalyzer(){
    var obj={};

    obj.board;
	var n="";
	
	var result="INPROGRESS";
	var win;
	obj.createResultAnalyzer=function(b) {
		obj.board=b;
	}
	obj.getResult=function(){
		return result;
	}
	obj.getWinner=function(){
		return win;
	}
	obj.checkResult=function(){
		if(obj.board.cells[0].getValue()!=n&&obj.board.cells[1].getValue()!=n&&obj.board.cells[2].getValue()!=n&&obj.board.cells[3].getValue()!=n&&obj.board.cells[4].getValue()!=n&&obj.board.cells[5].getValue()!=n&&obj.board.cells[6].getValue()!=n&&obj.board.cells[7].getValue()!=n&&obj.board.cells[8].getValue()!=n)
		{
			result="DRAW";
		}
		verticalCheck();
		horizontalCheck();
		diagonalCheck();		
	}
	function diagonalCheck() {
		if(obj.board.cells[0].getValue().equals(Mark.CROSS)&&obj.board.cells[4].getValue().equals(Mark.CROSS)&&obj.board.cells[8].getValue().equals(Mark.CROSS)){
			result="WIN";win=1;
		}
		else if(obj.board.cells[2].getValue().equals(Mark.CROSS)&&obj.board.cells[4].getValue().equals(Mark.CROSS)&&obj.board.cells[6].getValue().equals(Mark.CROSS)){
			result="WIN";win=1;
		}
		
		if(obj.board.cells[0].getValue().equals(Mark.NOUGHT)&&obj.board.cells[4].getValue().equals(Mark.NOUGHT)&&obj.board.cells[8].getValue().equals(Mark.NOUGHT)){
			result="WIN";win=2;
		}
		else if(obj.board.cells[2].getValue().equals(Mark.NOUGHT)&&obj.board.cells[4].getValue().equals(Mark.NOUGHT)&&obj.board.cells[6].getValue().equals(Mark.NOUGHT)){
			result="WIN";win=2;
		}
	}
	function horizontalCheck(){
		if(obj.board.cells[0].getValue().equals(Mark.CROSS)&&obj.board.cells[1].getValue().equals(Mark.CROSS)&&obj.board.cells[2].getValue().equals(Mark.CROSS)){
			result="WIN";win=1;
		}
		else if(obj.board.cells[3].getValue().equals(Mark.CROSS)&&obj.board.cells[4].getValue().equals(Mark.CROSS)&&obj.board.cells[5].getValue().equals(Mark.CROSS)){
			result="WIN";win=1;
		}
		else if(obj.board.cells[6].getValue().equals(Mark.CROSS)&&obj.board.cells[7].getValue().equals(Mark.CROSS)&&obj.board.cells[8].getValue().equals(Mark.CROSS)){
			result="WIN";win=1;
		}
		
		if(obj.board.cells[0].getValue().equals(Mark.NOUGHT)&&obj.board.cells[1].getValue().equals(Mark.NOUGHT)&&obj.board.cells[2].getValue().equals(Mark.NOUGHT)){
			result="WIN";win=2;
		}
		else if(obj.board.cells[3].getValue().equals(Mark.NOUGHT)&&obj.board.cells[4].getValue().equals(Mark.NOUGHT)&&obj.board.cells[5].getValue().equals(Mark.NOUGHT)){
			result="WIN";win=2;
		}
		else if(obj.board.cells[6].getValue().equals(Mark.NOUGHT)&&obj.board.cells[7].getValue().equals(Mark.NOUGHT)&&obj.board.cells[8].getValue().equals(Mark.NOUGHT)){
			result="WIN";win=2;
		}
	}
	function verticalCheck(){
		if(obj.board.cells[0].getValue().equals(Mark.CROSS)&&obj.board.cells[3].getValue().equals(Mark.CROSS)&&obj.board.cells[6].getValue().equals(Mark.CROSS)){
			result="WIN";
			win=1;
		}
		else if(obj.board.cells[1].getValue().equals(Mark.CROSS)&&obj.board.cells[4].getValue().equals(Mark.CROSS)&&obj.board.cells[7].getValue().equals(Mark.CROSS)){
			result="WIN";
			win=1;
		}
		else if(obj.board.cells[2].getValue().equals(Mark.CROSS)&&obj.board.cells[5].getValue().equals(Mark.CROSS)&&obj.board.cells[8].getValue().equals(Mark.CROSS)){
			result="WIN";
			win=1;
		}
		
		if(obj.board.cells[0].getValue().equals(Mark.NOUGHT)&&obj.board.cells[3].getValue().equals(Mark.NOUGHT)&&obj.board.cells[6].getValue().equals(Mark.NOUGHT)){
			result="WIN";
			win=2;
		}
		else if(obj.board.cells[1].getValue().equals(Mark.NOUGHT)&&obj.board.cells[4].getValue().equals(Mark.NOUGHT)&&obj.board.cells[7].getValue().equals(Mark.NOUGHT)){
			result="WIN";
			win=2;
		}
		else if(obj.board.cells[2].getValue().equals(Mark.NOUGHT)&&obj.board.cells[5].getValue().equals(Mark.NOUGHT)&&obj.board.cells[8].getValue().equals(Mark.NOUGHT)){
			result="WIN";
			win=2;
		}
	}

    return obj;
}
module.exports=resultAnalyzer;