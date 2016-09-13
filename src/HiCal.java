import java.util.ArrayList;

/**
 *   [(0, 1), (3, 5), (4, 8), (10, 12), (9, 10)]
 */

public class HiCal {
    public static void main(String[] args) {
        ArrayList<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting(0,2));
        meetings.add(new Meeting(1,4));
        meetings.add(new Meeting(7,10));
        meetings.add(new Meeting(6,8));
        meetings.add(new Meeting(1,5));
//        meetings.add(new Meeting(2,3));


        System.out.println(new HiCal().consolidate(meetings).toString());

    }


    public ArrayList<Meeting> consolidate(ArrayList<Meeting> meetingsArr) {
        ArrayList<Meeting> meetings = meetingsArr;

        ArrayList<Meeting> consolidatedMeetings = new ArrayList<>();
        ArrayList<Meeting> discaredMeetings = new ArrayList<>();

        for(int i = 0; i < meetings.size(); i++) {
            Meeting currentMeeting = meetings.get(i);
            // Check through existing start values to see if current start value is greater than an
            // existing start value and less than the existing end value
                // if true: Get the max and make it the new end value
                    // Then do the check for this object on the array
            for (int x = 0; x < meetings.size(); x++) {
                if(i == x) {continue; }

                Meeting meeting = meetings.get(x);
                if ( (meeting.startTime >= currentMeeting.startTime) &&
                        (meeting.startTime <= currentMeeting.endTime) ) { // will have overlap

                    discaredMeetings.add(currentMeeting);
                    discaredMeetings.add(meeting);

                    Meeting combinedMeeting = new Meeting();
                    combinedMeeting.startTime = Math.min(currentMeeting.startTime, meeting.startTime);
                    combinedMeeting.endTime = Math.max(currentMeeting.endTime, meeting.endTime);
                    consolidatedMeetings.add(i, combinedMeeting);
                } else {
                    if (!discaredMeetings.contains(currentMeeting) && !consolidatedMeetings.contains(currentMeeting)) {
                        consolidatedMeetings.add(currentMeeting);
                    }
                }
            }

        }

        for (Meeting discarded : discaredMeetings) {
            if (consolidatedMeetings.contains(discarded)) {
                consolidatedMeetings.remove(discarded);
            }
        }



        return consolidatedMeetings;

    }

    public static class Meeting {

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


