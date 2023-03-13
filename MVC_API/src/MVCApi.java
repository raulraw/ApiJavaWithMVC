public class MVCApi {
    
    public static void main(String[] args) {
    	
    	ApiView theView = new ApiView();
        
    	ApiModel theModel = new ApiModel();
        
        ApiController theController = new ApiController(theView,theModel);
        
        theView.setVisible(true);
        
    }
}