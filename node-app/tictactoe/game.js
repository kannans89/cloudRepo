
function game(){
    var obj={};

    obj.players=[];
	obj.analyzer;
	obj.board;
	var currentPlayer=0;
	obj.createGame=function(players,analyzer,board ){
		obj.analyzer=analyzer;
		obj.board=board;
		obj.players=players;
	}
	
	obj.play=function(cellno){
			currentPlayer++;
			if(currentPlayer%2==0){
				obj.board.cellSet(cellno,obj.players[1].mark);
			}
			else{
				obj.board.cellSet(cellno,obj.players[0].mark);
			}
	}

    return obj;
}
module.exports=game;