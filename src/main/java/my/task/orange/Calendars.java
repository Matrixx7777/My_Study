package my.task.orange;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Calendars {
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final Map<LocalTime, LocalTime> cover = new HashMap<>();

    public Calendars(int startHour, int endHour) {
        this.startTime = LocalTime.of(startHour, 0);
        this.endTime = LocalTime.of(endHour, 0);
    }

    public Calendars(int startHour, int startMinute, int endHour, int endMinute) {
        this.startTime = LocalTime.of(startHour, startMinute);
        this.endTime = LocalTime.of(endHour, endMinute);
    }

    public int getStartHour() {
        return startTime.getHour();
    }

    public int getEndHour() {
        return endTime.getHour();
    }

    public int getStartMinute() {
        return startTime.getMinute();
    }

    public int getEndMinute() {
        return endTime.getMinute();
    }

    public void coverageEmpty(List<Meetings> meetingsList, List<Calendars> calendarsList) {

        int startHourInCalendar = 0; int startMinuteInCalendar = 0;
        int endHourInCalendar = 0; int endMinuteInCalendar = 0;

        System.err.println("Proposal for the meetings between two calendars:");

        for (int i = 0; i < meetingsList.size(); i++) {
            int startHour = meetingsList.get(i).getStartHour() ; int startMinute = meetingsList.get(i).getStartMinute();
            int endHour = meetingsList.get(i).getEndHour(); int endMinute = meetingsList.get(i).getEndMinute();
            int meeting_durationList_1 = (endHour - startHour) * 60 + startMinute - endMinute;

            if (startHour < getStartHour() || endHour > getEndHour() || startHour == endHour || startHour < 0 || startHour > 24 || endHour < 0 || endHour > 24 ||
                    startHour == getStartHour() && startMinute < getStartMinute() || endHour == getEndHour() && endMinute > getEndMinute() || startMinute < 0 || startMinute > 60 ||
                    endMinute < 0 || endMinute > 60  || meeting_durationList_1< 30) {
                meetingsList.remove(i).getStartHour(); meetingsList.remove(i).getEndMinute();
                meetingsList.remove(i).getEndHour(); meetingsList.remove(i).getEndMinute();
            }
            else if(meetingsList.isEmpty() && startHour >= getStartHour() || endHour <= getEndHour() || startHour == getStartHour() &&
                    startMinute >= getStartMinute() || endHour == getEndHour() && endMinute <= getEndMinute()){
                cover.put(LocalTime.of(startHour, startMinute), LocalTime.of(endHour, endMinute));
            }
        }
        for (Calendars calendars : calendarsList) {
            startHourInCalendar = calendars.getStartHour();
            startMinuteInCalendar = calendars.getStartMinute();
            endHourInCalendar = calendars.getEndHour();
            endMinuteInCalendar = calendars.getEndMinute();
        }
        Set<LocalTime> startTimes = this.cover.keySet();
        List<LocalTime> sortedStartTimes = new ArrayList<>(startTimes);
        Collections.sort(sortedStartTimes);

        LocalTime lastEnd = LocalTime.of(startHourInCalendar, startMinuteInCalendar);
        LocalTime closeHours = LocalTime.of(endHourInCalendar, endMinuteInCalendar);

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