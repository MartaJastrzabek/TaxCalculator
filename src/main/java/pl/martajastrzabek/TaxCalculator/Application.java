package pl.martajastrzabek.TaxCalculator;

import pl.martajastrzabek.TaxCalculator.service.TaxCalculatorService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        TaxCalculatorService calculateTax = new TaxCalculatorService();
        try {
            double income = getIncome();
            double tax = calculateTax.calculateTax(income);
            System.out.println("Należny podatek: " + tax + " zł");
        } catch (InputMismatchException ex) {
            System.out.println("Podano nieprawidłową wartość!");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static double getIncome() throws InputMismatchException {
        Scanner in = new Scanner(System.in);

        System.out.println("Podaj swój dochód: ");
        double income = in.nextDouble();
        in.nextLine();

        in.close();

        return income;
    }
}
