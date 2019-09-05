package pl.martajastrzabek.taxcalculator.service;

public class TaxCalculatorService {
    private static final int BASIC_TAX_RATE = 18;
    private static final int HIGHER_TAX_RATE = 32;
    private static final int BASIC_INCOME_LIMIT = 85528;
    private static final int TAX_FREE_ALLOWANCE = 3091;
    private static final double BASIC_TAX_DEDUCTION = 556.02;
    private static final double HIGHER_TAX_BASE = 14839.02;

    public double calculateTax(double income) {
        double tax = 0;
        if (income < 0) {
            throw new IllegalArgumentException("Dochód nie może być mniejszy niż 0!");
        }

        if (income <= TAX_FREE_ALLOWANCE) {
            tax = 0;
        } else if (income <= BASIC_INCOME_LIMIT) {
            tax = (income * BASIC_TAX_RATE) / 100 - BASIC_TAX_DEDUCTION;
        } else {
            tax = HIGHER_TAX_BASE + ((income - BASIC_INCOME_LIMIT) * HIGHER_TAX_RATE / 100);
        }

        double roundedTax = Math.round(tax);
        return roundedTax;
    }
}
