package com.newwebservice;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "NewWebService")
public class NewWebService {

    @WebMethod(operationName = "calculate")
    public String calculate(
        @WebParam(name = "number") int number
    ) {
        StringBuilder result = new StringBuilder();
        
       
        int factorial = calculateFactorial(number);
        result.append("Factorial of ").append(number).append(": ").append(factorial).append("\n");
        result.append("||");
        
        double squareRoot = calculateSquareRoot(number);
        result.append("Square root of ").append(number).append(": ").append(squareRoot).append("\n");
        result.append("||");
        
        String evenOrOdd = isEvenOrOdd(number);
        result.append(number).append(" is ").append(evenOrOdd).append("\n");
        result.append("||");
        
        int gcd = calculateGCD(number);
        result.append("Greatest common divisor of ").append(number).append(": ").append(gcd).append("\n");
        
        return result.toString();
    }
    
    private int calculateFactorial(int number) {
        int factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
    
    private double calculateSquareRoot(int number) {
        return Math.sqrt(number);
    }
    
    private String isEvenOrOdd(int number) {
        if (number % 2 == 0) {
            return "even";
        } else {
            return "odd";
        }
    }
    
    private int calculateGCD(int number) {
        int gcd = 1;
        for (int i = 2; i <= number; i++) {
            if (number % i == 0 && gcd % i == 0) {
                gcd *= i;
            }
        }
        return gcd;
    }
}
