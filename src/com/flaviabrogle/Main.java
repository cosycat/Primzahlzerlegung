package com.flaviabrogle;

import java.util.ArrayList;

public class Main {
    
    static ArrayList<Integer> primeNumbers = new ArrayList<>();
    
    static int numberToCalculate = 1228;

    public static void main(String[] args) {
        
        if (args.length > 0) {
            try {
                numberToCalculate = Integer.parseInt(args[0]);
            } catch (Exception e) {
    
            }
        }
        
        
        getAllPrimeNumbersUpTo(numberToCalculate);
        
        System.out.println("Prime Numbers: " + primeNumbers);
    
        System.out.println("Teiler: " + getAllTeilerFrom(numberToCalculate));
        
    }
    
    private static void getAllPrimeNumbersUpTo(int numberToCalculate) {
        primeNumbers.add(2);
        for (int i = 3; i <= numberToCalculate; i++) {
            boolean isPrime = true;
            for (int num : primeNumbers) {
                if (i % num == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                primeNumbers.add(i);
            }
        }
    }
    
    private static ArrayList<Integer> getAllTeilerFrom(int numberToCalculate) {
        ArrayList<Integer> teiler = new ArrayList<>();
        for (int i = 0; i < primeNumbers.size(); i++) {
            if (numberToCalculate % primeNumbers.get(i) == 0) {
                teiler.add(primeNumbers.get(i));
                numberToCalculate = numberToCalculate / primeNumbers.get(i);
                i--;
            }
        }
        return teiler;
    }
}
