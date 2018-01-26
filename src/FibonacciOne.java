import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciOne {

    public static void main(String[] args) {
        System.out.println(FibonacciOne.getItemInSequenceIterative(5));
//        System.out.println(FibonacciOne.getItemInSequenceRecursive(null, 2,5));
//        System.out.println(getItemInSequenceRecursiveSpace(new int[]{0, 1},2, 5));
//        System.out.println(fiboSimpleRecursive(5));
    }

    /**
     *
     * @param n nth item sequence in fibonacci
     * @return
     */
    public static int getItemInSequenceIterative(int n) {
        int[] sequence = new int[n];
        sequence[0] = 0;
        sequence[1] = 1;
        for (int i = 2; i < n; i++) {
            sequence[i] = sequence[i-1] + sequence[i-2];
        }

        return sequence[n-1];
    }

    private static int getItemInSequenceRecursiveSpace(int[] sequence, int i, int n) {
        if (i == n) {
            return sequence[1];
        } else {
            int prevLast = sequence[0];
            int prevSecondLast = sequence[1];
            return getItemInSequenceRecursiveSpace(
                    new int[]{prevSecondLast, prevLast + prevSecondLast},
                    i + 1,
                    n
            );
        }
    }

    private static int getItemInSequenceRecursive(int[] sequence, int i, int n) {
        if (sequence == null) {
            sequence = new int[5];
            sequence[0] = 0;
            sequence[1] = 1;
        }

        if (i == n) {
            return sequence[n - 1];
        } else {
            int elemOne = sequence[i - 1];
            int elemTwo = sequence[i - 2];
            sequence[i] =  elemOne + elemTwo;
           return getItemInSequenceRecursive(sequence, i+1, n);
        }
    }

    public static int fiboSimpleRecursive(int n) {
        if (n <= 1){
            return n;
        } else {
            return fiboSimpleRecursive(n - 1) + fiboSimpleRecursive(n - 2);
        }
    }


}


