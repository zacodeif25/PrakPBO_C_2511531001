package shop.payment;

import shop.exception.InsufficientBalanceException;
import shop.exception.PaymentFailedException;

public class EWalletPayment implements RefundablePayment {
    private final String provider;
    private long balance;

    public EWalletPayment(String provider, long balance) {
        if (provider == null || provider.isBlank()) {
            throw new IllegalArgumentException("Provider must not be blank");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Balance must not be negative");
        }
        this.provider = provider;
        this.balance = balance;
    }

    @Override
    public String getName() { return "E-Wallet " + provider; }

    public long getBalance() { return balance; }


    @Override 
    public void pay(long amount) throws InsufficientBalanceException { 
        if (amount <= 0) { 
            throw new IllegalArgumentException("Amount must be positive"); 
         } 
        else if (amount > balance) { 
         throw new InsufficientBalanceException(amount,balance); 
        }
        else {
            balance -= amount;
        }
    }    

    @Override
    public boolean refund(long amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }
}
