import java.util.*;

/**
 *   [(0, 1), (3, 5), (4, 8), (10, 12), (9, 10)]
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


