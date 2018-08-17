package com.techlabs.percent.calculator;


public class Main {

	public static void main(String[] args) {
		PercentCalculator pc=new PercentCalculator();
		System.out.println("1:  "+pc.xPercentOfY(10, 20));
		System.out.println("2:  "+pc.xIsWhatPercentOfY(10,0 ));
		System.out.println("3:  "+pc.percentChangeFromXtoY(0, 0));
	}

}