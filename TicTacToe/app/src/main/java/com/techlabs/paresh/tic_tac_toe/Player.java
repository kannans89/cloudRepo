package com.techlabs.paresh.tic_tac_toe;

public class Player {
	public String name;
	Mark mark;
	public Player(int player,String name){
		if(player==1){
			mark=Mark.CROSS;
		}
		else{
			mark=Mark.NOUGHT;
		}
		this.name=name;
	}

	public Mark getMark() {
		return mark;
	}

	public String getName() {
		return name;
	}
}
