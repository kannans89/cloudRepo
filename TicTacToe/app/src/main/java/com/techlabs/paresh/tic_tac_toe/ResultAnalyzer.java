package com.techlabs.paresh.tic_tac_toe;

public class ResultAnalyzer {
	Board board;
	Mark n=Mark.EMPTY;
	
	public State result=State.INPROGRESS;
	int win;
	public ResultAnalyzer(Board b) {
		board=b;
	}
	public State getResult(){
		return result;
	}
	public int getWinner(){
		return win;
	}
	public void checkResult(){
		if(board.cells[0].getValue()!=n&&board.cells[1].getValue()!=n&&board.cells[2].getValue()!=n&&board.cells[3].getValue()!=n&&board.cells[4].getValue()!=n&&board.cells[5].getValue()!=n&&board.cells[6].getValue()!=n&&board.cells[7].getValue()!=n&&board.cells[8].getValue()!=n)
		{
			result=State.DRAW;
		}
		verticalCheck();
		horizontalCheck();
		diagonalCheck();
		 
		
		
	}
	private void diagonalCheck() {
		if(board.cells[0].getValue().equals(Mark.CROSS)&&board.cells[4].getValue().equals(Mark.CROSS)&&board.cells[8].getValue().equals(Mark.CROSS)){
			result=State.WIN;win=1;
		}
		else if(board.cells[2].getValue().equals(Mark.CROSS)&&board.cells[4].getValue().equals(Mark.CROSS)&&board.cells[6].getValue().equals(Mark.CROSS)){
			result=State.WIN;win=1;
		}
		
		if(board.cells[0].getValue().equals(Mark.NOUGHT)&&board.cells[4].getValue().equals(Mark.NOUGHT)&&board.cells[8].getValue().equals(Mark.NOUGHT)){
			result=State.WIN;win=2;
		}
		else if(board.cells[2].getValue().equals(Mark.NOUGHT)&&board.cells[4].getValue().equals(Mark.NOUGHT)&&board.cells[6].getValue().equals(Mark.NOUGHT)){
			result=State.WIN;win=2;
		}
	}
	private void horizontalCheck(){
		if(board.cells[0].getValue().equals(Mark.CROSS)&&board.cells[1].getValue().equals(Mark.CROSS)&&board.cells[2].getValue().equals(Mark.CROSS)){
			result=State.WIN;win=1;
		}
		else if(board.cells[3].getValue().equals(Mark.CROSS)&&board.cells[4].getValue().equals(Mark.CROSS)&&board.cells[5].getValue().equals(Mark.CROSS)){
			result=State.WIN;win=1;
		}
		else if(board.cells[6].getValue().equals(Mark.CROSS)&&board.cells[7].getValue().equals(Mark.CROSS)&&board.cells[8].getValue().equals(Mark.CROSS)){
			result=State.WIN;win=1;
		}
		
		if(board.cells[0].getValue().equals(Mark.NOUGHT)&&board.cells[1].getValue().equals(Mark.NOUGHT)&&board.cells[2].getValue().equals(Mark.NOUGHT)){
			result=State.WIN;win=2;
		}
		else if(board.cells[3].getValue().equals(Mark.NOUGHT)&&board.cells[4].getValue().equals(Mark.NOUGHT)&&board.cells[5].getValue().equals(Mark.NOUGHT)){
			result=State.WIN;win=2;
		}
		else if(board.cells[6].getValue().equals(Mark.NOUGHT)&&board.cells[7].getValue().equals(Mark.NOUGHT)&&board.cells[8].getValue().equals(Mark.NOUGHT)){
			result=State.WIN;win=2;
		}
	}
	private void verticalCheck(){
		if(board.cells[0].getValue().equals(Mark.CROSS)&&board.cells[3].getValue().equals(Mark.CROSS)&&board.cells[6].getValue().equals(Mark.CROSS)){
			result=State.WIN;
			win=1;
		}
		else if(board.cells[1].getValue().equals(Mark.CROSS)&&board.cells[4].getValue().equals(Mark.CROSS)&&board.cells[7].getValue().equals(Mark.CROSS)){
			result=State.WIN;
			win=1;
		}
		else if(board.cells[2].getValue().equals(Mark.CROSS)&&board.cells[5].getValue().equals(Mark.CROSS)&&board.cells[8].getValue().equals(Mark.CROSS)){
			result=State.WIN;
			win=1;
		}
		
		if(board.cells[0].getValue().equals(Mark.NOUGHT)&&board.cells[3].getValue().equals(Mark.NOUGHT)&&board.cells[6].getValue().equals(Mark.NOUGHT)){
			result=State.WIN;
			win=2;
		}
		else if(board.cells[1].getValue().equals(Mark.NOUGHT)&&board.cells[4].getValue().equals(Mark.NOUGHT)&&board.cells[7].getValue().equals(Mark.NOUGHT)){
			result=State.WIN;
			win=2;
		}
		else if(board.cells[2].getValue().equals(Mark.NOUGHT)&&board.cells[5].getValue().equals(Mark.NOUGHT)&&board.cells[8].getValue().equals(Mark.NOUGHT)){
			result=State.WIN;
			win=2;
		}
	}

}
