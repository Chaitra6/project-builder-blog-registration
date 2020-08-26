package businesslogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class RegistrationValidation{
	
	public boolean checkUserDetails(String email, String password, String confirmPassword) {
		
		boolean email1 = validEmail(email);
		boolean password1 = validPassword(password, confirmPassword);
		
		return (email1 && password1);
//		if(email1 && password1) {
//			return true;
//		}
			
	}
	
	private boolean validPassword(String password, String confirmPassword) {
        final String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$";        
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		
		if(password == "") {
			return false;
		}
		
		if(matcher.matches()) {
			if(confirmPassword == password) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
		
	}
	
	private boolean validEmail(String email) {
		
		final String regex = "/^[a-zA-Z0-9._]+@[a-zA-Z0-9.]+\\.[a-zA-Z]{2,4}$/";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		
		if(email == "") {
			return false;
		}
		
		if(matcher.matches()) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
}
