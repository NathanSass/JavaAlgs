import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 *
 * Go through each coin in denom (baseCoin)
 *  amount
 *  Result Arr
 *  currentCoinCombo init with base coin
 *  int currentRunnerCoinIndex
 *
 *  While ( total(currentCoinCombo) < amount )
 *      if total(currentCoinCombo) + runnerCoin <= amount
 *          add the runnerCoin to the currentCoinCombo
 *          if amount is reached in the currentCoinCombo
 *              add the currentCoinCombo to the resultArr
 *              re-initialize a currentCoinCombo with the baseCoin
 *      else
 *          increment the runner coin to a small value
 *
 *
 *  Organize each combination in result arr by asc or dsc
 *  Go through the result arr and remove duplicate values
 *
 *
 **/
public class Coins {
    public static void main(String[] args) {
        System.out.println("TRAp");
        ArrayList<Integer> denominations = new ArrayList<>(Arrays.asList(1,3,5));
        int amount = 5;
        System.out.println(new Coins().getAllCombos(denominations, amount));

    }

    public int getAllCombos(ArrayList<Integer> denominations, int amount) {
        // order from largest to smallest
        Collections.sort(denominations);
        Collections.reverse(denominations);

        ArrayList<ArrayList> results = new ArrayList<>();

        for(Integer baseCoin : denominations) {
            ArrayList<Integer> currentCoinCombo = new ArrayList<>();
            currentCoinCombo.add(baseCoin);

            int i = 0;
            while ( (total(currentCoinCombo) <= amount) && ( i < denominations.size()) ) {
                int runnerCoin = denominations.get(i);
                if (total(currentCoinCombo) + runnerCoin <= amount) {

                    currentCoinCombo.add(runnerCoin);
                    if (total(currentCoinCombo) == amount) {
                        Collections.sort(currentCoinCombo);
                        if (!results.contains(currentCoinCombo)) {
                            results.add(currentCoinCombo);
                        }
                        currentCoinCombo = new ArrayList<>();
                        currentCoinCombo.add(baseCoin);
                        i += 1;
                    }
                } else {
                    i += 1;
                }

            }
        }

        Collections.sort(denominations);
        for(Integer baseCoin : denominations) {
            ArrayList<Integer> currentCoinCombo = new ArrayList<>();
            currentCoinCombo.add(baseCoin);

            int i = 0;
            while ( (total(currentCoinCombo) <= amount) && ( i < denominations.size()) ) {
                int runnerCoin = denominations.get(i);
                if (total(currentCoinCombo) + runnerCoin <= amount) {
                    currentCoinCombo.add(runnerCoin);
                    if (total(currentCoinCombo) == amount) {
                        Collections.sort(currentCoinCombo);
                        if (!results.contains(currentCoinCombo)) {
                            results.add(currentCoinCombo);
                        }
                        currentCoinCombo = new ArrayList<>();
                        currentCoinCombo.add(baseCoin);
                        i += 1;
                    }
                } else {
                    i += 1;
                }

            }
        }

        return results.size();

    }



    private int total(ArrayList<Integer> arr) {
        int total = 0;
        for(Integer item : arr) {
            total += item;
        }
        return total;
    }
}

/*
    private ArrayList<ArrayList> condenseArray(ArrayList<ArrayList> arr) {
        ArrayList<ArrayList> result = arr;


        for(int i = 0; i < arr.size(); i++) {
            boolean unique = true;
            ArrayList<Integer> base = arr.get(i);
            mainLoop:
            for(int x = 0; x < arr.size(); x++) {
                if(x == i) {continue;}
                ArrayList<Integer> runner = arr.get(x);
                if(!(base.size() == runner.size())) {
                    continue;
                }

                for (int z = 0; z < base.size(); z++) {
                    if (base.get(z) != runner.get(z)) {
                        continue mainLoop;
                    }

                    arr.remove(base);
                    boolean wow = arr.contains(base);
                    unique = false;
                }
                arr.remove(i);
                arr.add(i, new ArrayList(Arrays.asList(0)));
                result.remove(base);

            }

        }

        return result;
    }
 */
