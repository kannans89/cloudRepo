package com.techlabs.employee;

public class TotalEmpInDept {
	LoadData loadObj=new LoadData();
	String data[][]=loadObj.data;
	public void calculate() {
		int d10=0,d20=0,d30=0,dept;
		for(int i=0;i<data.length;i++){
			
			dept=Integer.parseInt(data[i][7]);
			if(dept==10){
				d10++;
			}
			else if(dept==20){
				d20++;
			}
			else{
				d30++;
			}
		}
		System.out.println("no of employees in dep 10 are : "+d10);
		System.out.println("no of employees in dep 20 are : "+d20);
		System.out.println("no of employees in dep 30 are : "+d30);
		
	}

}
