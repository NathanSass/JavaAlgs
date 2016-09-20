/**
 * Created by nathansass on 9/20/16.
 */
public class BinarySearchArr {
    public static void main(String[] args) {

        int [] array = new int[100];
        for (int a = 0; a < array.length; a++) {
            array[a] = a;
        }
        System.out.println(new BinarySearchArr().binarySearch(60, array));
    }

    public boolean binarySearch(int target, int[] nums) {

        int floorIndex = -1;
        int ceilingIndex = nums.length;

        while (floorIndex + 1 < ceilingIndex) {

            int distance = ceilingIndex - floorIndex;
            int halfDistance = distance / 2;

            int guessIndex = floorIndex + halfDistance;

            int guessValue = nums[guessIndex];

            if (guessValue == target) {
                return true;
            }

            if (guessValue > target) {
                ceilingIndex = guessIndex;
            } else {
                floorIndex = guessIndex;
            }
        }

        return false;

    }
}
