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

    public void coverageEmpty(List<Meetings> meetingsListFirst, List<Meetings> meetingsListSecond , List<Calendars> calendarsList) {

        int startHourInCalendar = 0; int startMinuteInCalendar = 0;
        int endHourInCalendar = 0; int endMinuteInCalendar = 0;

        System.err.println("Proposal for the meetings between two calendars:");

        for (int i = 0; i < meetingsListFirst.size() + meetingsListSecond.size(); i++) {

            int startHourList_1 = meetingsListFirst.get(i).getStartHour() ; int startMinuteList_1 = meetingsListFirst.get(i).getStartMinute();
            int endHourList_1 = meetingsListFirst.get(i).getEndHour(); int endMinuteList_1 = meetingsListFirst.get(i).getEndMinute();
            int meeting_durationList_1 = (endHourList_1 - startHourList_1) * 60 + startMinuteList_1 - endMinuteList_1;

            int startHourList_2 = meetingsListSecond.get(i).getStartHour(); int startMinuteList_2 = meetingsListSecond.get(i).getStartMinute();
            int endHourList_2 = meetingsListSecond.get(i).getEndHour(); int endMinuteList_2 = meetingsListSecond.get(i).getEndMinute();
            int meeting_durationList_2 = (endHourList_2 - startHourList_2) * 60 + startMinuteList_2 - endMinuteList_2;

            if (startHourList_1 < getStartHour() || endHourList_1 > getEndHour() || startHourList_1 == endHourList_1
                    || startHourList_1 < 0 || startHourList_1 > 24 || endHourList_1 < 0 || endHourList_1 > 24 ||  startHourList_1 == getStartHour() && startMinuteList_1 < getStartMinute() ||
                    endHourList_1 == getEndHour() && endMinuteList_1 > getEndMinute() || startMinuteList_1 < 0 || startMinuteList_1 > 60 || endMinuteList_1 < 0 || endMinuteList_1 > 60  ||
                    meeting_durationList_1< 30 ||

                    startHourList_2 < getStartHour() || endHourList_2 > getEndHour() || startMinuteList_2 == endHourList_2 || startHourList_2 < 0 ||
                    startHourList_2 > 24 || endHourList_2 < 0 || endHourList_2 > 24 || startHourList_2 == getStartHour() && startMinuteList_2 < getStartMinute() ||
                    endHourList_2 == getEndHour() && endMinuteList_2 > getEndMinute() || startMinuteList_2 < 0 || startMinuteList_2 > 60 || endMinuteList_2 < 0 || endMinuteList_2 > 60 ||
                    startHourList_2 == endHourList_2 && startMinuteList_2 >= endMinuteList_2 || meeting_durationList_2< 30

                    //Compare properties of the two lists

            ) {
                meetingsListFirst.remove(i).getStartHour(); meetingsListFirst.remove(i).getEndMinute();
                meetingsListFirst.remove(i).getEndHour(); meetingsListFirst.remove(i).getEndMinute();


                meetingsListSecond.remove(i).getStartHour(); meetingsListSecond.remove(i).getEndMinute();
                meetingsListSecond.remove(i).getEndHour(); meetingsListSecond.remove(i).getEndMinute();
            }
            else if(meetingsListFirst.isEmpty() && startHourList_1 >= getStartHour() || endHourList_1 <= getEndHour() || startHourList_1 == getStartHour() && startMinuteList_1 >= getStartMinute() ||
                    endHourList_1 == getEndHour() && endMinuteList_1 <= getEndMinute() ||

                    meetingsListSecond.isEmpty() && startMinuteList_2 >= getStartHour() || endHourList_2 <= getEndHour() || startHourList_1 == getStartHour() && startMinuteList_2 >= getStartMinute() ||
                    endHourList_2 == getEndHour() && endMinuteList_2 <= getEndMinute()) {

                cover.put(LocalTime.of(startHourList_1, startMinuteList_1), LocalTime.of(endHourList_1, endMinuteList_1));
                cover.put(LocalTime.of(startHourList_2, startMinuteList_2), LocalTime.of(endHourList_2, endMinuteList_2));
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