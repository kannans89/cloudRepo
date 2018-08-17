package com.techlabs.paresh.tic_tac_toe;

public class Game {
	Player players[];
	ResultAnalyzer analyzer;
	Board board;
	int currentPlayer=0;
	public Game(Player[] players,ResultAnalyzer analyser,Board board ){
		this.analyzer=analyser;
		this.board=board;
		this.players=players;
	}
	
	public void play(int cellno){
			currentPlayer++;
			if(currentPlayer%2==0){
				board.cellSet(cellno,players[1].mark);
			}
			else{
				board.cellSet(cellno,players[0].mark);
			}
	}
}
