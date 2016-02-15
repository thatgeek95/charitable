package com.jhacks.charitable;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class NPEStuff {

	public static ArrayList<Charity> getChInfo(String regState, String numNtee, String userZIP) throws Exception {
		
		ArrayList<Charity> out = new ArrayList<Charity>();

		String jsonConstruct = "https://projects.propublica.org/nonprofits/api/v1/search.json?ntee%5Bid%5D=" + numNtee + "&page=0&state%5Bid%5D=" + regState;
		String json = JSONStuff.readUrl(jsonConstruct);

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(json);
		JSONObject jb = (JSONObject) obj;

		//now read
		Long numpgs = (Long) jb.get("num_pages");
		//CHANGE BACK TO NUMPGS
		for(int i = 0; i<3; i++) {
			double numpgsI = numpgs.intValue();
			double iD = i;
			System.out.println("On page: " + i + " of " + numpgs + ". " + (iD/numpgsI)*100 + "%");
			String pgJSON = "https://projects.propublica.org/nonprofits/api/v1/search.json?ntee%5Bid%5D=" + numNtee + "&page=" + i + "&state%5Bid%5D=" + regState;
			String jsonURL = JSONStuff.readUrl(pgJSON);

			JSONParser pgparser = new JSONParser();
			Object pgobj = pgparser.parse(jsonURL);
			JSONObject pgjb = (JSONObject) pgobj;
			JSONArray filings = (JSONArray) pgjb.get("filings");
			
			for(int j = 0; j<filings.size(); j++) {
				JSONObject org = (JSONObject) filings.get(j);
				Long rev = (long) 0;
				Long funExp = (long) 0;
				Long assets = (long) 0;
				Long giftsReceived = (long) 0;
				Long grantsPaid = (long) 0;
				Long opExp = (long) 0;
				if(org.get("totrevenue")!=null)
					rev = (Long) org.get("totrevenue");
				if(org.get("totfuncexpns")!=null)
					funExp = (Long) org.get("totfuncexpns");
				if(org.get("totassetsend")!=null)
					assets = (Long) org.get("totassetsend");
				if(org.get("grscontrgifts")!=null)
					giftsReceived = (Long) org.get("grscontrgifts");
				if(org.get("contrpdpbks")!=null)
					grantsPaid = (Long) org.get("contrpdpbks");
				if(org.get("totopradmnexpnsa")!=null)
					opExp = (Long) org.get("totopradmnexpnsa");
				
				JSONObject organization = (JSONObject) org.get("organization");
				String name = (String) organization.get("name");
				String ZIP = (String) organization.get("zipcode");
				String ntc = (String) organization.get("ntee_code");
				
				out.add(new Charity(name, ZIP, assets.toString(), ntc, rev.toString(), funExp.toString(), giftsReceived.toString(), grantsPaid.toString(), opExp.toString()));
				//out.get(out.size()-1).setDistance(userZIP);
			}
		}
		
		return out;
	}

}
