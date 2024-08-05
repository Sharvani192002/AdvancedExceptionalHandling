public class RethrowingExceptions {
    public static double performDivision(int numerator,int denominator) throws ArithmeticException{
        if(denominator==0){
            throw new ArithmeticException("Denominator cannot be zero");
        }
        return(double) numerator/denominator;
    }
    public static double calculate(int numerator,int denominator) throws ArithmeticException{
        try{
            return performDivision(numerator,denominator);
        }catch (ArithmeticException e){
            throw new ArithmeticException("Error in calculation: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int numerator =10;
        int denominator=0;
        try{
            double result=calculate(numerator,denominator);
            System.out.println("Result: " + result);
        }catch(ArithmeticException e){
            System.out.println("Error Ocuured: "+ e.getMessage());
        }
    }

}
