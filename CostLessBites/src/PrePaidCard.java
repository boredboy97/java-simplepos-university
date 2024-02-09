// -------------------------------------------------------
// Assignment {4}
// Written by: {Brian Ly 40028072}
// For COMP 248 Section {H} – Fall 2023
// ---------------------------------------------------------

// The PrePaidCard class to keep track of prepaid card types used, the ID of the card holder and the expiry date

//Note: corrected typo of PrePaiCard written in assignment to PrePaidCard for this class

public class PrePaidCard {
	
	//Attribute for the prepaid cards
	private String type; 
	private int idNumber;
	private int expiryDay;
	private int expiryMonth;

	//--------------------Constructors-----------------------//
	
	public PrePaidCard( ) //default constructor
	{
		type = "";
		idNumber = 0;
		expiryDay = 0;
		expiryMonth = 0;
	}
	
	//constructor with 4 parameters to set initial value of each attribute of the class
	public PrePaidCard(String type, int idNumber, int expiryDay, int expiryMonth)
	{
		this.type = type;
		this.idNumber = idNumber;
		setExpiryDay(expiryDay);
		setExpiryMonth(expiryMonth);
	}
	
	public PrePaidCard(PrePaidCard otherPrePaidCard) //copy constructor with 1 parameter
	{
		type = otherPrePaidCard.type;
		idNumber = otherPrePaidCard.idNumber;
		expiryDay = otherPrePaidCard.expiryDay;
		expiryMonth = otherPrePaidCard.expiryMonth;
		
	}
	
	//--------------Accessors and Mutators-------------------//
	
	
	/* Method: setExpiryDay to set expiry day of prepaid card
	 * Result: none (void)
	 * Parameter: 1 integer. If proposed integer is not between 1 to 31, expiry day is set to 0.
	*/
	public void setExpiryDay(int expiryDay)
	{
		if (expiryDay >= 1 && expiryDay <= 31)
			this.expiryDay = expiryDay;
		else
			expiryDay = 0;
	}
	
	/* Method: setExpiryMonth to set expiry month of prepaid card
	 * Result: none (void)
	 * Parameter: 1 integer. If integer is not between 1 to 12, expiry month is set to 0.
	*/
	public void setExpiryMonth(int expiryMonth)
	{
		if (expiryMonth >= 1 && expiryMonth <= 12)
			this.expiryMonth = expiryMonth;
		else
			expiryMonth = 0;
	}
	
	//Method: getType to return type of prepaid card as String
	public String getType()
	{
		return type;
	}
	
	//Method: getIdNumber to return ID number of prepaid card as integer
	public int getIdNumber()
	{
		return idNumber;
	}
	
	//Method: getExpiryDay to return expiry date of prepaid card as integer
	public int getExpiryDay()
	{
		return expiryDay;
	}
	
	//Method: getExpiryMonth to return expiry month of prepaid card as integer
	public int getExpiryMonth()
	{
		return expiryMonth;
	}
	
	//------------------Methods-----------------------------//
	
	
	//Method: toString to return a string indicating type of prepaid card, ID number and formatted expiry date
	public String toString()
	{
	
		return (type + " - " + idNumber + " - " + expiryDayString(expiryDay) + "/" + expiryMonthString(expiryMonth));
	}
	
	//Method: equals returns true if two prepaid cards are identical in information, otherwise false
	public boolean equals(PrePaidCard otherPrePaidCard)
	{
		return ( (type.equals(otherPrePaidCard.type)) && (idNumber == otherPrePaidCard.idNumber) 
				&& (expiryDay == otherPrePaidCard.expiryDay) && (expiryMonth ==otherPrePaidCard.expiryMonth) );
	}
	
	
	//Method: expiryDayString to format expiry day as dd and return 0 if not between 1 and 31 (as specified in assignment)
	private String expiryDayString(int expiryDay)
	{
		String expiryDayString = "";
		if (expiryDay > 0 && expiryDay < 10) //if day is between 0 and 10, adds 0 in front of day
			expiryDayString = "0" + expiryDay;
		else if (expiryDay <= 31) //if day between 10 and 31, converts integer to string
			expiryDayString = Integer.toString(expiryDay);
		else
			expiryDayString = "0"; //return 0 if day is not between 1 and 31
		return expiryDayString;
	}
	
	//Method: expiryMonthString to format expiry month as mm and return 0 if not between 1 and 12 (as specified in assignment)
		private String expiryMonthString(int expiryMonth)
		{
			String expiryMonthString = " ";
			if (expiryMonth > 0 && expiryMonth < 10) //if month is between 0 and 10, adds 0 in front of month
				expiryMonthString = "0" + expiryMonth;//if month between 10 and 12, converts integer to string
			else if (expiryMonth <= 12)
				expiryMonthString = Integer.toString(expiryMonth);
			else
				expiryMonthString =  "0"; //return 0 if month is not between 1 and 12
			return expiryMonthString;
		}
}


