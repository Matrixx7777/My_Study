package my.task.orange;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class WorkingTime {

    private LocalTime startTime;
    private LocalTime endTime;
    private final Map<LocalTime, LocalTime> cover = new HashMap<>();

    public WorkingTime(int startHour, int endHour) {
        this.startTime = LocalTime.of(startHour,0);
        this.endTime = LocalTime.of(endHour,0);
    }

    public WorkingTime(int startHour, int startMinute, int endHour, int endMinute) {
        this.startTime = LocalTime.of(startHour,startMinute);
        this.endTime = LocalTime.of(endHour,endMinute);
    }

    public int getStartHour() { return startTime.getHour(); }

    public int getEndHour() { return endTime.getHour(); }

    public int getStartMinute() { return startTime.getMinute(); }

    public int getEndMinute() { return endTime.getMinute(); }

    public void setStartHourAndMinute(int startHour, int startMinute ){ this.startTime = LocalTime.of(startHour, startMinute); }

    public void setEndHourAndMinute(int endHour, int endMinute ){ this.endTime = LocalTime.of(endHour, endMinute); }

    public void addMeetingToCalendar(int startHour, int startMinute, int endHour, int endMinute) {
       int longMeetingAtLeast30Min = (endHour - startHour) * 60 + startMinute - endMinute;
        if(startHour < getStartHour() || endHour > getEndHour() || startHour < 0 || startHour > 24 || endHour < 0 || endHour > 24 ||
                startHour == getStartHour() && startMinute < getStartMinute() || endHour == getEndHour() && endMinute > getEndMinute() ||
                startMinute < 0 || startMinute > 60 || endMinute < 0 || endMinute > 60 || startHour == endHour && startMinute >= endMinute || longMeetingAtLeast30Min < 30) {
            System.out.println(cover.isEmpty());
        }
        else if(startHour >= getStartHour() || endHour <= getEndHour() || startHour == getStartHour() && startMinute >= getStartMinute() ||
                 endHour == getEndHour() && endMinute <= getEndMinute() ) {
            cover.put(LocalTime.of(startHour, startMinute), LocalTime.of(endHour, endMinute));
        }
    }

    public void coverageEmpty() {
        if(this.cover.isEmpty()){
            System.err.println("Coverage empty.");
            for (int i = 0; i < cover.size(); i++) {
                System.out.println(cover.keySet() + " " + cover.entrySet() );
            }
        }

        Set<LocalTime> startTimes = this.cover.keySet();
        List<LocalTime> sortedStartTimes = new ArrayList<>(startTimes);
        Collections.sort(sortedStartTimes);

        LocalTime lastEnd= LocalTime.of(getStartHour(),getStartMinute());
        for (LocalTime start : sortedStartTimes) {
            if(lastEnd.plus(1, ChronoUnit.MINUTES).isBefore(start)){
                System.err.println("Missing coverage between: " + lastEnd + " and " + start);
            }
            lastEnd = this.cover.get(start);
        }

        LocalTime closeHours= LocalTime.of(getEndHour(), getEndMinute());
        if(LocalTime.MAX.truncatedTo(ChronoUnit.MINUTES).isAfter(lastEnd)){
            System.err.println("Missing coverage between: " + lastEnd + " and " + closeHours);
        }
    }
}