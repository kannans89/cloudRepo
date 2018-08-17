package tictactoe.test;

import java.lang.reflect.Method;

import com.techlabs.tictactoe.Player;

public class PlayerTest {

	public static void main(String[] args) throws Exception{
		PlayerTest pt=new PlayerTest();
	    Method methods[] = pt.getClass().getDeclaredMethods();
	    for (Method meth : methods){
	      if(meth.isAnnotationPresent(Test.class)){
	    	  
	    	  if((boolean) meth.invoke(new PlayerTest(), null))
	    		  System.out.println("PASS");
	    	  else
	    		  System.out.println("FAIL");
	      	}
	    }
	}
	@Test
	public boolean playerNameShouldBeSet(){
		Player p=new Player(1,"deval");
		
		if(p.name!=""){
			return true;
		}
		else{
			return false;
		}
	}
}
