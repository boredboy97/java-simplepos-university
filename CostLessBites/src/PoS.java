// -------------------------------------------------------
// Assignment {4}
// Written by: {Brian Ly 40028072}
// For COMP 248 Section {H} – Fall 2023
// ---------------------------------------------------------

/* The PoS card class containing the Sales data stored as objects and PrePaidCards data stored as arrays of objects
 * This class also uses Sales and PrePaidCard classes.
 */

public class PoS {

	//Attributes of type Sales as an object and of type PrePaidCard as an array
	private Sales salesPoS;
	private PrePaidCard[] prepaidcardsPoS;  
	
	//--------------------Constructors-----------------------//
	
	public PoS() // default constructor initializing both attributes to default values
	{
		salesPoS = new Sales(); //creating Sales object using Sales default constructor
		prepaidcardsPoS = null;
	}
	
	public PoS(Sales salesPoS, PrePaidCard[] prepaidcards)
	{
		this.salesPoS = new Sales(salesPoS);
		if (prepaidcards != null) // if parameter of prepaid cards has at least 1 card, deep copy array to avoid privacy leaks
		{
			prepaidcardsPoS = new PrePaidCard[prepaidcards.length];
			for (int i = 0; i < prepaidcards.length; i++)
				prepaidcardsPoS[i] = prepaidcards[i]; 
		}
			
		else // if parameter of prepaid cards has 0 prepaid cards, initialize attribute to 0
			prepaidcardsPoS = null;
	}
	
	//Method: equalsTotalSales to return true if total sales value of two PoS objects are equal, false otherwise
	public boolean equalsTotalSales(PoS otherPoS)
	{
		return (salesPoS.salesTotal() == otherPoS.salesPoS.salesTotal());
	}
	
	//Method: equalsSalesCategory to return true if breakdown of meal categories of two PoS objects are equal, false otherwise
	public boolean equalsSalesCategory(PoS otherPoS)
	{
		return (salesPoS.equals(otherPoS.salesPoS));
	}
	
	//Method: salesTotalPoS to return total value of sales in PoS as a double
	public double salesTotalPoS()
	{
		return (double) salesPoS.salesTotal();
	}
	
	//Method: nbPrePaidCards to return number of prepaid cards in PoS as an integer
	public int nbPrePaidCards()
	{
		int nbPrePaidCards = 0;
		if (prepaidcardsPoS != null)
			nbPrePaidCards = prepaidcardsPoS.length;
		return nbPrePaidCards;
	}
	
	
	/*Method: AddPrePaidCard to increase deep copy of prepaid cards array by 1.
	 * 		  Assigns the new prepaid card object to that element.
	 * 		  Returns new amount of prepaid cards in PoS.
	*/
	public int addPrePaidCard(PrePaidCard newPrePaidCard)
	{
		PrePaidCard[] copyPrePaidCardsPoS = new PrePaidCard[1]; // new array of prepaid cards will have size of at least 1
		if (prepaidcardsPoS != null) // if there is at least 1 prepaid card, create copy of array with size + 1
		{
			copyPrePaidCardsPoS = new PrePaidCard[prepaidcardsPoS.length+1];
			for (int i = 0; i < prepaidcardsPoS.length; i++)
				copyPrePaidCardsPoS[i] = prepaidcardsPoS[i];
		}
		copyPrePaidCardsPoS[copyPrePaidCardsPoS.length-1] = new PrePaidCard(newPrePaidCard);
		prepaidcardsPoS = new PrePaidCard[copyPrePaidCardsPoS.length];
		for (int i = 0; i < copyPrePaidCardsPoS.length; i++)
			prepaidcardsPoS[i] = new PrePaidCard(copyPrePaidCardsPoS[i]);
		
		return prepaidcardsPoS.length;
	}
	
	/* Method: removePrePaidCard to remove prepaid card specified by user. 
	 * 		   Creates a copy of original array with 1 less element.
	 * 		   Deep copies original array without specified element from original array.
	 * 		   Returns true if new amount of prepaid cards is 1 less than original amount.
	 */
	public boolean removePrePaidCard(int cardToRemove)
	{
		PrePaidCard[] copyPrePaidCardsPoS = null;
		if (prepaidcardsPoS != null)
		{
			copyPrePaidCardsPoS = new PrePaidCard[prepaidcardsPoS.length-1];
			int index = 0;
			for (int i = 0; i < prepaidcardsPoS.length; i++)
			{
				if(i != cardToRemove)
				{
					copyPrePaidCardsPoS[index]=prepaidcardsPoS[i]; // deep copy the original array
					index++;
				}
			}
			prepaidcardsPoS = copyPrePaidCardsPoS; //current array will now reference new array
			if (prepaidcardsPoS.length == 0) //if array has no prepaid cards, set array to null
				prepaidcardsPoS = null; 
			return true;
		}
		else
			return false;
		
	}
	
	//Method: updateExpiryDate to update the expiry day and month within the prepaid card object of the array
	public void updateExpiryDate(int cardToUpdate, int expiryDay, int expiryMonth)
	{
		prepaidcardsPoS[cardToUpdate].setExpiryDay(expiryDay); 
		prepaidcardsPoS[cardToUpdate].setExpiryMonth(expiryMonth);
		
	}
	
	
	//Method: addSalesPoS to add sales for each meal type and return new total sales value as an integer
		public int addSalesPoS(int juniorsToAdd, int teensToAdd, int mediumsToAdd, int bigsToAdd, int familysToAdd)
		{
			salesPoS.addSales(juniorsToAdd, teensToAdd, mediumsToAdd, bigsToAdd, familysToAdd);
			return salesPoS.salesTotal();
		}
	
	//Method: equals returns true if total sales value and number of prepaid cards of two PoS objects are equal, false otherwise
	public boolean equals(PoS otherPoS)
	{
			return ((salesPoS.salesTotal() == otherPoS.salesPoS.salesTotal()) 
					&& (nbPrePaidCards() == otherPoS.nbPrePaidCards()) );
	
	}
	
	//Method: toString to return as a string the total sales value and prepaid card details of each card in chosen PoS
	public String toString()
	{
		if (prepaidcardsPoS != null)
		{
			String prepaidcardDetails = "";
			for (int i = 0; i < prepaidcardsPoS.length; i++)
				prepaidcardDetails += prepaidcardsPoS[i].toString() + "\n"; //storing details of each prepaid card as a string
			return salesPoS.toString() + "\n" + prepaidcardDetails; //returns sales object automatically as toString and prepaidcard details
		}
		else
			return salesPoS.toString() + "\nNo pre-paid cards." + "\n";
	}
	
	//Method: to return as a string the breakdown of sales
	public String salesCategoriesToString()
	{
		return salesPoS.toString();
	}
	
	
}
