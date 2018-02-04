package org.a2.sandbox.Problems.GreatestCommonDivisor;

import java.util.ArrayList;
import java.util.Iterator;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class GCD {
    private ArrayList<Dividend> possible = new ArrayList<>();

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int generalizedGCD(int num, int[] arr) {

        if (num == 0) {
            return 0;
        }

        // Starting point
        calculateDividends(arr[0]);

        for (int index = 1; index < num; index++) {
            findPossibleDividends(arr[index]);
        }

        Integer max = 1;
        for (Dividend dividend :
                this.possible) {
            if (dividend.value > max) {
                max = dividend.value;
            }
        }
        ;
        return max;
    }
    // METHOD SIGNATURE ENDS

    private void findPossibleDividends(int number) {
        Iterator<Dividend> iterator = this.possible.iterator();
        while (iterator.hasNext()) {
            Dividend dividend = iterator.next();
            if (!isDividend(number, dividend.value)) {
                removePossibleDividend(iterator, dividend);
            }
        }
    }

    private void calculateDividends(int number) {
        for (int maybeDividend = 2; maybeDividend <= number / 2; maybeDividend++) {
            if (isDividend(number, maybeDividend)) {
                addPossibleDividend(maybeDividend);
            }
        }
        addPossibleDividend(number);
    }

    private boolean isDividend(int number, int maybeDividend) {
        return maybeDividend != 0 && number % maybeDividend == 0;
    }

    private void addPossibleDividend(Integer number) {
        possible.add(new Dividend(number));
    }

    private void removePossibleDividend(Iterator<Dividend> iterator, Dividend dividend) {
        iterator.remove();
    }

    class Dividend {
        Integer value;

        public Dividend(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value.toString();
        }
    }

}