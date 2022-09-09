package my.task.orange;

import java.time.LocalTime;

public class Meetings {
    private LocalTime startTime;
    private LocalTime endTime;

    public Meetings(int startHour, int startMinute, int endHour, int endMinute) {
        this.startTime = LocalTime.of(startHour,startMinute);
        this.endTime = LocalTime.of(endHour,endMinute);
    }

    public int getStartHour() { return startTime.getHour(); }

    public int getEndHour() { return endTime.getHour(); }

    public int getStartMinute() { return startTime.getMinute(); }

    public int getEndMinute() { return endTime.getMinute(); }

    public void setStartHourAndMinute(int startHour, int startMinute ){ this.startTime = LocalTime.of(startHour, startMinute); }

    public void setEndHourAndMinute(int endHour, int endMinute ){ this.endTime = LocalTime.of(endHour, endMinute); }
}