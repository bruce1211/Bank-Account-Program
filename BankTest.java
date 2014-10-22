package edu.csulb.cecs274;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BankTest {

	static Scanner userInput = new Scanner(System.in);
	public static void main(String[] args) throws IOException
	{
		PrintWriter out = new PrintWriter("C:\\Users\\Dennis\\workspace\\A7IrwinAncheta\\src\\edu\\csulb\\cecs274\\outputFile");
		
		BankCustomer newCustomer;
		BankCustomer ownedAccounts;
		Bank chase = new Bank("Chase");
		BankAccount activeAccount;
		BankCustomer customerAccount;
		BankAccount newAccount;

		String inputDesiredAccountNum;
		int desiredAccount;
		double desiredInputBalance;
		double inputBalance;
		String firstName;
		String lastName;
		String firstNameInput;
		String lastNameInput;
		int bankingActions;
		
		int customer=0;
		int account=0;
		
		System.out.println("Welcome to " + chase.getBankName("Chase") + "!");
		System.out.println("1. Create a new account");
		System.out.println("2. Existing users");
		System.out.println("Enter -1 to exit");

		
		
		System.out.println("Enter your choice");
		int choice = userInput.nextInt();
		while(choice != -1)
		{
			switch(choice)
			{
				case 1:
					System.out.println("Create a new account by entering your first name");
		            firstName = userInput.next( );
		            System.out.println("Please enter your last name");
		            lastName = userInput.next( );
		            newCustomer= new BankCustomer(firstName, lastName);
		            while(chase.checkExistingCustomer(firstName, lastName))
		            {	
		            	System.out.println("Already exists");
		            	System.out.println("Create a new account by entering your first name");
			            firstName = userInput.next( );
			            System.out.println("Please enter your last name");
			            lastName = userInput.next( );
			            newCustomer= new BankCustomer(firstName, lastName);
		            }
		            chase.addCustomer(newCustomer);
		            customer++;
		            
		            System.out.println("Please enter your desired account number");
		            desiredAccount= userInput.nextInt( );
		            System.out.println("Thank you, now please enter your desired intial balance");
		            inputBalance = userInput.nextDouble( );
		            newAccount = new BankAccount(desiredAccount, inputBalance);
		            chase.addAccount(newAccount);
		            account++;
		            		
		            
		            BankCustomer.addAccount(newAccount);
		            System.out.println("New Account created, "+newCustomer.getFirstName()+" "+newCustomer.getLastName());
		            System.out.println("Your new Account has a balance of $"+newAccount.getBalance()
		                    +" and is under Account Number "+newAccount.getAccountNumber());
		            
		            break;
		           
						               	                					
				case 2:
					System.out.println("We will need your full name");
					System.out.println("Please enter your first name");
	                firstNameInput = userInput.next( );
	                firstName = firstNameInput;
	                System.out.println("Please enter your last name");
	                lastNameInput = userInput.next( );
	                lastName = lastNameInput;
	                customerAccount = chase.getCustomer(chase.findCustomer(firstName, lastName));
	                  
	                System.out.println("Here is a list of your accounts, " +customerAccount.listOfAccountNum());
	                System.out.println("Enter your account number to perform transactions:");
	                desiredAccount = userInput.nextInt();
	                activeAccount = chase.getAccount(customerAccount.findAccount(desiredAccount));
	                while(!BankCustomer.checkExistingAccount(desiredAccount))
	                {
	                	System.out.println("Doesn't exist");
	                	desiredAccount = userInput.nextInt();
	                }
	                
	                System.out.println("1. Deposit?");
	                System.out.println("2. Withdraw?");
	                System.out.println("3. Transfer?");
	                System.out.println("4. Check Account Balance?");
	                System.out.println("5. Add an account");
	                System.out.println("6. Remove an account");
	                System.out.println("Enter -1 to exit to main menu");
	                bankingActions = userInput.nextInt( );
	                while(bankingActions != -1)
	                {
	                	switch(bankingActions)
		                {
		                	case 1:
		                		 System.out.println("How much would you like to Deposit?");
		                         String  userDepositAmount = userInput.next( );
		                         double depositAmount = Double.parseDouble(userDepositAmount);
		                         activeAccount.deposit(depositAmount);
		                         break;
		                         
		                	case 2:
		                		System.out.println("How much would you like to Withdraw?");
		                        String  userWithdrawAmount = userInput.next( );
		                        double withdrawAmount = Double.parseDouble(userWithdrawAmount);
		                        activeAccount.withdraw(withdrawAmount);
		                        break;
		                        
		                	case 3:
		                	    System.out.println("Please enter the account number of the account that you would like to Transfer to.");
		                        String  userTransferAccountNum = userInput.next( );
		                        int transferAccountNum = Integer.parseInt(userTransferAccountNum);
		                        BankAccount accountToRecieveTransfer = chase.getAccount(chase.findAccount(transferAccountNum));
		                        System.out.println("The current balance of account "+ activeAccount.getAccountNumber()+" is $"+activeAccount.getBalance()+"    How much would you like to Transfer?");
		                        String  userTransferAmount = userInput.next( );
		                        double transferAmount = Double.parseDouble(userTransferAmount);
		                        activeAccount.transferTo(transferAmount, accountToRecieveTransfer);	                     
		                        break;
		                        
		                	case 4: 
		                        System.out.println("The balance remaining in account number "+ activeAccount.getAccountNumber()+" is $"+activeAccount.getBalance());
		                      	break;
		                      	
		                	case 5:
		  		                System.out.println("Please enter your desired account number");
		  		                desiredAccount = userInput.nextInt( );		          
		  		                System.out.println("Thank you, now please enter your desired intial balance");
		  			            desiredInputBalance = userInput.nextDouble( );			            
		  			            while(chase.checkExistingAccount(desiredAccount))
		  		                {
		  		                    System.out.println("That account already exists. Please enter a unique account number");
		  		                    inputDesiredAccountNum = userInput.next( );
		  		                    desiredAccount = Integer.parseInt(inputDesiredAccountNum);
		  		                }
		  		                chase.addAccount(new BankAccount(desiredAccount, desiredInputBalance));
		  		                newAccount = new BankAccount(desiredAccount, desiredInputBalance);
		  		                chase.addAccount(newAccount);
		  		                account++;
		  		                BankCustomer.addAccount(newAccount);		                
		  		                System.out.println("New Account created, "+customerAccount.getFirstName()+" "+customerAccount.getLastName());
		  		                System.out.println("Your new Account has a balance of $"+newAccount.getBalance()
		  		                        +" and is under Account Number "+newAccount.getAccountNumber());		             
		  		                while(chase.checkExistingAccount(desiredAccount))
		  		                {
		  		                    System.out.println("That account already exists. Please enter a unique account number");
		  		                    inputDesiredAccountNum = userInput.next( );
		  		                    desiredAccount = Integer.parseInt(inputDesiredAccountNum);
		  		                }
		  		                
		  		             
		  		                break;
		  		                
		                  	case 6:
		    	                System.out.println("Here is a list of your accounts, " +customerAccount.listOfAccountNum()+
		    	                        "    Please enter the account number of the account you would like to remove");
		    	                String  inputAccountToRemove = userInput.next( );
		    	                int accountToRemove = Integer.parseInt(inputAccountToRemove);

		    	                while(!BankCustomer.checkExistingAccount(accountToRemove))
		    	                {
		    	                    System.out.println("That account doesn't exist. Please enter an existing account number");
		    	                    inputDesiredAccountNum = userInput.next( );
		    	                    accountToRemove = Integer.parseInt(inputDesiredAccountNum);
		    	                }

		    	                BankAccount customerAccountToRemove = customerAccount.getAccount(customerAccount.findAccount(accountToRemove));
		    	                customerAccount.removeAccount(customerAccountToRemove);
		    	                BankAccount chaseAccountToRemove = chase.getAccount(chase.findAccount(accountToRemove));
		    	                chase.removeAccount(chaseAccountToRemove);
		    	                System.out.println("Account removal succcessful, "+customerAccount.getFirstName()+" "+customerAccount.getLastName());
		    	                System.out.println("Here are your remaining accounts "+ customerAccount.listOfAccountNum());
		    	                
		    	                account--;
		    	                break;
		    	                
		                  	case 7:
		                  		break;
		    	                
		                	}
	                	
	                	System.out.println("1. Deposit?");
	 	                System.out.println("2. Withdraw?");
	 	                System.out.println("3. Transfer?");
	 	                System.out.println("4. Check Account Balance?");
	 	                System.out.println("5. Add an account");
	 	                System.out.println("6. Remove an account");
	 	                System.out.println("Enter -1 to exit to main menu");
	 	                bankingActions = userInput.nextInt( );
	                }
	                
			}
			
			System.out.println("Welcome to " + chase.getBankName("Chase") + "!");
			System.out.println("1. Create a new account");
			System.out.println("2. Existing users");
			System.out.println("Enter -1 to exit");
			System.out.println("Enter your choice");
			choice = userInput.nextInt();
		
		
		}
				
		out.println(chase.getBankName("Chase") + ", " + customer + ", " + account + ", " + chase.totalBalance());

		for(int i=0; i < customer; i++)
		{
			out.println(chase.getCustomer(i).getLastName() + ", " + chase.getCustomer(i).getFirstName());
				
		}	
		
		for(int i=0; i < customer; i++)
		{
		
			out.println(chase.getAccount(i).getAccountNumber() + ", " + chase.getAccount(i).getBalance() + ", " + chase.findCustomer(chase.getCustomer(i).getFirstName(), chase.getCustomer(i).getLastName()));
			
		}
		
		out.close();

	}

}
