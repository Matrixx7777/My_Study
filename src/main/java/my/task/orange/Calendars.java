package my.task.orange;

import java.time.LocalTime;

public class Calendars {
    private final LocalTime startTime;
    private final LocalTime endTime;

    public Calendars(int startHour, int endHour) {
        this.startTime = LocalTime.of(startHour, 0);
        this.endTime = LocalTime.of(endHour, 0);
    }

    public Calendars(int startHour, int startMinute, int endHour, int endMinute) {
        this.startTime = LocalTime.of(startHour, startMinute);
        this.endTime = LocalTime.of(endHour, endMinute);
    }

    public int getStartHour() { return startTime.getHour(); }

    public int getEndHour() { return endTime.getHour(); }

    public int getStartMinute() { return startTime.getMinute(); }

    public int getEndMinute() { return endTime.getMinute(); }
}