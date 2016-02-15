package com.jhacks.charitable;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        //MapsStuff.TwoPointsDistance("07666", "08901");
    	ArrayList<Charity> NYChars = NPEStuff.getChInfo("NY", "5", "08901");
    	
    	/*for(int i = 0; i<NYChars.size(); i++) {
    		System.out.println(i + " " + NYChars.get(i).toString());
    	}*/
    	
    	System.out.println(NYChars.size());
    	
    	NYChars.get(9).setRank(.25);
    	NYChars.get(8).setRank(.35);
    	NYChars.get(7).setRank(.45);
    	NYChars.get(6).setRank(.55);
    	NYChars.get(5).setRank(.65);
    	NYChars.get(4).setRank(.75);
    	NYChars.get(3).setRank(.85);
    	NYChars.get(2).setRank(.15);
    	NYChars.get(1).setRank(.05);
    	NYChars.get(0).setRank(.005);
    	
    	for(int i = 0; i<10; i++) {
		System.out.println(i + " " + NYChars.get(i).toString());
	}
    	System.out.println();
    	
    	ArrayList<Charity> sorted = AlgoAndSort.sortAL(NYChars);
    	
    	for(int i = 0; i<sorted.size(); i++) {
    		System.out.println(i + " " + sorted.get(i).toString());
    	}
    }
}
