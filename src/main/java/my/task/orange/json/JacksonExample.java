package my.task.orange.json;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Map;

import my.task.orange.WorkingTime;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

public class JacksonExample {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationConfig.Feature.DEFAULT_VIEW_INCLUSION, false);

        //For testing
        WorkingTime workingtime =  createHours();

        try {
            String jsonInString = mapper.writerWithView(Views.StartTime.class).writeValueAsString(workingtime.getStartHour());
            String jsonInString2 = mapper.writerWithView(Views.StartTime.class).writeValueAsString(workingtime.getStartMinute());
            System.out.println(jsonInString + ":" + jsonInString2);

            jsonInString = mapper.writerWithView(Views.EndTime.class).writeValueAsString(workingtime.getEndHour());
            jsonInString2 = mapper.writerWithView(Views.EndTime.class).writeValueAsString(workingtime.getEndMinute());
            System.out.println(jsonInString + ":" + jsonInString2);

            jsonInString = mapper.writerWithView(Views.WorkingTime.class).writeValueAsString(workingtime);
            System.out.println(jsonInString);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static WorkingTime createHours(){

        WorkingTime calendar1 = new WorkingTime(9, 0, 19, 55);
        calendar1.setStartHourAndMinute(9, 0, 19, 55);

        Map<LocalTime, LocalTime> met1 = calendar1.addMeetingToCalendar(9, 30, 10, 30);
        calendar1.addMeetingToCalendar(12, 0, 13, 0);
        calendar1.addMeetingToCalendar(16, 0, 18, 0);

        WorkingTime calendar2 = new WorkingTime(10, 0, 18, 30);
        calendar2.setStartHourAndMinute(10, 0, 18, 30);

        Map<LocalTime, LocalTime> met2 = calendar2.addMeetingToCalendar(10, 0, 11, 30);
        calendar2.addMeetingToCalendar(12, 30, 14, 30);
        calendar2.addMeetingToCalendar(14, 30, 15, 0);
        calendar2.addMeetingToCalendar(16, 0, 17, 0);

//        Map<LocalTime, LocalTime> cal1 = calendar1.coverageEmpty();
//        calendar2.coverageEmpty();

        calendar1.setMeetings(met1);
        calendar2.setMeetings(met2);

        return calendar2;
    }
}