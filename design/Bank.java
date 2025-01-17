package design;

// https://leetcode.com/problems/simple-bank-system/description/?envType=problem-list-v2&envId=mbnk3qwv
public class Bank {

    private long accountBalance[];

    public Bank(long[] balance) {
        this.accountBalance=balance;    
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(isValidAccount(1) && isValidAccount(account2))
        {
            if(this.accountBalance[account1-1]<money)
                return false;
            this.accountBalance[account2-1]+=money;
            this.accountBalance[account1-1]-=money;
            return true;
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(isValidAccount(account))
        {
            this.accountBalance[account-1]=money;
            return true;
        }
        return false;
    }
    
    public boolean withdraw(int account, long money) {
        if(isValidAccount(account))
        {
            if(this.accountBalance[account-1]<money)
            return false;
            this.accountBalance[account-1]-=money;
            return true;
        }
        return false;
    }

    boolean isValidAccount(int account)
    {
        if(account>=1 || account>accountBalance.length)
            return false;
        return true;
    }

    public static void main(String[] args) {
        Bank bank=new Bank(new long[]{10,100,20,50,30,90,11,23,11,23});
        System.out.println(bank.deposit(10, 10));
    }
}
