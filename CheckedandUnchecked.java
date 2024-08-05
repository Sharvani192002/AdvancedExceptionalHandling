


class DataProcessingException extends Exception {
    public DataProcessingException(String message) {
        super(message);
    }
}

class DataValidationException extends RuntimeException {
    public DataValidationException(String message) {
        super(message);
    }
}

public class CheckedandUnchecked {

    
    public void processData(String data) throws DataProcessingException {
        if (data == null) {
            throw new DataProcessingException("Data cannot be null");
        }
        if (data.isEmpty()) {
            throw new DataValidationException("Data cannot be empty");
        }
        
        System.out.println("Data processed successfully: " + data);
    }

    public static void main(String[] args) {
        DataProcessor processor = new DataProcessor();
        String[] testData = {null, "", "ValidData"};

        for (String data : testData) {
            try {
                processor.processData(data);
            } catch (DataProcessingException e) {
                System.err.println("Checked exception caught: " + e.getMessage());
            } catch (DataValidationException e) {
                System.err.println("Unchecked exception caught: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Other exception caught: " + e.getMessage());
            }
        }
    }
}
