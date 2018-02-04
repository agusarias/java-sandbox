package org.a2.sandbox.Problems.SmallestDiference;

import java.util.ArrayList;
import java.util.Comparator;

public class Solution {

    public Integer solveSlow(ArrayList<Integer> first, ArrayList<Integer> second) {
        Integer minDiff = Integer.MAX_VALUE;

        for (Integer aNumber : first) {
            for (Integer anotherNumer : second) {
                Integer diff = Math.abs(aNumber - anotherNumer);
                if (minDiff > diff) {
                    minDiff = diff;
                }
            }
        }

        return minDiff;
    }

    public Integer solveFast(ArrayList<Integer> first, ArrayList<Integer> second) {
        Integer minDiff = Integer.MAX_VALUE;

        first.sort(Comparator.comparingInt(o -> o));
        second.sort(Comparator.comparingInt(o -> o));

        Integer indexFirst = 0,
                indexSecond = 0,
                sizeFirst = first.size(),
                sizeSecond = second.size();

        while (indexFirst + indexSecond < sizeSecond + sizeFirst - 2) {
            Integer valueFirst = first.get(indexFirst);
            Integer valueSecond = second.get(indexSecond);
            Integer diff = Math.abs(valueFirst - valueSecond);
            if (minDiff > diff) {
                minDiff = diff;
            }
            if ((valueFirst > valueSecond && indexSecond != sizeFirst - 1)
                    || indexFirst == sizeFirst - 1) {
                indexSecond = Math.min(indexSecond + 1, sizeSecond - 1);
            } else {
                indexFirst = Math.min(indexFirst + 1, sizeFirst - 1);
            }
        }

        return minDiff;
    }

}
