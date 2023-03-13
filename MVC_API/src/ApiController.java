import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

// The Controller coordinates interactions
// between the View and Model

public class ApiController {
	
	private ApiView theView;
	private ApiModel theModel;
	
	public ApiController(ApiView theView, ApiModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
		
		
		// Tell the View that when ever the „generate” button
		// is clicked to execute the actionPerformed method
		// in the CalculateListener inner class
		
		this.theView.addCalculateListener(new CalculateListener());
	}
	
	class CalculateListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			// Surround interactions with the view with
			// a try block in case API wasn't
			// properly entered
			
			try{
				
				String symbol = theView.getSymbol();
				
				theModel.addSymbol(symbol);
				
				theView.setCalcSolution(theModel.getCalculationValue());
			
			}

			catch(NumberFormatException ex){
				
				System.out.println(ex);
				
				theView.displayErrorMessage("You Need to Enter one symbol");
				
			}
			
		}
		
	}
	
}