import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


// The Model performs all the calculations needed
// and that is it. It doesn't know the View 
// exists

public class ApiModel {

	// Holds the value of the sum of the numbers
	// entered in the view
	
	private String calculationValue;
	
	public void addTwoNumbers(String symbol){
		
		try {
			
		URL url = new URL("https://api.binance.com/api/v3/ticker/price?symbol=");
		url = new URL(url + symbol);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        //Check if connect is made
        int responseCode = conn.getResponseCode();

        // 200 OK
        if (responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        } else {
            
           StringBuilder informationString = new StringBuilder();
           Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()) {
              informationString.append(scanner.nextLine());
            }
            //Close the scanner
            scanner.close();
            // calculationValue = new String(informationString);
             String output = new String(informationString);
             output = informationString.toString().replace("symbol", " ");
             output = output.toString().replace("\"", " ");
             output = output.toString().replace(":", " ");
             output = output.toString().replace("{", " ");
             output = output.toString().replace("}", "");
             output = output.toString().replace("price", " ");
             output = output.toString().replace(" ", "");
             output = output.toString().replace(",", ":");
             calculationValue = new String(output);
            //System.out.println(informationString);
            }
         
    } catch (Exception e) {
        e.printStackTrace();
    }
	}

	public String getCalculationValue(){
		
		return calculationValue;
		
	}
	
}