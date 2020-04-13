package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader {
	public String fName;
	public String lName;
	public String email;
	public String pass;
	
	public void jsonReader() throws FileNotFoundException, IOException, ParseException {
		String filePath = System.getProperty("user.dir") + "/src/test/java/data/data.json";
        File srcFile = new File(filePath);

        JSONParser parser = new JSONParser();
        
        Object obj = (Object) parser.parse(new FileReader(srcFile));
        JSONObject jsonObject = (JSONObject) obj;
        fName = (String) jsonObject.get("firstname");
        lName = (String) jsonObject.get("lastname");
        email = (String) jsonObject.get("useremail");
        pass = (String) jsonObject.get("userpassword");
        
        System.out.println("First Name "+fName);
        System.out.println("Last Name "+lName);
        System.out.println("Email "+email);
        System.out.println("Password "+pass);
  
	}
}
