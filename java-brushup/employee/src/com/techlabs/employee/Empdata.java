package com.techlabs.employee;

public class Empdata {

	public static void main(String[] args) throws Exception {
			LoadData loadingObj=new LoadData();
			loadingObj.load();
			FindMaxSal findMaxObj=new FindMaxSal();
			TotalEmpInDept empInDeptObj=new TotalEmpInDept();
			TotalEmpByDesignation empByDesigObj=new TotalEmpByDesignation();
			
			System.out.println(loadingObj.data[1][5]);
			findMaxObj.find();
			empInDeptObj.calculate();
			empByDesigObj.count();
			
	}

}
