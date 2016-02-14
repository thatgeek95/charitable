package com.jhacks.charitable;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        //MapsStuff.TwoPointsDistance("07666", "08901");
    	ArrayList<Charity> NYChars = NPEStuff.getChInfo("NY", "1");
    	
    	for(int i = 0; i<NYChars.size(); i++) {
    		System.out.println(i + " " + NYChars.get(i).toString());
    	}
    	
    	System.out.println(NYChars.size());
    }
}
