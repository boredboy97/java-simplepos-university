// -------------------------------------------------------
// Assignment {4}
// Written by: {Brian Ly 40028072}
// For COMP 248 Section {H} – Fall 2023
// ---------------------------------------------------------

/*Description: Driver file to demonstrate CostLess Bites Sales Counter application 
 * by testing the 3 classes: Sales, PrePaidCard and PoS.
 */

import java.util.Scanner;

public class PoSDemo {

	public static void main(String[] args) {
		
		//Welcome message
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("|	Welcome to Concordia CostLessBites Catering Sales Counter Application	|");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		//Hard coding 5 Sales objects to use in this Demo file
		
		Sales sales0 = new Sales(2, 1, 0, 4, 1); //First 2 have equal sales breakdown and value
		Sales sales1 = new Sales(sales0);
		Sales sales2 = new Sales(0, 1, 5, 2, 0);  //Different sales breakdown but same value as 0 and 1
		Sales sales3 = new Sales(3, 2, 4, 1, 2); // Last 2 have equal sales breakdown but different from other 3
		Sales sales4 = new Sales(sales3);
		
		//Hard coding 3 PrePaidCard objects to use in this Demo file
		
		PrePaidCard prePaidCard0 = new PrePaidCard("Vegetarian", 40825164, 31, 12);
		PrePaidCard prePaidCard1 = new PrePaidCard("Carnivore", 21703195, 3, 12);
		PrePaidCard prePaidCard2 = new PrePaidCard("Pescatarian", 95432806, 1, 6);
		
		//Hard coding 2 prepaid card arrays to use to create PoS objects
		
		PrePaidCard[] prePaidCards0 = {prePaidCard0};
		PrePaidCard[] prePaidCards1 = {prePaidCard0, prePaidCard1, prePaidCard2};
		
		//Hard coding 5 PoSs objects to use in Demo file
		
		PoS pos0 = new PoS(sales0, prePaidCards0); //First 2 PoSs have same number of prepaid cards
		PoS pos1 = new PoS(sales1, prePaidCards0);
		PoS pos2 = new PoS(sales2, prePaidCards1); //one PoS have at least 3 prepaid cards
		PoS pos3 = new PoS(sales3, null); //Last 2 PoSs have no prepaid cards
		PoS pos4 = new PoS(sales4, null);
		
		//Hard coding array of the 5 PoSs for this demo
		PoS[] poSs = {pos0, pos1, pos2, pos3, pos4};

		//Scanner object to prompt user later
		Scanner keyIn = new Scanner(System.in);
		
		//Initialization of integers necessary for demo,
		int menuChoice = 0, poSChoice = 0, prePaidCardToModify = 0;
		int idNumber = 0, expiryDay = 0, expiryMonth =0;
		int nbJuniorsSold=0, nbTeensSold=0, nbMediumsSold=0, nbBigsSold=0, nbFamilysSold =0;
		
		//Do-while loop to present menu with 10 possible actions for user to select from
		do { 
				
			displayMenu(); //Calling static method below to display action menu 		
			menuChoice = keyIn.nextInt();
			while (menuChoice < 0 || menuChoice > 9)
			{
				System.out.println("Sorry that is not a valid choice. Try again.\n"); //adding space after try again for better readability
				displayMenu();
				menuChoice = keyIn.nextInt();
			}
			
			//Switch cases for each of the possible actions
			switch (menuChoice)
			{
			//Case 1: Listing content of each PoS in poSs array with for loop and toString method from PoS class
			case 1:
				System.out.println("Content of each PoS:\n" + "---------------------" );
				for (int i = 0; i < poSs.length; i++) //for loop to invoke toString method to all PoS objects
				{
					System.out.println("PoS #" + i + ":");
					System.out.print(poSs[i].toString()); 
					System.out.println();
				}
				break;
				
			/* Case 2: Listing content of one PoS. Input validation for PoS choice will be used in all subsequent applicable cases.
			 * Accessing specific PoS element in poSs array and calling PoS toString method
			 */
			case 2:
				
				System.out.print("Which PoS do you want to see the content of? (Enter number 0 to 4): "); // fixed typo in assignment question
				poSChoice = getValidPoSChoice(); //Calling method to get valid PoS choice input as integer
				System.out.println(poSs[poSChoice].toString());
				break;
			
			/* Case 3: Comparing the total sales value of each PoS element in poSs array with 2 for loops 
			 * and displaying the poSs and the same total sales values as integers by calling the PoS salesTotalPoS method.
			 */
			case 3: 
				System.out.println("List of PoSs with the same total $ Sales\n"); //fixed typo of missing word "the"
				comparePoSTotalSales(poSs); //Calling static method
				System.out.println();
				break;
			
			/* Case 4: Comparing the sales breakdown of each PoS element in poSs array with 2 for loops 
			 * and displaying the poSs and their sales breakdown by calling the PoS salesCategoriesToString method.
			 */
			case 4:
				System.out.println("List of PoSs with same Sales categories\n");
				comparePoSSalesCategories(poSs);
				System.out.println();
				break;
			
			/* Case 5: Comparing the sales breakdown of each PoS element in poSs array with 2 for loops 
			 * and displaying the poSs and their sales breakdown by calling the PoS equals method.
			 */
			case 5:
				System.out.println("List of PoSs with same $ amount of sales and same number of PrePaidCards : \n"); //fixed typos
				comparePoS(poSs);
				System.out.println();
				break;
			
			/* Case 6: Adding a prepaid card to specified PoS. Verifies whether PoS has prepaid cards or not.
			 * Prompts user for card details then creates new prepaid card object using PrePaidCard constructor
			 * Calls addPrePaidCard method to specific PoS
			 * Displays new amount of prepaid cards in current PoS
			 */
			case 6:
				System.out.print("Which PoS do you want to add a PrePaidCard to? (Enter number 0 to 4): "); //fixed typos
				poSChoice = getValidPoSChoice(); //Calling method to get valid PoS choice input as integer
				
				System.out.println("Please enter the following information so that we may complete the PrePaidCard\n"
						+ " --> Type of PrePaidCard (Carnivore, Halal, Kosher, Pescatarian, Vegetarian, Vegan):"); //fixed typos and kept same line break for input
				String typeOfPrePaidCard = keyIn.next();
				
				System.out.print(" --> Id of the prepaid card owner: ");
				idNumber = keyIn.nextInt();
				
				System.out.print(" --> Expiry day number and month (separate by a space): ");
				expiryDay = keyIn.nextInt();
				expiryMonth = keyIn.nextInt();
				
				PrePaidCard newPrePaidCard = new PrePaidCard(typeOfPrePaidCard,idNumber,expiryDay,expiryMonth);
				poSs[poSChoice].addPrePaidCard(newPrePaidCard);
				
				if (poSs[poSChoice].nbPrePaidCards() == 1) //if only 1 prepaid card in PoS
					System.out.println("You now have 1 PrePaidCard" );
				else  //if more than 1 prepaid card in PoS
					System.out.println("You now have " + poSs[poSChoice].nbPrePaidCards() + " PrePaidCards");
				System.out.println();
				break;
			
			/* Case 7: Removes a prepaid card from specified PoS.
			 * Prompts user for which prepaid card to remove. Validates user input.
			 * Calls PoS removePrePaidCard method to remove card. Displays success message if prepaid is removed.
			 */
			case 7:
				System.out.print("Which PoS do you want to remove a PrePaidCard from? (Enter number 0 to 4): ");
				poSChoice = getValidPoSChoice(); //Calling method to get valid PoS choice input as integer
				
				if (poSs[poSChoice].nbPrePaidCards() != 0)
				{
					if (poSs[poSChoice].nbPrePaidCards() > 1 ) //if PoS has more than 1 card, prompt 0 to max number of cards
						System.out.println("(Enter number 0 to " + (poSs[poSChoice].nbPrePaidCards()-1) + "):");
					else
						System.out.println("(Enter number 0):"); //if POS has only 1 card, prompt 0
					
					// Calling static method to get valid prepaid card selection
					prePaidCardToModify = getValidPrePaidCardChoice(poSs[poSChoice]); 
					if(poSs[poSChoice].removePrePaidCard(prePaidCardToModify)) //if removePrePaidCard returns true
						System.out.println("PrePaidCard was removed successfully.");
				}
				else
					System.out.println("Sorry that PoS has no PrePaidCards.");
				
				System.out.println();
				break;
			
			/* Case 8: Updates expiry date of specified prepaid card in specified PoS.
			 * Prompts user for new expiry day and month.
			 * Calls PoS updateExpiryDate method to update prepaid card. Displays success message
			 */
			case 8:
				System.out.println("Which PoS do you want to update a PrePaidCard from? (Enter number 0 to 4): ");
				
				poSChoice = getValidPoSChoice(); //Calling static method to get valid PoS choice input as integer
				
				if (poSs[poSChoice].nbPrePaidCards() != 0) //if at least 1 prepaid card in PoS, prompt for details
				{
					if (poSs[poSChoice].nbPrePaidCards() > 1) // if PoS has more than 1 card, prompt 0 to max number of cards
						System.out.println("Which PrePaidCard do you want to update? (Enter number 0 to " 
								+ (poSs[poSChoice].nbPrePaidCards()-1) + "):");
					else
						System.out.println("Which PrePaidCard do you want to update? (Enter number 0)"); //if POS has only 1 card, prompt 0
					
					// Calling static method to get valid prepaid card selection
					prePaidCardToModify = getValidPrePaidCardChoice(poSs[poSChoice]); 
					System.out.print(" --> Enter new expiry date day number and month (separate by a space): ");
					expiryDay = keyIn.nextInt();
					expiryMonth = keyIn.nextInt();
					poSs[poSChoice].updateExpiryDate(prePaidCardToModify, expiryDay, expiryMonth);
					System.out.println("Expiry Date updated.");
				}
				else //if no prepaid cards in PoS
					System.out.println("Sorry that PoS has no PrePaidCards."); 
				
				System.out.println();
				break;
			
			/* Case 9: Adds sales to specified PoS
			 * Prompts user for number of sales for each meal type to add to PoS
			 * Calls PoS addSalesPoS method to update sales. Displays new total sales value of PoS formatted to 1 decimal.
			 */
			case 9:
				System.out.print("Which PoS do you want to add Sales to? (Enter number 0 to 4): ");
				
				poSChoice = getValidPoSChoice(); //Calling method to get valid PoS choice input as integer
				
				System.out.print("How many junior, teen, medium, big and family meals do you want to add?\n"
						+ "(Enter 5 numbers separated by a space): "); //fixed grammar of question
				
				nbJuniorsSold = keyIn.nextInt();
				nbTeensSold = keyIn.nextInt();
				nbMediumsSold = keyIn.nextInt();
				nbBigsSold = keyIn.nextInt();
				nbFamilysSold = keyIn.nextInt();
				
				poSs[poSChoice].addSalesPoS(nbJuniorsSold, nbTeensSold, nbMediumsSold, nbBigsSold, nbFamilysSold);
				
				System.out.printf("You now have $" + "%.1f\n", poSs[poSChoice].salesTotalPoS());
				System.out.println();
				break;
			
			// Case 0: quits menu and displays thank you message
			case 0:
				System.out.print("Thank you for using Concordia CostLessBites Catering Sales Counter Application!");
				break;
			}
					
		} while (menuChoice != 0); //While choice of action is not to quit, loops display menu
		
		keyIn.close(); //Close scanner
		
	}
	
	
	//------------------- STATIC METHODS ------------------//
	
	//Static method to display menu of choices
	public static void displayMenu()
	{
		System.out.println("| What would you like to do?							|");
		System.out.println("| 1 >> See the content of all PoSs						|\n"
			+ "| 2 >> See the content of one PoS 						|\n"
			+ "| 3 >> List PoSs with same $ amount of sales 					|\n"
			+ "| 4 >> List PoSs with same number of Sales categories 				|\n"
			+ "| 5 >> List PoSs with same $ amount of Sales and same number of prepaid cards   |\n"
			+ "| 6 >> Add a PrePaidCard to an existing PoS 					|\n"     //fixed typo
			+ "| 7 >> Remove an existing prepaid card from a PoS 				|\n"
			+ "| 8 >> Update the expiry date of an existing Prepaid card 			|\n"
			+ "| 9 >> Add Sales to a PoS 							|\n"					+ "| 0 >> To quit 									|\n"
			+ "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.print("Please enter your choice and press <Enter>: "); //added space after : for better readability (in assignment question they do not add space)
		
	}

	//Static method to validate user input of PoS choice and return as an integer
	public static int getValidPoSChoice()
	{
		Scanner keyIn = new Scanner(System.in);
		int poSChoice;  
		
		poSChoice = keyIn.nextInt();
		
		//while loop to repeat prompt if user does not enter valid integer for PoS choice
		while (poSChoice < 0 || poSChoice > 4) 
		{
			System.out.print("Sorry but there is no PoS number " + poSChoice 
					+ "\n--> Try again: (Enter number 0 to 4): ");
			poSChoice = keyIn.nextInt();
		}
		
		//Cannot close scanner here otherwise runtime error
		return poSChoice;
		
	}
	
	//Static method to get a valid prepaid card choice from user input
	public static int getValidPrePaidCardChoice(PoS chosenPoS)
	{
		Scanner keyIn = new Scanner(System.in);
		int prePaidCardToModify;  
		
		prePaidCardToModify = keyIn.nextInt();
		
		//While loop to repeat prompt if user does not enter valid integer for prepaid card choice
		while (prePaidCardToModify < 0 || prePaidCardToModify > chosenPoS.nbPrePaidCards())
		{
			System.out.print("Sorry, invalid input. Please select PrePaidCard card again: ");
			prePaidCardToModify = keyIn.nextInt();
		}
		
		//Cannot close scanner here otherwise runtime error
		return prePaidCardToModify;
		
	}
	
	//Static method to compare total sales of each PoS in PoS array and print the pairs with same total sales
	public static void comparePoSTotalSales(PoS[] poSs)
	{
		//nested for loop to compare each element with subsequent element in PoS array
		for (int i = 0; i < poSs.length-1; i++) 
		{
			for (int j = 1; j < poSs.length; j++)
			{
				//Calls equalsTotalSales method in PoS class to compare total sales value
				if ( poSs[i].equalsTotalSales(poSs[j]) && (i < j) ) //if i<j to only print each pair once
					System.out.println("\tPoSs " + i + " and " + j + " both have " + (int) poSs[i].salesTotalPoS()); //casting total sales value to integer as indicated in sample output
			}
		}
	}
	
	//Static method to compare sales categories of each PoS in PoS array and print pairs with same breakdown
	public static void comparePoSSalesCategories(PoS[] poSs)
	{
		//nested for loop to compare each element with subsequent element in PoS array
		for (int i = 0; i < poSs.length-1; i++)
		{
			for (int j = 1; j < poSs.length; j++)
			{
				//Calls equalsSalesCategory method in PoS class to compare sales breakdown
				if ( poSs[i].equalsSalesCategory(poSs[j]) && (i < j) ) //if i<j to only print each pair once
					System.out.println("\tPoSs " + i + " and " + j + " both have " + poSs[i].salesCategoriesToString()); 
			}
		}
	}
	
	//Static method that compares PoS based on total sales and number of prepaid cards and prints equal pairs
	public static void comparePoS(PoS[] poSs)
	{
		//nested for loop to compare each element with subsequent element in PoS array
		for (int i = 0; i < poSs.length-1; i++)
		{
			for (int j = 1; j < poSs.length; j++)
			{
				//Calls equals in PoS class to compare both total sales and number of prepaid cards of each PoS
				if ( poSs[i].equals(poSs[j]) && (i < j) ) //if i<j to only print each pair once
					System.out.println("\tPoSs " + i + " and " + j);
			}
		}
	}
	
	
	
}
