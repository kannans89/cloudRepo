package com.techlabs.paresh.tic_tac_toe;

public class Cell {
	public Mark cellValue=Mark.EMPTY;

	public Mark getValue() {
		if(this.cellValue==null){
			return Mark.EMPTY;
		}
		return cellValue;
	}

	public void setValue(Mark mark) {
			try{
			if(cellValue.equals(Mark.EMPTY))
				cellValue=mark;
			else
				throw new Exception();
			}
			catch(Exception e){
				System.out.println("Cell already marked");
			}
	}
	
	
	
}
