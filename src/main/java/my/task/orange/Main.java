package my.task.orange;

public class Main {
    public static void main(String[] args) {

        WorkingTime calendar1 = new WorkingTime(9, 0,19,55);
        calendar1.addMeetingToCalendar(9,30,10,30);
        calendar1.addMeetingToCalendar(12,0,13,0);
        calendar1.addMeetingToCalendar(16,0,18,0);

        WorkingTime calendar2 = new WorkingTime(10,0,18,30);
        calendar2.addMeetingToCalendar(10,0,11,30);
        calendar2.addMeetingToCalendar(12,30,14,30);
        calendar2.addMeetingToCalendar(14,30,15,0);
        calendar2.addMeetingToCalendar(16,0,17,0);

        calendar1.coverageEmpty();
        calendar2.coverageEmpty();
    }
}