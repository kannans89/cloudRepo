package com.techlabs.employee;

public class FindMaxSal{

	public void find(){
		LoadData loadingObj=new LoadData();
		int max=0,sal;
		String maxname = null;
		System.out.println(loadingObj.data[1][1]);
		for(int i=0;i<loadingObj.data.length;i++){
			sal=Integer.parseInt(loadingObj.data[i][5]);
			if(max<sal){
				max=sal;
				maxname=loadingObj.data[i][1];
			}
		}
		System.out.println("Employee with max sal is: "+maxname);
		
	}

}
