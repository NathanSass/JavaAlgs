import java.util.*;

/**
 *   Notes: I began this problem with a nested loop approach where I would iterate through and check for mergeable
 *   meetings. I began to run into problems when merged meetings could still be merged again.
 *   I struggled through a couple of cases including considering some recursion.
 *   I ended up sorting the array by start date and then removing merged items from the initial array.
 *   This allowed me to both merge already merged items and keep my place in the array.
 */

public class HiCal {
    public static void main(String[] args) {
        ArrayList<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting(1,3));
        meetings.add(new Meeting(2,4));

        System.out.println(new HiCal().consolidate2(meetings).toString());

    }

    public ArrayList<Meeting> consolidate2(ArrayList<Meeting> meetingsArr) {
        Collections.sort(meetingsArr, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.startTime - o2.startTime;
            }
        });

        int i = 0;
        while (i < meetingsArr.size() - 1) {
            Meeting meeting1 = meetingsArr.get(i);
            Meeting meeting2 = meetingsArr.get(i + 1);

            if (meeting2.startTime <= meeting1.endTime) {
                // Do merge magic
                meetingsArr.remove(meeting1);
                meetingsArr.remove(meeting2);

                Meeting newMeeting = new Meeting();
                newMeeting.startTime = meeting1.startTime;
                newMeeting.endTime = Math.max(meeting1.endTime, meeting2.endTime);
                meetingsArr.add(i, newMeeting);
                // Doesn't incremenet so it will check the merged meeting with a new meeting object
            } else {
                i+= 1;
            }
        }
        return meetingsArr;
    }


    public static class Meeting{

        int startTime;
        int endTime;
        public Meeting() {}


        public Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime   = endTime;
        }

        public String toString() {
            return String.format("(%d, %d)", startTime, endTime);
        }
    }
}


