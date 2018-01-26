import java.util.HashMap;
import java.util.Map;

public class FiboBest {
    // 1,1,2,3,5
    public static void main(String[] args) {
        FiboBest fiboBest = new FiboBest();
        System.out.println(fiboBest.fiboTopDown(5));
        System.out.println(fiboBest.fiboBottomUp(5));
    }

    private Map<Integer, Integer> memo = new HashMap<>();

    private int fiboTopDown(int n) {
        if (n <= 1) {
            return n;
        } else {
            if (memo.containsKey(n)) {
                return memo.get(n);
            } else {
                int result = fiboTopDown(n - 1) + fiboTopDown(n - 2);
                memo.put(n, result);
                return result;
            }
        }
    }

    private int fiboBottomUp(int n) {
        if (n <= 1) {
            return n;
        }

        int prevPrev = 0;
        int prev = 1;
        int current = 0;

        for (int i = 1; i < n;i++) {
            current = prev + prevPrev;
            prevPrev = prev;
            prev = current;
        }

        return current;
    }
}
