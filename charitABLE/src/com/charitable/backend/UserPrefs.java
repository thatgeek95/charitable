package com.charitable.backend;

public class UserPrefs {

	private String sizePref; //SMALL,MED,etc
	private int sizePrefVal;
	private String locPref; //ZIP
	private int locPrefVal;
	private int type; //using API NTEE 1-10
	private String state_id;
	
	
	public UserPrefs() {
		
	}
	
	public void setSize(String sP, int sPV) {
		sizePref = sP;
		sizePrefVal = sPV;
	}
	
	public void setLoc(String lP, int lPV, String state) {
		locPref = lP;
		locPrefVal = lPV;
		state_id = state;
	}
	
	public void setType(int t) {
		type = t;
	}
	
	public String getState() {
		return state_id;
	}
	
	public String getSizePref() {
		return sizePref;
	}
	
	public int getSizePrefVal() {
		return sizePrefVal;
	}
	
	public String getLocPref() {
		return locPref;
	}
	
	public int getLocPrefVal() {
		return locPrefVal;
	}
	
	public int getType() {
		return type;
	}
	
}
