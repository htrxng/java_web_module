public class Calculator {
    public double plus(Double a, Double b){
        return a + b;
    }

    public double minus(Double a, Double b){
        return a - b;
    }

     public double multiplied(Double a, Double b){
        return a * b;
    }

    public double divide(Double a, Double b) throws ArithmeticException {
        double result = 0;
        if ( b == 0) {
            throw new ArithmeticException("Lỗi chia cho 0");
        } else {
            result = a / b;
        }
        return result;
    }
}
