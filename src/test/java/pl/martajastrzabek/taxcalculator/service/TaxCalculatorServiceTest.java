package pl.martajastrzabek.taxcalculator.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class TaxCalculatorServiceTest {

    private TaxCalculatorService underTest;

    @BeforeEach
    void setUp() {
        underTest = new TaxCalculatorService();
    }

    @Test
    void whenIncomeIs85528_taxShouldBe14839() {
        //given
        double income = 85528;
        double expectedResult = 14839;

        //when
        double result = underTest.calculateTax(income);

        //then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void whenIncomeIs124657_taxShouldBe27360() {
        //given
        double income = 124657;
        double expectedResult = 27360;

        //when
        double result = underTest.calculateTax(income);

        //then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void whenIncomeIs3091_taxShouldBeZero() {
        //given
        double income = 3091;
        double expectedResult = 0;

        //when
        double result = underTest.calculateTax(income);

        //then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void whenIncomeIsNegative_shouldThrowException() {
        //given
        double income = -457;

        //when
        Executable methodCall = () -> underTest.calculateTax(income);

        //then
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, methodCall);

    }
}
