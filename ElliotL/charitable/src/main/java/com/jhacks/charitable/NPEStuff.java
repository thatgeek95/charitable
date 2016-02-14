package com.jhacks.charitable;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class NPEStuff {

	public static ArrayList<Charity> getChInfo(String regState, String numNtee) throws Exception {
		
		ArrayList<Charity> out = new ArrayList<Charity>();

		String jsonConstruct = "https://projects.propublica.org/nonprofits/api/v1/search.json?ntee%5Bid%5D=" + numNtee + "&page=0&state%5Bid%5D=" + regState;
		String json = JSONStuff.readUrl(jsonConstruct);

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(json);
		JSONObject jb = (JSONObject) obj;

		//now read
		Long numpgs = (Long) jb.get("num_pages");

		for(int i = 0; i<numpgs; i++) {

			String pgJSON = "https://projects.propublica.org/nonprofits/api/v1/search.json?ntee%5Bid%5D=" + numNtee + "&page=" + i + "&state%5Bid%5D=" + regState;
			String jsonURL = JSONStuff.readUrl(pgJSON);

			JSONParser pgparser = new JSONParser();
			Object pgobj = pgparser.parse(jsonURL);
			JSONObject pgjb = (JSONObject) pgobj;
			JSONArray filings = (JSONArray) pgjb.get("filings");
			
			for(int j = 0; j<filings.size(); j++) {
				JSONObject org = (JSONObject) filings.get(j);
				Long rev = (Long) org.get("totrevenue");
				double revI = Math.toIntExact(rev);
				Long exp = (Long) org.get("totfuncexpns");
				double expI = Math.toIntExact(exp);
				Long assets = (Long) org.get("totassetsend");
				double ovh = 0;
				//revenue check
				//negative ovh means they spent more than they took in
				if(rev>0) {
					ovh = ((revI-expI)/revI)*100.0;
				}
				else
					continue;
				
				JSONObject organization = (JSONObject) org.get("organization");
				String name = (String) organization.get("name");
				String ZIP = (String) organization.get("zipcode");
				String ntc = (String) organization.get("ntee_code");
				
				out.add(new Charity(name, ZIP, assets.toString(), Double.toString(ovh), ntc));
			}
		}
		
		return out;
	}

}
