package com.techlabs.paresh.tic_tac_toe;

public class Board {
	public Cell[] cells=new Cell[9];
	public Board(){
		for(int i=0;i<9;i++){
			cells[i]=new Cell();
		}
	}
	
	public void cellSet(int i, Mark mark){
		cells[i].setValue(mark);		
	}
	
	
}
