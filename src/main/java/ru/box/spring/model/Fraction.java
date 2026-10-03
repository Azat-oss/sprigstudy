package ru.box.spring.model;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator==0){
            throw new IllegalArgumentException("Знаменатель не может быть равен 0");
        }

        if (numerator>denominator) {
            throw new IllegalArgumentException("Дробь не правильная: ("+numerator+") больше ("+denominator+")");
        }
        this.numerator = numerator;
        this.denominator = denominator;

    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
