package com.jhacks.charitable;

import java.util.ArrayList;

public class AlgoAndSort {
	
	public void giveRank(UserPrefs pref, Charity charity){
		// rank for distance
		int distanceMultiplier = pref.getLocPrefVal();
		double distanceVal;
		double distance = 12.3;   //TODO charity.getDistance();
		
		distanceVal = (1-Math.pow(distance/100,2))*distanceMultiplier;
		
		// rank for grants given
		int grants;
		int grantMultiplier = 5;
		double moneyToDollar;
		grants=Integer.parseInt(charity.getGrantPaid());
		int totalCosts= Integer.parseInt(charity.getFuncExp());
		moneyToDollar= grantMultiplier*grants/totalCosts;
		
		
		// rank for size
		int sizeMultiplier = 10;
		String userInputSize;
		double asset;
		double sizeVal;
		userInputSize = pref.getSizePref();
		int inputSize;
		
		if (userInputSize.compareTo("SMALL")==0){
			inputSize = 250000;
		}
		else if (userInputSize.compareTo("MEDIUM")==0){
			inputSize = 1750000;
		}
		else if (userInputSize.compareTo("LARGE")==0){
			inputSize = 4000000;
		}
		else if (userInputSize.compareTo("VERY LARGE")==0){
			inputSize = 6000000;
		}
		else{ 
			inputSize = 5000000;
		}
		
		asset=Integer.parseInt(charity.getAssets());
		sizeVal = Math.exp(Math.pow(Math.log10(Math.abs(asset-inputSize+.01)),2)/25)*sizeMultiplier;
	
		
		// rank for donation per year
		double donationRelevance;
		double donationVal;
		double scaledDonation;
		int donation;
		int donationMultiplier = 3;
		
		
		donation = Integer.parseInt(charity.getGiftsRec());
		if (donation<=100000){
		scaledDonation = Math.sqrt(donation)/1000;
		}
		else {
			scaledDonation=1;
		}
		
		asset=Integer.parseInt(charity.getAssets());
		if (asset<=.0001){
			asset=.0001;
		}
		
		donationRelevance=Math.log(4*(10^9)/asset)/22.109560198066301*donationMultiplier;
		donationVal = scaledDonation*donationRelevance;
		
		
		//Assigning Rank
		double hitCount;
		double totalCount;
		double rank;
		
		hitCount = distanceVal + moneyToDollar + sizeVal + donationVal;
		totalCount = distanceMultiplier + grantMultiplier + sizeMultiplier + donationMultiplier;
		
		rank = hitCount/totalCount;
		
		charity.setRank(rank);
		}
	
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
