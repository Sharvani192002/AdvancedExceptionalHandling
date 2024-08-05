import process.Transaction;

public class CustomContext extends Exception {
    private String transactionId;

    public CustomContext(String message, String transactionId) {
        super(message);
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }
}


public void processTransaction(Transaction transaction) throws CustomContext {
    try {
        if (transaction.getAmount() <= 0) {
            throw new IllegalArgumentException("Transaction amount must be positive");
        }

    } catch (Exception e) {
        throw new CustomContext("Error processing transaction: " + e.getMessage(), transaction.getId());
    }
}
