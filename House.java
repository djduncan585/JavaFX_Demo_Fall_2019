/*
 * Dave Duncan
 * CSC205 Fundamentals of Data Structures
 * Dr. Sandeep Mitra
 * Project 2
 * 12 November 2019
 */

package project2;
/**
 * Represents the details of a house for sale.
 * */
public class House {
//Attributes
	private String address;
	private Integer price;
	private Integer area;
	private Integer numBedrooms;
	
//Constructor
	/**
	 * Constructor for the House class. It requires input of a String representing the address,
	 * an Integer representing price in US Dollars, an Integer representing floor area in square feet,
	 * and an Integer representing the number of bedrooms.
	 * @param address The street address for the House. (Internal to the string, all spaces
	 * are represented by hyphens (-).)
	 * @param price The price of the House in US dollars.
	 * @param area The floor area of the House in square feet.
	 * @param numBedrooms The number of bedrooms this house has.
	 * */
	public House(String address, Integer price, Integer area, Integer numBedrooms) {
		this.address = address;
		this.price = price;
		this.area = area;
		this.numBedrooms = numBedrooms;
	}
	
// Accessors
	/**
	 * Getter method for the address for this House.
	 * @return String
	 * */
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * Getter method for the price in US dollars for this House.
	 * @return Integer
	 * */
	public Integer getPrice() {
		return this.price;
	}
	
	/**
	 * Getter method for the floor area in square feet for this House.
	 * @return Integer
	 * */
	public Integer getArea() {
		return this.area;
	}
	
	/**
	 * Getter method for the number of bedrooms for this House.
	 * @return Integer
	 * */
	public Integer getNumBedrooms() {
		return this.numBedrooms;
	}
	
// Methods
	/**
	 * The toString method for the House class. It strips the hyphens from the
	 * Address field and generally makes the data into more presentable text.
	 * @return String
	 * */
	public String toString() {
		String a = this.address.replace('-', ' ').concat("\n");
		String p = String.format("$%,d\n", this.price); //Price formatted nice
		String fs = String.format("%,d square feet\n", this.area); //Area (floorspace) formatted nice
		String b = String.format("%d bedrooms\n", this.numBedrooms);
		String s = a + p + fs + b;
		return s;
	}
	
	/**
	 * Checks this house to determine if it meets the Criteria passed to it.
	 * Criteria values that are null are skipped; thus, if all values passed to the 
	 * Criteria are null, this method will return true.
	 * @param c The Criteria that this House is being checked against.
	 * @return boolean*/

	 public boolean satisfies(Criteria c) {
		 if(c.getMinimumPrice() != null) 
			 if(c.getMinimumPrice() > this.price)
				 return false;
		 if(c.getMaximumPrice() != null) 
			 if(c.getMaximumPrice() < this.price)
				 return false;
		 if(c.getMinimumArea() != null)
			 if(c.getMinimumArea() > this.area)
				 return false;
		 if(c.getMaximumArea() != null)
			 if(c.getMaximumArea() < this.area)
				 return false;
		 if(c.getMinimumNumberOfBedrooms() != null)
			 if(c.getMinimumNumberOfBedrooms() > this.numBedrooms)
				 return false;
		 if(c.getMaximumNumberOfBedrooms() != null)
			 if(c.getMaximumNumberOfBedrooms() < this.numBedrooms)
				 return false;
		 return true;
	 }
	 
}
