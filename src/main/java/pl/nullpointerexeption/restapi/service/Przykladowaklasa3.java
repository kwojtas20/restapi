package pl.nullpointerexeption.restapi.service;

import java.util.function.Function;

//Użycie wyrażenia lambda
class Main {
    public static void main(String[] args) {
        printResult("Liczba do potęgi 2", 2, x -> x * x); // 1
        printResult("Liczba do potęgi 3", 2, x -> x * x * x);
        printResult("Liczba podzielona przez 2", 2, x -> x / 2);
        printResult("Liczba pomnożona przez 3", 2, x -> x * 3);
    }

    private static void printResult(String operation, Integer x, Function<Integer, Integer> fun) { // 2
        System.out.println("Ta metoda drukuje wynik wyrażenia lambda: ");
        System.out.println(operation + ": " + fun.apply(x)); // 3
        System.out.println("------------------------------------------");
    }
}

class Main1 {
    public static void main(String[] args) {
        Function<Integer, Integer> fun = x -> x * x;
        System.out.println(fun.apply(2)); //
    }


}
