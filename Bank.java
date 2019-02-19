package edu.csulb.cecs274;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Bank {
   
    private String bankName;

    private LinkedList<BankAccount> accounts = new LinkedList<BankAccount>();

    private LinkedList<BankCustomer> customers = new LinkedList<BankCustomer>();
    
   
    /**
     * Constructs a bank's name
     * 
     * @param s   String of the bank's name
     */
    
    
    public Bank(String s)
    {
        this.bankName = "Chase";
    }
   
    
    /**
     * Returns the name of the Bank
     * 
     * @param bankName    Accepts a String for a bank's name
     * @return
     */
    
     
    public String getBankName(String bankName)
    {
        return bankName;
    }

    
    /**
     * Adds an account to the linked list
     * 
     * @param account     A BankAccount object to be added to the list
     */
    
    
    public void addAccount(BankAccount account)
    {
        accounts.add(account);
    }
   
   
    
    /**
     * Adds a customer to the linked list
     * 
     * @param customer     A BankCustomer object to be added to the list
     */
    
    
    public void addCustomer(BankCustomer customer)
    {
        customers.add(customer);
    }
   
    /**
     * Removes an account from the linked list
     * 
     * @param account     A BankAccount object 
     */
    
    
    public void removeAccount(BankAccount account)
    {
        accounts.remove(account);
    }
       
    
    /**
     * Removes a customer from the linked list
     * 
     * @param customer     A BankCustomer object 
     */
    
    
    public void removeCustomer(BankCustomer customer)
    {
        customers.remove(customer);
    }
   
    
    /**
     * Returns an account number at a specified index
     * 
     * @param accountNumber     Type integer to specify the index
     */
    
    
    public BankAccount getAccount(int accountNumber)
    {
        return accounts.get(accountNumber);
    }
    
    
    /**
     * Returns the customer's index
     * 
     * @param customAccountNumber    Type integer to specify the index
     */

    
    public BankCustomer getCustomer(int customerAccountNumber)
    {
        return customers.get(customerAccountNumber);
    }
    
    
    /**
     * Finds an account number and returns it's position in the linked list
     * 
     * @param userAccountNumber     Account number that is being searched for
     */
    
    
    public int findAccount(int userAccountNumber)
    {
    	int index = 0;
        boolean found = false;
        ListIterator<BankAccount> iterAccount = accounts.listIterator();
        while(iterAccount.hasNext() && !found)
        {
        	BankAccount controlledIterAccount = iterAccount.next();
        	if(controlledIterAccount.getAccountNumber() == userAccountNumber)
	        	found=true;
        	index++;
        }
        
        if(index<0)
        {
        	throw new NoSuchElementException("There aren't any accounts");
            
        }
 
        return index;
    }
   
    
     /**
      * Finds a customer and returns its position
      * 
      * @param firstNameToFind     First name that is being searched for
      * @param lastNameToFind	   Last name that is being searched for
      * @return
      */
    
    
    public int findCustomer(String firstNameToFind, String lastNameToFind)
    {
        int index = 0;
        boolean found= false;
        ListIterator<BankCustomer> iterCustomer = customers.listIterator();
        while(iterCustomer.hasNext() && !found)
        {
            BankCustomer controlledIter = iterCustomer.next();
            if(controlledIter.getFirstName().equals(firstNameToFind) && controlledIter.getLastName().equals(lastNameToFind))
                found=true;
            index++;
           
            
        }
        if(index<0)
            throw new NoSuchElementException();
        if(!found)
        {
            index = -1;
        }
        return index;
    }

          
    public boolean isInt(String answer)
    {
        boolean result = false;
        String input = answer;
        try {
            Integer.parseInt(input);
            result= true;
        }
        catch(NumberFormatException nFE) {
            result = false;
        }
        return result;
    }
    
    
    /**
     * Checks to see if there is another account that exists
     * 
     * @param desiredAccountNumber     The account number that will be checked if it exists
     * @return
     */
    
   
    public boolean checkExistingAccount(int desiredAccountNumber)
    {
        boolean result = false;
        if (findAccount(desiredAccountNumber)==0)
            result = true;
        else
            result = false;
        return result;
    }
    
    
    /**
     * Checks to see if a customer exists
     * 
     * @param firstNameToFind     First name to check if exists
     * @param lastNameToFind      Last name to check if exists
     * @return
     */
    public boolean checkExistingCustomer(String firstNameToFind, String lastNameToFind)
    {
    	  int index = 0;
          boolean found= false;
          ListIterator<BankCustomer> iterCustomer = customers.listIterator();
          while(iterCustomer.hasNext() && !found)
          {
              BankCustomer controlledIter = iterCustomer.next();
              if(controlledIter.getFirstName().equals(firstNameToFind) && controlledIter.getLastName().equals(lastNameToFind))
                  found=true;
          }
                             
          return found;
    }
    
    /**
     * Calculates the total balance of all accounts
     * 
     * @return      total of all numbers
     */
    
    public double totalBalance()
    {
    	double total = 0;
    	ListIterator<BankAccount> jay = accounts.listIterator();
    	while(jay.hasNext())
    	{
    		BankAccount controll = jay.next();
    		controll.getBalance();
    		total = total + controll.getBalance();
    	}
    	
    	return total;
    }
    
    
   
  
}
