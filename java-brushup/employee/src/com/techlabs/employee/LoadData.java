package com.techlabs.employee;

import java.io.BufferedReader;
import java.io.FileReader;

public class LoadData {
	public String[][] data=new String[23][8];
	public void load() throws Exception {
		BufferedReader in = new BufferedReader(new FileReader("D:/LocalGitRepo/java-brushup/dataFile.txt"));
		String line;
		String[] e = null;
		
		int count=0;
		while((line = in.readLine()) != null)
		{
			e=line.split(",");
			for(int i=0;i<e.length;i++){
				data[count][i]=e[i];
				
			}
			count++;
		}
		
		in.close();
	}
}
