package com.jhacks.charitable;

public class Charity {
	private String name;
	private String zip;
	private String totalAssets;
	private String ntee;
	private String revenue;
	private String funcExp;
	private String giftsRec;
	private String grantPaid;
	private String operExpen;

	public Charity(String n, String z, String assets, String nt, String rev, String funEx, String gifRec, String graPai, String operExp) {
		name = n;
		zip = z;
		totalAssets = assets;
		ntee = nt;
		revenue = rev;
		funcExp = funEx;
		giftsRec = gifRec;
		grantPaid = graPai;
		operExpen = operExp;
	}
	
	public String getName() {
		return name;
	}
	
	public String getZip() {
		return zip;
	}
	
	public String getAssets() {
		return totalAssets;
	}
	
	public String getNtee() {
		return ntee;
	}
	
	public String getRevenue() {
		return revenue;
	}
	
	public String getFuncExp() {
		return funcExp;
	}
	
	public String getGiftsRec() {
		return giftsRec;
	}
	
	public String getGrantPaid() {
		return grantPaid;
	}
	public String getOperExpen() {
		return operExpen;
	}
	
	public String toString() {
		String out = name + " " + zip + " " + totalAssets + " " + " " + ntee + " " + revenue + " " + funcExp  + " " + giftsRec +  " " + grantPaid +  " " + operExpen;
		return out;
	}
}
