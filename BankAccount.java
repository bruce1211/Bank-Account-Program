package edu.csulb.cecs274;

public class BankAccount
{
    private int accountNumber;
    private double balance;
  
    /**
     * Constructs a bank's account number and initial balance
     * 
     * @param accountNumber		Owner's account number
     * @param initialBalance	Initial balance of the account
     */
    
    
    public BankAccount(int accountNumber, double initialBalance)
    {
        this.accountNumber= accountNumber;
        balance=initialBalance;
    }

    
    /**
     * Returns the account number
     * 
     * @return    returns account number
     */
    
    
    public int getAccountNumber()
    {
        return accountNumber;
    }

    
    /**
     * Sets the account number
     * 
     * @param accountNumber     account number to be set
     */
    
    
    public void setAccountNumber(int accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    
    /**
     * Returns the balance
     * 
     * @return	  balance of the account
     */
    
    
    public double getBalance()
    {
        return balance;
    }

    
    /**
     * Deposits an amount in the bank account
     * 
     * @param amount      value that is deposited
     * @return
     */
    
    
    public boolean deposit(double amount)
    {
        boolean succeeded=false;
        if(amount>0)
        {
            balance+=amount;
            succeeded= true;
        }

        return succeeded;

    }   


    
    /**
     * Withdraws an amount of money from a bank account
     * 
     * @param amount    value to be withdrawn from the bank account
     * @return
     */
    
    
    public boolean withdraw(double amount)
    {
        boolean succeeded=false;
        if(amount>0)
        {
            balance-=amount;
            succeeded= true;
        }
        if(amount>balance)
            throw new IllegalArgumentException("You have asked to Withdraw more money than is currently in your Account");
        return succeeded;
    }

    
    /**
     * Transfers an amount of money from an account to another account 
     * that is owned be one customer
     * 
     * @param amount          value to be transferred
     * @param otherAccount    account that gains the amount transferred
     * @return
     */
    
    
    public boolean transferTo(double amount, BankAccount otherAccount)
    {
        boolean transferSucceeded=false; 
        if(this.balance >= amount)
        {
            this.balance-=amount;
            otherAccount.balance+=amount;
            transferSucceeded=true;

        }
        if(amount>balance)
            throw new IllegalArgumentException("You have asked to Transfer more money than is currently in your Account");
        return transferSucceeded;
    }
}

