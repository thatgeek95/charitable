package com.charitable.frontend;

public class CharityType {
	
	private int index;
	private String type;
	
	public CharityType CharityType(int num) {
		this.setType(num);
		return this;
	}
	
	public void setType(int num){
		if(num >= 1 && num <= 7) {
			index = num;
			if(num == 1)
				type = "Arts, Culture, and Humanities";
			if(num == 2)
				type = "Education";
			if(num == 3)
				type = "Environment and Animals";
			if(num == 4)
				type = "Health";
			if(num == 5)
				type = "Human Services";
			if(num == 6)
				type = "International, Foreign Affairs";
			if(num == 7)
				type = "Public, Societal Benefit";
		}
		
		return;
	}
	
	public String getType() {
		return type;
	}
	
	public String toString() {
		return this.type;
	}

}
