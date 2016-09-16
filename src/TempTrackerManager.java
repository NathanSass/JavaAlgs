import java.util.ArrayList;

/**
 *  just-in-time vs ahead-of-time. Or lazy vs eager
 *  Used ahead-of-time
 */
public class TempTrackerManager {

    public static void main(String[] args) {
        TempTracker tempTracker = new TempTrackerManager().new TempTracker();
        tempTracker.insert(72);


    }

    public class TempTracker {
        private ArrayList<Integer> temperatures;
        private int[] occurences = new int[111];
        private int maxOccurrences = 0;
        private int mode = 0;
        private Integer max;
        private Integer min;

        private int recordCount;
        private double tempTotal;
        private double mean;

        public TempTracker() {
            this.temperatures = new ArrayList<>();
            this.recordCount = 0;
            this.tempTotal = 0.0;
        }

        public void insert(int temp) {
            // Mode
            occurences[temp] ++;
            if(occurences[temp] > maxOccurrences) {
                mode = temp;
                maxOccurrences = occurences[temp];
            }

            if (this.max == null) {
                this.max = temp;
            }
            if (this.min == null) {
                this.min = temp;
            }
            this.max = Math.max(temp, this.max);
            this.min = Math.min(temp, this.min);

            // Mean
            this.recordCount += 1;
            this.tempTotal += temp;
            this.mean = tempTotal / recordCount;

            temperatures.add(temp);
        }

        public int getMax() {
            return max;
        }

        public int getMin() {
            return min;
        }

        public double getMean() {
            return mean;
        }

        public int getMode() {
            return 0;
        }
    }
}
