package genericUtility;

import java.util.Random;


public class JavaLibrary {
	
	/**
	 * This method will return random number(1000)
	 * @author sachin
	 * @return
	 */
public int randomNum() {
	Random ran = new Random();
	int randomNumber = ran.nextInt(1000);
	return randomNumber;
}
}
