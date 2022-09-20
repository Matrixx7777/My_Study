package my.task.exam.second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Calculations {

    public double calculateBestAverage(Map<Student, Grades> scores) {

        double currentMaxValue = Integer.MIN_VALUE;
        for (Map.Entry<Student, Grades> entry : scores.entrySet()) {
            if (entry.getValue().getAverage() > currentMaxValue) {
                currentMaxValue = entry.getValue().getAverage();
            }
        }
        return currentMaxValue;
    }

    public List<String> findStudentsNamesWithBestAverage(Map<Student, Grades> scores) {

        double currentMaxValue = Double.MIN_VALUE;
        List<String> listString = new ArrayList<>();
        for (Map.Entry<Student, Grades> entry : scores.entrySet()) {
            if (entry.getValue().getAverage() > currentMaxValue) {
                String returnIt = entry.getKey().getFirstName() + " " + entry.getKey().getLastName();
                listString.add(returnIt);
            }
        }
        return Collections.singletonList(listString.get(0));
    }

    public List<String> findStudentsWhichSpeakPolishWithAverageFromMathAbove4(Map<Student, Grades> scores){

        List<String> resultList = new ArrayList<>();
        for (Map.Entry<Student, Grades> entry : scores.entrySet()) {
            if (entry.getValue().getAverage() > 4 && entry.getKey().getLanguage().equals("PL")) {
                resultList.clear();
                resultList.add(entry.getKey().getLastName());
            }
        }
        return resultList;
    }
}