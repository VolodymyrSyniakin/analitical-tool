package com.gmail.vsyniakin;

import com.gmail.vsyniakin.mediators.MediatorLines;

public class App 
{
    public static void main( String[] args ){
    	String input = "7\r\n" + 
				"C 1.1 8.15.1 P 15.10.2012 83\r\n" + 
				"C 1 10.1 P 01.12.2012 65\r\n" + 
				"C 1.1 5.5.1 P 01.11.2012 117\r\n" + 
				"D 1.1 8 P 01.01.2012-01.12.2012\r\n" + 
				"C 3 10.2 N 02.10.2012 100\r\n" + 
				"D 1 * P 08.10.2012-20.11.2012\r\n" + 
				"D 3 10 P 01.12.2012";
    	
    	MediatorLines lines = new MediatorLines(input);
    	
    	System.out.println(lines.getResult());
    }
}
