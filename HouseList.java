/*
 * Dave Duncan
 * CSC205 Fundamentals of Data Structures
 * Dr. Sandeep Mitra
 * Project 2
 * 12 November 2019
 */

package project2;
import java.util.*; //For ArrayList and Scanner
import java.io.*;

/**
 * Contains an ArrayList of House objects. Reads the data from a file and adds them to the
 * ArrayList. Allows for searching of Houses that satisfy criteria.*/
public class HouseList {
	//Attribute
	public ArrayList<House> houseList = new ArrayList<House>(0);
	
	//Constructor
	/**
	 * Constructor for the HouseList Class. Reads data from the text file specified by the parameter into
	 * the attribute HouseList.houseList. To be acceptable, each line should contain exactly four Strings
	 * separated by spaces:
	 * the address of the house with hyphens substituted for spaces, the price of the house in US dollars,
	 * the floor space in square feet, and the number of bedrooms. Strings representing integer values are 
	 * expected for the price, floor space, and number of bedrooms.
	 * @param fileName The name of the file to be read.*/
	public HouseList(String fileName) {
		try {
			File input = new File(fileName);
			Scanner thisLine = new Scanner(input);
			while(thisLine.hasNextLine()) {
				String thisLineString = new String(thisLine.nextLine());
				ArrayList<String> thisLinesTokenList = new ArrayList<String>(0);
				Scanner thisLinesTokens = new Scanner(thisLineString);
				while(thisLinesTokens.hasNext()) {
					thisLinesTokenList.add(thisLinesTokens.next());
				}
				thisLinesTokens.close();
				if(thisLinesTokenList.size() == 4) { //Checking this line for 4 tokens
					try {
						House thisLinesHouse = new House(thisLinesTokenList.get(0), Integer.parseInt(thisLinesTokenList.get(1)), Integer.parseInt(thisLinesTokenList.get(2)), Integer.parseInt(thisLinesTokenList.get(3)));
						this.houseList.add(thisLinesHouse);
					}
					catch(NumberFormatException e) {}//Throw the line out if the second, third & fourth tokens aren't integers
				}
			}
			thisLine.close();
		}
		catch(IOException e) {
			System.out.println("File " + fileName + " cannot be read.\n");
		}
		
	}
	/**Alternative constructor that creates an empty HouseList.*/
	public HouseList() {}
	
	/**
	 * Prints the contents of HouseList.houseList that conforms to the Criteria specified in the
	 * parameter.
	 * @param c The Criteria that each House in HouseList.houseList should conform to in order
	 * to be printed.*/
	public void printHouses(Criteria c) {
		for(int i = 0; i < this.houseList.size(); i++) {
			House thisHouse = this.houseList.get(i);
			if(thisHouse.satisfies(c))
				System.out.println(thisHouse);
		}
	}
	
	 /** 
	 * Method modified for use in Project 2. Gets an ArrayList of Strings representing each house
	 * that matches the input Criteria.
	 * @param c The Criteria that each House in HouseList.houseList should conform to in order
	 * to be printed.
	 * @return String
	 */
	public ArrayList<String> getHouses(Criteria c) {
		ArrayList<String> hh = new ArrayList<String>(0);
		for(int i = 0; i < this.houseList.size(); i++) {
			House thisHouse = this.houseList.get(i);
			if(thisHouse.satisfies(c)) {
				String s = "";
				String a = thisHouse.getAddress().replace('-', ' ').concat("\n");
				String p = String.format("$%,d\n", thisHouse.getPrice()); //Price formatted nice
				String fs = String.format("%,d square feet\n", thisHouse.getArea()); //Area (floorspace) formatted nice
				String b = String.format("%d bedrooms\n", thisHouse.getNumBedrooms());
				s = s.concat(a + p + fs + b);
				hh.add(s);
			}
		}
		return hh;
	}
	
	/**
	 * Returns the number of Houses matching the given Criteria in HouseList.houseList.
	 * @param c The Criteria being matched.
	 * @return int
	 * */
	public int getNumOfMatches(Criteria c) {
		int count = 0;
		for(int i = 0; i < this.houseList.size(); i++) {
			if(this.houseList.get(i).satisfies(c))
				count++;
		}
		return count;
	}

}
