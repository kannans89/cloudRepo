package com.techlabs.employee;
import java.util.*;

public class Parser {
	public Set<Employee> parseToEmp() throws Exception{
		int id;String name;String desig;int mgrId;String date;int sal;String commission;int dept;
		
		FileLoader f=new FileLoader();
		String[] data;
		data=f.load();
		String n=data[57];
		Set<Employee> sEmp = new HashSet<Employee>();
		for(int i=0;i<data.length;i++){
			if(data[i]=="\n"){
				id=Integer.parseInt(data[i-8]);
				name=data[i-7];
				desig=data[i-6];
				if(data[i-5].equals(n))
					mgrId=0;
				else{

					mgrId=Integer.parseInt(data[i-5]);
				}
				date=data[i-4];
				sal=Integer.parseInt(data[i-3]);
				commission=data[i-2];
				dept=Integer.parseInt(data[i-1]);
				Employee e=new Employee(id, name, desig, mgrId, date, sal, commission, dept);
//				System.out.println(e.getId());
				sEmp.add(e);
			}
		}
		int count=0;
		int dupli;
		for (Employee i: sEmp)
		   {
				count++;
		       dupli=i.id;
		       for(int j=count;j<sEmp.size();j++){
//		    	   if()
		       }
		   }
//		for(int i=0;i<sEmp.size();i++){
//			
//		}
		return sEmp;
	}

}
