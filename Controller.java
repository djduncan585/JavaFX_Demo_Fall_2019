/*
 * Dave Duncan
 * CSC205 Fundamentals of Data Structures
 * Dr. Sandeep Mitra
 * Project 2
 * 12 November 2019
 */

package project2;

import java.security.SecureRandom;
import java.util.*;

/**Controller class for Project 2, which serves as the channel of communication between the Model
 * and the View.*/
public class Controller {
	//variables
	protected static ArrayList<String> houseListings = new ArrayList<String>(0);
	protected static SecureRandom sr = new SecureRandom();  //for generating random number later on
	
	/**
	 * Takes input from the TextFields in the View and uses it to search for a house.
	 * An array of Strings containing text results of the house search is gathered, and
	 * the user is returned a single random entry in the View.chosenHome TextArea. If zero or
	 * more items are returned in the array, the View.findAnotherHouse button is activated,
	 * and a message stating that no houses matching the search Criteria were found.*/
	public static void findMyDreamHouse() {
		Integer minPriceInt;
		Integer maxPriceInt;
		Integer minAreaInt;
		Integer maxAreaInt;
		Integer minBedInt;
		Integer maxBedInt;
		
		try {
			minPriceInt = Integer.parseInt(View.minimumPrice.getText());
		}
		catch(NumberFormatException e) {
			minPriceInt = null;
		}
		
		try {
			maxPriceInt = Integer.parseInt(View.maximumPrice.getText());
		}
		catch(NumberFormatException e) {
			maxPriceInt = null;
		}
		
		try {
			minAreaInt = Integer.parseInt(View.minimumArea.getText());
		}
		catch(NumberFormatException e) {
			minAreaInt = null;
		}
		
		try {
			maxAreaInt = Integer.parseInt(View.maximumArea.getText());
		}
		catch(NumberFormatException e) {
			maxAreaInt = null;
		}
		
		try {
			minBedInt = Integer.parseInt(View.minimumBeds.getText());
		}
		catch(NumberFormatException e) {
			minBedInt = null;
		}
		
		try {
			maxBedInt = Integer.parseInt(View.maximumBeds.getText());
		}
		catch(NumberFormatException e) {
			maxBedInt = null;
		}
		
		Criteria thisSearchCriteria = new Criteria(minPriceInt, maxPriceInt, minAreaInt, maxAreaInt, minBedInt, maxBedInt);
		houseListings = Model.allHouses.getHouses(thisSearchCriteria);
		if(houseListings.size() > 0) {
			View.findAnotherHouse.setDisable(false);
			int i = (int)(random() * houseListings.size());
			String singlehouse = houseListings.remove(i);
			View.chosenHome.setText(singlehouse);	
		}
		else
			View.chosenHome.setText("No houses match these criteria.");
	}
	/**Method executed when View.findAnotherHouse is pressed. It goes through the
	 * remaining listings gathered by findMyDreamHouse() and randomly picks one to
	 * display. If the list has been exhausted, a message appears saying that no
	 * more houses in the list are available, and the View.findAnotherHouse is
	 * disabled. */
	public static void notMyDreamHouse() {
		if(houseListings.size() == 0) {
			View.chosenHome.setText("No more available houses.");
			View.findAnotherHouse.setDisable(true);
		}
		else {
			int i = (int)(random() * houseListings.size());
			String singlehouse = houseListings.remove(i);
			View.chosenHome.setText(singlehouse);
		}
	}
	
	/**Clears all text fields on the Form and sets View.findAnotherHouse to disabled.*/
	public static void resetView() {
		View.minimumPrice.setText("");
		View.maximumPrice.setText("");
		View.minimumArea.setText("");
		View.maximumArea.setText("");
		View.minimumBeds.setText("");
		View.maximumBeds.setText("");
		View.chosenHome.setText("");
		View.findAnotherHouse.setDisable(true);
		houseListings = new ArrayList<String>(0);
	}
	
	
	/**Utility method that generates random doubles using Java's SecureRandom class.
	 * @return double*/
	static double random() {
		double n = (sr.nextDouble());
		return n;
		}
}
