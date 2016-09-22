/**
 * Created by nathansass on 9/20/16.
 */
public class RotatedArray {
    public static void main(String[] args) {
        int [] array = new int[] { 5,6,7,8,1,2,3,4 };

        System.out.println(new RotatedArray().findRotatedIndex_Int(array));
    }

    public int findRotatedIndex_Int(int[] arr) {
        int guessIndex = 0;
        int floorIndex = -1;
        int ceilingIndex = arr.length;
        int firstVal = arr[0];

        while (floorIndex + 1 < ceilingIndex) {
            int distance = ceilingIndex - floorIndex;
            int halfDistance = distance / 2;
            guessIndex = floorIndex + halfDistance;
            int guessValue = arr[guessIndex];


            //Case: rotation point is to the
            if ( guessValue > firstVal) {
                floorIndex = guessIndex;
            } else { // rotation point is to the right
                ceilingIndex = guessIndex;

            }
        }

        return guessIndex;
    }


}
