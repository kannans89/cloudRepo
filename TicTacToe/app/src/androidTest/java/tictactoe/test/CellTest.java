package tictactoe.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.techlabs.tictactoe.Cell;
import com.techlabs.tictactoe.Mark;



public class CellTest {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		CellTest f=new CellTest();
	    Method methods[] = f.getClass().getDeclaredMethods();
	    for (Method meth : methods){
	      if(meth.isAnnotationPresent(Test.class)){
	    	  
	    	  if((boolean) meth.invoke(new CellTest(), null))
	    		  System.out.println("PASS");
	    	  else
	    		  System.out.println("FAIL");
	      	}
	    }
	}
	@Test
	public boolean cellShouldBeSet(){
		Cell c=new Cell();
		c.setValue(Mark.NOUGHT);
		if(c.getValue().equals(Mark.CROSS)||c.getValue().equals(Mark.NOUGHT)){
			return true;
		}
		else{
			return false;
		}
	}

}
