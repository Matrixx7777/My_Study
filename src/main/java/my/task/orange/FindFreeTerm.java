package my.task.orange;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class FindFreeTerm {

    private final Map<LocalTime, LocalTime> cover = new HashMap<>();

    public void coverageEmpty(List<Meetings> meetingsList, List<Calendars> calendarsList) {

        int startHourInCalendar = 0; int startMinuteInCalendar = 0;
        int endHourInCalendar = 0; int endMinuteInCalendar = 0;

        int getStartHourMet; int getStartMinuteMet;
        int getEndHourMet; int getEndMinuteMet;
        int meeting_durationList_1;

        for (Meetings meetings : meetingsList) {
            getStartHourMet = meetings.getStartHour();
            getStartMinuteMet = meetings.getStartMinute();
            getEndHourMet = meetings.getEndHour();
            getEndMinuteMet = meetings.getEndMinute();
            meeting_durationList_1 = (getEndHourMet - getStartHourMet) * 60 + getStartMinuteMet - getEndMinuteMet;

            if (getEndHourMet <= endHourInCalendar || getStartHourMet == startHourInCalendar && getStartMinuteMet >= startMinuteInCalendar || meeting_durationList_1 >= 30) {
                getStartHourMet = meetings.getStartHour();
                getStartMinuteMet = meetings.getStartMinute();
                getEndHourMet = meetings.getEndHour();
                getEndMinuteMet = meetings.getEndMinute();
                cover.put(LocalTime.of(getStartHourMet, getStartMinuteMet), LocalTime.of(getEndHourMet, getEndMinuteMet));
            }
        }

        for (Calendars calendars : calendarsList) {
            startHourInCalendar = calendars.getStartHour();
            startMinuteInCalendar = calendars.getStartMinute();
            endHourInCalendar = calendars.getEndHour();
            endMinuteInCalendar = calendars.getEndMinute();
        }
        Set<LocalTime> startTimesKey = this.cover.keySet();
        List<LocalTime> sortedStartTimes = new ArrayList<>(startTimesKey);
        Collections.sort(sortedStartTimes);

        LocalTime lastEnd = LocalTime.of(startHourInCalendar, startMinuteInCalendar);
        LocalTime closeHours = LocalTime.of(endHourInCalendar, endMinuteInCalendar);

        System.err.println("Proposal for the meetings between the calendars:");
        for (LocalTime start : sortedStartTimes) {
            if (lastEnd.plus(1, ChronoUnit.MINUTES).isBefore(start)) {
                System.err.println("start: " + lastEnd + " end: " + start);
            }
            lastEnd = this.cover.get(start);
        }
        if (LocalTime.MAX.truncatedTo(ChronoUnit.MINUTES).isAfter(lastEnd)) {
            System.err.println("start: " + lastEnd + " end: " + closeHours);
        }
    }
}