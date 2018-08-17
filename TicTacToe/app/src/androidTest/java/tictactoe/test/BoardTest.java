package tictactoe.test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.techlabs.tictactoe.Board;
import com.techlabs.tictactoe.Mark;

public class BoardTest {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		BoardTest bt=new BoardTest();
	    Method methods[] = bt.getClass().getDeclaredMethods();
	    for (Method meth : methods){
	      if(meth.isAnnotationPresent(Test.class)){
	    	  
	    	  if((boolean) meth.invoke(new BoardTest(), null))
	    		  System.out.println("PASS");
	    	  else
	    		  System.out.println("FAIL");
	      	}
	    }
		}
		@Test
		public boolean cellsShouldBeSet(){
			Board b=new Board();
			b.cellSet(3, Mark.NOUGHT);
			if(b.cells[3].getValue()==Mark.CROSS||b.cells[3].getValue()==Mark.NOUGHT){
				return true;
			}
			else{
				return false;
			}
			
		}
}
