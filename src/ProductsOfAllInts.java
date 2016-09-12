import java.util.AbstractList;
import java.util.ArrayList;

/**
 * Created by nathansass on 9/10/16.
 */

public class ProductsOfAllInts {
    public static void main(String[] args) {
        int[] set1 = new int[]{1, 7, 3, 4};
        int[] set2 = new int[]{0, 7, 3, 4};
//        System.out.println(new ProductsOfAllInts().findProducts(set1));
        System.out.println(new ProductsOfAllInts().findProducts(set2));
    }

    public ArrayList<Integer> findProducts(int[] array) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int x = 0; x < array.length; x++) {
            ArrayList<Integer> refNumsArl = makeArl(array);
            refNumsArl.remove(x);

            int product = 1;
            for(int runner : refNumsArl) {
                product = product * runner;
            }
            result.add(product);
        }

        return result;
    }


    private ArrayList<Integer> makeArl(int[] array) {
        ArrayList<Integer> arl = new ArrayList<>();
        for(int x : array) {
            arl.add(x);
        }

        return arl;

    }

}
