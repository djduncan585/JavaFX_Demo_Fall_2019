/*
 * Dave Duncan
 * CSC205 Fundamentals of Data Structures
 * Dr. Sandeep Mitra
 * Project 2
 * 12 November 2019
 */

package project2;

/**
 * Contains the criteria specified by the user to select Houses.
 * (See also House.satisfies() method.)
 * */
public class Criteria {
	//Attributes
	private Integer minimumPrice = null;
	private Integer maximumPrice = null;
	private Integer minimumArea = null;
	private Integer maximumArea = null;
	private Integer minimumNumberOfBedrooms = null;
	private Integer maximumNumberOfBedrooms = null;
	
	//Constructor
	/**
	 * Default constructor for the Criteria class. It sets no criteria for a search,
	 * and is intended to be used in a search that returns everything. Setters can
	 * be used later to more selectively filter values.*/
	public Criteria() {}
	
	/**
	 * Constructor using all six of the defined search criteria.
	 * @param minimumPrice The minimum price value in US dollars for the House being searched for.
	 * @param maximumPrice The maximum price value in US dollars for the House being searched for.
	 * @param minimumArea The minimum area in square feet of the House being searched for.
	 * @param maximumArea The maximum area in square feet of the House being searched for.
	 * @param minimumNumberOfBedrooms The minimum number of bedrooms in the House being searched for.
	 * @param maximumNumberOfBedrooms The maximum number of bedrooms in the House being searched for.
	 * */
	public Criteria(Integer minimumPrice, Integer maximumPrice, Integer minimumArea, Integer maximumArea, Integer minimumNumberOfBedrooms, Integer maximumNumberOfBedrooms) {
		this.minimumPrice = minimumPrice;
		this.maximumPrice = maximumPrice;
		this.minimumArea = minimumArea;
		this.maximumArea = maximumArea;
		this.minimumNumberOfBedrooms = minimumNumberOfBedrooms;
		this.maximumNumberOfBedrooms = maximumNumberOfBedrooms;
	}
	
	//Accessor Methods
	
	/**Getter method for the minimum House price being searched for.
	 * @return Integer*/
	public Integer getMinimumPrice() {
		return this.minimumPrice;
	}
	
	/**Getter method for the maximum House price being searched for.
	 * @return Integer*/
	public Integer getMaximumPrice() {
		return this.maximumPrice;
	}
	
	/**Getter method for the minimum House area in square feet being searched for.
	 * @return Integer*/
	public Integer getMinimumArea() {
		return this.minimumArea;
	}
	
	/**Getter method for the maximum House area in square feet being searched for.
	 * @return Integer*/
	public Integer getMaximumArea() {
		return this.maximumArea;
	}
	
	/**Getter method for the minimum number of bedrooms in the House being searched for.
	 * @return Integer*/
	public Integer getMinimumNumberOfBedrooms() {
		return this.minimumNumberOfBedrooms;
	}
	
	/**Getter method for the maximum number of bedrooms in the House being searched for.
	 * @return Integer*/
	public Integer getMaximumNumberOfBedrooms() {
		return this.maximumNumberOfBedrooms;
	}
	
	/**Setter method for the minimum House price in US dollars being searched for.
	 * @param mp The minimum price in US dollars of the House being searched for.*/
	public void setMinimumPrice(Integer mp) {
		this.minimumPrice = mp;
	}
	
	/**Setter method for the maximum House price in US dollars being searched for.
	 * @param mp The maximum price in US dollars of the House being searched for.*/
	public void setMaximumPrice(Integer mp) {
		this.maximumPrice = mp;
	}
	
	/**Setter method for the minimum area in square feet of the House being searched for.
	 * @param ma The minimum area in square feet of the House being searched for.*/
	public void setMinimumArea(Integer ma) {
		this.minimumArea = ma;
	}
	
	/**Setter method for the maximum area in square feet of the House being searched for.
	 * @param ma The maximum area in square feet of the House being searched for.*/
	public void setMaximumArea(Integer ma) {
		this.maximumArea = ma;
	}
	
	/**Setter method for the minimum number of bedrooms in the House being searched for.
	 * @param mb The minimum number of bedrooms in the House being searched for.*/
	public void setMinimumNumberOfBedrooms(Integer mb) {
		this.minimumNumberOfBedrooms = mb;
	}
	
	/**Setter method for the maximum number of bedrooms in the House being searched for.
	 * @param mb The maximum number of bedrooms in the House being searched for.*/
	public void setMaximumNumberOfBedrooms(Integer mb) {
		this.maximumNumberOfBedrooms = mb;
	}
}
