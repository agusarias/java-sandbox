package org.a2.sandbox.Problems.NextDayBits;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM

import java.util.ArrayList;
import java.util.List;

// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days) {
        List<Integer> result = new ArrayList<>();
        for (Integer state : states) {
            result.add(state);
        }
        // WRITE YOUR CODE HERE
        while (days-- > 0) {
            result = earthRotate(result);
        }

        return result;
    }
    // METHOD SIGNATURE ENDS

    private List<Integer> earthRotate(List<Integer> today) {
        List<Integer> tomorrow = new ArrayList<>();
        for (int i = 0; i < today.size(); i++) {
            int tomorrowState = calculateTomorrowState(today, i);
            tomorrow.add(i, tomorrowState);
        }
        return tomorrow;
    }

    private int calculateTomorrowState(List<Integer> today, int index) {
        Integer nehibhourLeft = index == 0 ?
                0 : today.get(index - 1);
        Integer nehibhourRight = index == 7 ?
                0 : today.get(index + 1);
        return nehibhourLeft == nehibhourRight ? 0 : 1;
    }
}