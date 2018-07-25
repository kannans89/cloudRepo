package com.techlabs.employee;

public class TotalEmpByDesignation {
	LoadData loadObj=new LoadData();
	String data[][]=loadObj.data;
	public void count() {
		String desig;
		String m=data[0][2];
		String c=data[1][2];
		String a=data[2][2];
		String s=data[4][2];
		int manager = 4,clerk=6,analyst=5,salesman=7;
		for(int i=0;i<data.length;i++){
			
			desig=data[i][2];
			if(desig==m){
				manager++;
				
			}
			else if(desig==c){
				clerk++;
			}
			else if(desig==a){
				analyst++;
			}
			else if(desig==s){
				salesman++;
			}
			
		}
		System.out.println("no of employees in with designation manager are : "+manager);
		System.out.println("no of employees in with designation clerk are : "+clerk);
		System.out.println("no of employees in with designation analyst are : "+analyst);
		System.out.println("no of employees in with designation salesman are : "+salesman);
		
	}

}
