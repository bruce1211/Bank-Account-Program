package edu.csulb.cecs274;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

   
public class BankCustomer {
    private static Bank mode;
    private String firstName;
    private String lastName;
   
    private static LinkedList<BankAccount> ownedAccounts = new LinkedList<BankAccount>();
   
    
    /**
     * Constructs a bank customer's full name
     * 
     * @param firstName    first name of the owner
     * @param lastName	   last name of the owner
     */
    
    
    public BankCustomer(String firstName, String lastName)
    {
        this.lastName = lastName;
        this.firstName = firstName;
    }
   
    
    /**
     * An array that stores all the accounts of a customer
     * 
     * @return
     */
    
    
    public ArrayList<Integer> listOfAccountNum()
    {
        ArrayList<Integer> list =new ArrayList<Integer>();
        ListIterator<BankAccount> iter = ownedAccounts.listIterator();
        while(iter.hasNext())
            list.add(iter.next().getAccountNumber());
        return list;
    }
   
    
    /**
     * Adds a bank account to an ownedAccounts linked list
     * 
     * @param account
     */
    
    
    public static void addAccount(BankAccount account)
    {
        ownedAccounts.add(account);
    }
   
    
    /**
     * Removes an account from an ownedAccounts linked list
     * 
     * @param account
     */
    
    
    public void removeAccount(BankAccount account)
    {
        ownedAccounts.remove(account);
    }
   
    
    /**
     * Returns the position of the ownedAccounts
     * 
     * @param accountNumber   position of the account number
     * @return
     */
    
    
    public static BankAccount getAccount(int accountNumber)
    {
        return ownedAccounts.get(accountNumber);
    }
    
    
    /**
     * Returns the first name of a customer
     * 
     * @return
     */
    
    
    public String getFirstName()
    {
        return firstName;
    }
   
    
    /**
     * Returns the last name of a customer
     * 
     * @return
     */
    
    
    public String getLastName()
    {
        return lastName;
    }
   
    
    /**
     * This method searched for an account number
     * 
     * @param userAccountNumber    the account number to be searched for
     * @return
     */
    
    
    public static int findAccount(int userAccountNumber)
    {
    	int index = 0;
        boolean found = false;
        ListIterator<BankAccount> iterAccount = ownedAccounts.listIterator();
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
     *Checks to see if an account exists 
     * 
     * @param desiredAccountNumber   account number being searched for if it exists
     * @return
     */
      
    
    public static boolean checkExistingAccount(int desiredAccountNumber)
    {
        boolean result = false;
        if (findAccount(desiredAccountNumber)==0)
            result = false;
        else
            result = true;
        return result;
    }
    
       
  
}
