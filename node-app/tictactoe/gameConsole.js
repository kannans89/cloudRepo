var readlineSync = require('readline-sync');
var playerObj=require('./player');
var boardObj=require('./board');
var resultAnalyzerObj=require('./resultAnalyzer');
var gameObj=require('./game');
function gameConsole(){
    var obj={};

    obj.run=function(){
		var count=0;
		var no;
		var p1name,p2name;
		p1name = readlineSync.question("P1 enter your name");
		p2name = readlineSync.question("P2 enter your name");
		
		var board=boardObj();
		board.createBoard();
		var player=[];
		player[0]=playerObj();
		player[1]=playerObj();
		player[0].createPlayer(1,p1name);
		player[1].createPlayer(2,p2name);
		var analyzer=resultAnalyzerObj();
		analyzer.createResultAnalyzer(board);
		var game=gameObj();
		game.createGame(player,analyzer,board);
		while(analyzer.result=="INPROGRESS"){
            no = readlineSync.question((player[(count%2)].name)+": enter your choice");
			count++;
			if(no>9){
				count--;
			    console.log("Enter a valid no");
			}
			else if(board.cells[no].getValue()=="X"||board.cells[no].getValue()=="0"){
				count--;
				game.play(no);
			}
			else{
				game.play(no);
			}
			obj.print(board);
			analyzer.checkResult();
			var res=analyzer.getResult();
			if(res=="INPROGRESS"){
				console.log("inprogress");
			}
			else if(res=="WIN"){
				console.log(player[analyzer.getWinner()-1].name+" wins");
			}
			else if(res=="DRAW"){
				console.log("draw");
			}
			console.log();
		}
	}
	obj.print=function(board){
		for(var i=0;i<9;i++){
			var cellValue=board.cells[i].getValue();
			var printValue=" ";
			if(cellValue=="X"){
				printValue="X";
			}
			else if(cellValue=="0"){
				printValue="0";
			}
			process.stdout.write("|"+printValue);
			if(i==2||i==5||i==8){
				process.stdout.write("|");
				console.log();
			}
		}
	}
    return obj;
}
module.exports=gameConsole;