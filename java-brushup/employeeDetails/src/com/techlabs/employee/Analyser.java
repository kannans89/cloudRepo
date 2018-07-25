package com.techlabs.employee;


import java.util.*;

public class Analyser {
	
	public String getMaxSal() throws Exception{
		Parser p=new Parser();
		Set<Employee> sEmp=p.parseToEmp();
		int max=0;
		String maxname="";
		for( Employee i: sEmp){
			if(i.sal>max){
				max=i.sal;
				maxname=i.name;
			}
		}
		return ("Employee with max sal is : "+maxname);
	}
	public Map<Integer, Integer> getDeptWiseGroup() throws Exception{
		HashMap<Integer,Integer> dept1 = new HashMap<Integer, Integer>();
		Parser p=new Parser();
		Set<Employee> sEmp=p.parseToEmp();
		int d10=0,d20=0,d30=0;
		for(Employee i: sEmp){
			if(i.dept==10){
				d10++;
			}
			else if(i.dept==20){
				d20++;
			}
			else{
				d30++;
			}
		}
		dept1.put(10,d10);
		dept1.put(20,d20);
		dept1.put(30,d30);

		return dept1;
//		System.out.println("no of employees in dep 10 are : "+d10);
//		System.out.println("no of employees in dep 20 are : "+d20);
//		System.out.println("no of employees in dep 30 are : "+d30);
	}
	
	void getDesigWiseGroup() throws Exception{
		Parser p=new Parser();
		Set<Employee> sEmp=p.parseToEmp();
		int manager=0,salesman=0,clerk=0,analyst=0,president=0;
		for(Employee i: sEmp){
			if(i.desig.equals("'MANAGER'")){
				manager++;
			}
			else if(i.desig.equals("'SALESMAN'")){
				salesman++;
			}
			else if(i.desig.equals("'CLERK'")){
				clerk++;
			}
			else if(i.desig.equals("'ANALYST'")){
				analyst++;
			}
			else{
				president++;
			}

		}
		System.out.println("no of employees in with designation manager are : "+manager);
		System.out.println("no of employees in with designation clerk are : "+clerk);
		System.out.println("no of employees in with designation analyst are : "+analyst);
		System.out.println("no of employees in with designation salesman are : "+salesman);
	}
}
