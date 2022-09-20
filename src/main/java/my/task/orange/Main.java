package my.task.orange;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Meetings meet_1 = new Meetings(9,0,10,30);
        Meetings meet_2 = new Meetings(12,0,13,30);
        Meetings meet_3 = new Meetings(16,18);

        Meetings meet_4 = new Meetings(10,0,11,30);
        Meetings meet_5 = new Meetings(12,30,14,30);
        Meetings meet_6 = new Meetings(14,30,15,0);
        Meetings meet_7 = new Meetings(16,17);

        List<Meetings> meetingsList = new ArrayList<>();
        meetingsList.add(meet_1);
        meetingsList.add(meet_2);
        meetingsList.add(meet_4);
        meetingsList.add(meet_5);
        meetingsList.add(meet_6);
        meetingsList.add(meet_7);
        meetingsList.add(meet_3);

        Calendars calendar1 = new Calendars(9,0,19,55);
        Calendars calendar2 = new Calendars(10,0,18,30);

        List<Calendars> calendarsList = new ArrayList<>();
        calendarsList.add(calendar1);
        calendarsList.add(calendar2);

        FindFreeTerm freeTerm = new FindFreeTerm();
        freeTerm.coverageEmpty(meetingsList,calendarsList);
    }
}