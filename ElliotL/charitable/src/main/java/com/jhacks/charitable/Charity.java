package com.jhacks.charitable;

public class Charity {
	String name;
	String zip;
	String totalAssets;
	String overhead;
	String ntee;

	public Charity(String n, String z, String assets, String over, String nt) {
		name = n;
		zip = z;
		totalAssets = assets;
		overhead = over;
		ntee = nt;
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
	public String getOverhead() {
		return overhead;
	}
	public String getNtee() {
		return ntee;
	}
	
	public String toString() {
		String out = name + " " + zip + " " + totalAssets + " " + overhead + " " + ntee;
		return out;
	}
}
