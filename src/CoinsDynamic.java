/**
 * Created by nathansass on 9/14/16.
 */
public class CoinsDynamic {
    public static void main(String[] args) {

        int amount = 4;
        int[] denom = {1,2,3};

        System.out.println(new CoinsDynamic().changePossibilitiesBottomUp(amount, denom));
    }

    public int changePossibilitiesBottomUp(int amount, int[] denominations) {
        int[] waysOfDoingNCents = new int[amount+1]; // array of zeros from 0..amount
        waysOfDoingNCents[0] = 1;

        for (int coin : denominations) {
            for (int higherAmount = coin; higherAmount < amount + 1; higherAmount++) {
                int higherAmountRemainder = higherAmount - coin;
                waysOfDoingNCents[higherAmount] += waysOfDoingNCents[higherAmountRemainder];
            }
        }

        return waysOfDoingNCents[amount];
    }
}
