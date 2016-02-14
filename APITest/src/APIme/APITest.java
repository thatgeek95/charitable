package APIme;
import java.io.IOException;
import java.util.List;

import com.parseData.*;

public class APITest {

	public static void main(String[] args) {
		String appid = "ba1c9c8b-86d5-41ff-9fe7-3428349792be";
		String appsecret = "095797a0-8598-4a52-917d-dc19dcfd0c32";
		
		ParseData parser = new ParseData();
		String token = parser.getToken(appid, appsecret);
		System.out.println(token);
		
		if(!token.contains("900") || !token.contains("903") || !token.contains("901")){
			System.out.println("Registration accepted.");
		}else{
			System.out.println("Registration rejected, authentication failed.");
		}
		
		try{
			List<SearchCharities> data = parser.searchCharities(token, "1", "10", "SMALL", "whale", "", "US", "");
			if(data.get(0).getError().getStatus_code().equals("100")){
				System.out.println("Data received.");
				for(int i = 0; i < data.size(); i++){
					String currCharity = data.get(i).getName();
					String currCharityType = data.get(i).getDescription();
					System.out.println(currCharity);
					System.out.println(currCharityType);
				}
			}
			else {
				System.out.println(data.get(0).getError().getStatus_code());
				System.out.println("Error: data not recieved.");
			}
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
		return;
	}

}
