package com.jhacks.charitable;

import java.util.ArrayList;

public class AlgoAndSort {

	public static ArrayList<Charity> sortAL(ArrayList<Charity> in) {
		ArrayList<Charity> sortMe = in;
		bubbleSort(sortMe);
		
		return sortMe;
	}
	
	public static void bubbleSort(ArrayList<Charity> array) {
		int j;
		int length=array.size();
		boolean flag =true;
		Charity temp;
		while(flag){
			flag=false;
			for(j=0;j<length-1;j++){
				if(array.get(j).getRank()<array.get(j+1).getRank()){
				 temp=array.get(j);
				 array.set(j, array.get(j+1));
				 array.set(j+1, temp);
				 flag=true;
				}
			}
		}
	}
}
