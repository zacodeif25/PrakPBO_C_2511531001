package shop.payment;

public class BankTransferPayment implements PaymentMethod {
    private final String bankName;

    public BankTransferPayment(String bankName) {
        if (bankName == null || bankName.isBlank()) {
            throw new IllegalArgumentException("Bank name must not be blank");
        }
        this.bankName = bankName;
    }

    @Override
    public String getName() { return "Transfer " + bankName; }

    @Override
    public boolean pay(long amount) {
        return amount > 0; // simulation
    }
}
