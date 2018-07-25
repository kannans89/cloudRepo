package com.techlabs.employee;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileLoader implements ILoader{
	
	public String[] load() throws Exception {
		String[] data=new String[210];
			BufferedReader in = new BufferedReader(new FileReader("D:/LocalGitRepo/java-brushup/dataFile.txt"));
			String line;
			String[] e;
			int count=0;
			while((line = in.readLine()) != null)
			{
				e=line.split(",");
				for(int i=0;i<e.length;i++){
					data[count]=e[i];
					count++;
				}
				data[count++]="\n";
				
			}
//			System.out.println(data[9]);
			in.close();
		return data;
	}
	
}
