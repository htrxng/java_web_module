public class Calculator {
    public double plus(Double a, Double b) throws NumberFormatException {
        double result = 0;
        if (a == null || b == null) {
            throw new NumberFormatException("Lỗi dữ liệu null");
        } else {
            result = a + b;
        }
        return result;
    }

    public double minus(Double a, Double b) throws NumberFormatException{
        double result = 0;
        if (a == null || b == null) {
            throw new NumberFormatException("Lỗi dữ liệu null");
        } else {
            result = a - b;
        }
        return result;
    }

    public double multiplied(Double a, Double b)throws NumberFormatException {
        double result = 0;
        if (a == null || b == null) {
            throw new NumberFormatException("Lỗi dữ liệu null");
        } else {
            result = a * b;
        }
        return result;
    }

    public double divide(Double a, Double b) throws NumberFormatException, ArithmeticException {
        double result = 0;
        if ( a== null || b == null) {
            throw new NumberFormatException("Lỗi dữ liệu null");
        } else if ( b == 0) {
            throw new ArithmeticException("Lỗi chia cho 0");
        } else {
            result = a / b;
        }
        return result;
    }
}
