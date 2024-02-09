// -------------------------------------------------------
// Assignment {4}
// Written by: {Brian Ly 40028072}
// For COMP 248 Section {H} – Fall 2023
// ---------------------------------------------------------

// The Sales class to keep track of number of sales sold on-demand

public class Sales {

	//Attributes representing the prices of each meal size as static constant integers
	public static final int JUNIOR_PRICE = 5;
	public static final int TEEN_PRICE = 10;
	public static final int MEDIUM_PRICE = 12;
	public static final int BIG_PRICE = 15;
	public static final int FAMILY_PRICE = 20;
	
	//Attributes representing the quantity of each meal sold as integers
	private int nbJuniorsSold;
	private int nbTeensSold;
	private int nbMediumsSold;
	private int nbBigsSold;
	private int nbFamilysSold;
	
	
	//--------------------Constructors-----------------------//
	
	public Sales( ) // default constructor
	{
		nbJuniorsSold = 0;
		nbTeensSold = 0;
		nbMediumsSold = 0;
		nbBigsSold = 0;
		nbFamilysSold = 0;
	}
	
	//constructor with 5 integer parameters to set the number of each meal
	public Sales(int nbJuniorsSold, int nbTeensSold, int nbMediumsSold, int nbBigsSold, int nbFamilysSold)
	{
		setNbJuniors(nbJuniorsSold);
		setNbTeens(nbTeensSold);
		setNbMediums(nbMediumsSold);
		setNbBigs(nbBigsSold);
		setNbFamilys(nbFamilysSold);
	}
	
	public Sales(Sales otherSales) //copy constructor with 1 parameter
	{
		nbJuniorsSold = otherSales.nbJuniorsSold;
		nbTeensSold = otherSales.nbTeensSold;
		nbMediumsSold = otherSales.nbMediumsSold;
		nbBigsSold = otherSales.nbBigsSold;
		nbFamilysSold = otherSales.nbFamilysSold;
	}
	
	//--------------Accessors and Mutators-------------------//
	
	/* Method: setNbJuniors to set number of junior meals sold
	 * Result: none (void)
	 * Parameter: 1 integer
	*/
	public void setNbJuniors(int nbJuniors)
	{
		this.nbJuniorsSold = nbJuniors;
	}
	
	/* Method: setNbTeens to set number of teen meals sold
	 * Result: none (void)
	 * Parameter: 1 integer
	*/
	public void setNbTeens(int nbTeens)
	{
		this.nbTeensSold = nbTeens;
	}
	
	/* Method: setNbMediums to set number of medium meals sold
	 * Result: none (void)
	 * Parameter: 1 integer
	*/
	public void setNbMediums(int nbMediums)
	{
		this.nbMediumsSold = nbMediums;
	}
	
	/* Method: setNbBigs to set number of big meals sold
	 * Result: none (void)
	 * Parameter: 1 integer
	*/
	public void setNbBigs(int nbBigs)
	{
		this.nbBigsSold = nbBigs;
	}
	
	/* Method: setNbFamilys to set number of family meals sold
	 * Result: none (void)
	 * Parameter: 1 integer
	*/
	public void setNbFamilys(int nbFamilys)
	{
		this.nbFamilysSold = nbFamilys;
	}
	
	
	// Method: getNbJuniors to get number of junior meals sold as an integer
	public int getNbJuniors()
	{
		return nbJuniorsSold;
	}
	
	// Method: getNbTeens to get number of teen meals sold as an integer
	public int getNbTeens()
	{
		return nbTeensSold;
	}
	
	// Method: getNbMediums to get number of medium meals sold as an integer
	public int getNbMediums()
	{
		return nbMediumsSold;
	}
	
	// Method: getNbBigs to get number of big meals sold as an integer
	public int getNbBigs()
	{
		return nbBigsSold;
	}
	
	// Method: getNbFamilys to get number of big meals sold as an integer
	public int getNbFamilys()
	{
		return nbFamilysSold;
	}
	
	
	//------------------Methods-----------------------------//

	//Method: addSales to increase number of each meal based on user input
	//Description: Prompts user for 5 integers then sets number of each meal as sum of current number of meals + input
	public void addSales(int juniorsToAdd, int teensToAdd, int mediumsToAdd, int bigsToAdd, int familysToAdd)
	{
		setNbJuniors(nbJuniorsSold+juniorsToAdd);
		setNbTeens(nbTeensSold+teensToAdd);
		setNbMediums(nbMediumsSold+mediumsToAdd);
		setNbBigs(nbBigsSold+bigsToAdd);
		setNbFamilys(nbFamilysSold+familysToAdd);
		
	}
	//Method: salesTotal to return total value of sales in the PoS as an integer value
	public int salesTotal()  // Using camel notation instead of SalesTotal() written in the assignment question
	{
		return (nbJuniorsSold*JUNIOR_PRICE)+(nbTeensSold*TEEN_PRICE)+(nbMediumsSold*MEDIUM_PRICE)+
				(nbBigsSold*BIG_PRICE)+(nbFamilysSold*FAMILY_PRICE);
	}
	
	
	//Method: toString to return a string indicating the count of each meal along with the price
	public String toString()
	{
		return (nbJuniorsSold + " x $" + JUNIOR_PRICE + " + " + nbTeensSold + " x $" + TEEN_PRICE + " + " 
				+ nbMediumsSold + " x $" + MEDIUM_PRICE + " + " + nbBigsSold + " x $" + BIG_PRICE + " + "
				+ nbFamilysSold + " x $" + FAMILY_PRICE);
	}
	
	//Method: equals will return true if both Sales objects have same meal breakdown and false otherwise
	public boolean equals(Sales otherSales)
	{
		return ( (nbJuniorsSold == otherSales.nbJuniorsSold) && (nbTeensSold == otherSales.nbTeensSold) && 
				(nbMediumsSold == otherSales.nbMediumsSold) && (nbBigsSold == otherSales.nbBigsSold) &&
				(nbFamilysSold == otherSales.nbFamilysSold));
	}
}
