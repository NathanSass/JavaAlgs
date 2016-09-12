import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 * Given an arrayOfInts, find the highestProduct you can get from three of the integers.
 * The input arrayOfInts will always have at least three integers.
 */
public class HighestProduct {
    public static void main(String[] args) {
//        int[] swag = {1, 2, 3, 4};
//        int[] swag = {4, 3, 2 ,1};
        int[] swag = {-10, -10,1,3,2};
        System.out.println("Max Product: ");
//        System.out.println(new HighestProduct().getHighestProduct_BRUTE(swag));
        System.out.println(new HighestProduct().getHighestProduct_sort(swag));
    }


    public int getHighestProduct_sort(int[] arrInts) {
        int currentMax = Math.max(arrInts[0],arrInts[1]);
        int currentMin = Math.min(arrInts[0], arrInts[1]);

        int highestProductOfTwo = arrInts[0] * arrInts[1];
        int lowestProductOfTwo = arrInts[0] * arrInts[1];

        int highestProductOfThree = arrInts[0] * arrInts[1] * arrInts[2];

        for(int num : arrInts) {
            highestProductOfThree = Math.max(Math.max(highestProductOfThree, num * highestProductOfTwo), lowestProductOfTwo * num);

            highestProductOfTwo = Math.max(highestProductOfTwo, Math.max(currentMin * num, currentMax * num));
            lowestProductOfTwo = Math.min(lowestProductOfTwo, Math.min(currentMin * num, currentMax * num));

            currentMin = Math.min(currentMin, num);
            currentMax = Math.max(currentMax, num);



        }

        return highestProductOfThree;
    }

    public int[] reverseOrder(int[] arrInts) {
        Float[] sorted = new Float[arrInts.length];
        int[] sortedInt = new int[arrInts.length];

        for (int i = 0; i < arrInts.length; i++) {
            sorted[i] = (float) arrInts[i];
        }

        Arrays.sort(sorted, Collections.reverseOrder());

        for (int i = 0; i < sorted.length; i ++) {
            sortedInt[i] = Math.round(sorted[i]);
        }

        return sortedInt;
    }

    public int getHighestProduct_BRUTE(int[] arrInts) {

        int maxProduct= 0;

        for (int a = 0; a < arrInts.length; a++) {
            for (int b = 0; b < arrInts.length; b++) {
                for (int c = 0; c < arrInts.length; c++) {
                    if ((a == b) || (b == c) || (a ==c)) {
                        continue;
                    }
                    int first = arrInts[a];
                    int second = arrInts[b];
                    int third = arrInts[c];
                    int product = first * second * third;
                    maxProduct = Math.max(maxProduct, product);

                }
            }

        }

        return maxProduct;
    }
}
