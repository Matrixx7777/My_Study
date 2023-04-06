package my.task.HackerRank;

import java.util.*;
import java.util.regex.*;

public class MyRegrex {
    public static String isValidIPAddres(List<String> returnString) {
        String zeroTo255 = "([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])";
        String regex = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
        Pattern p = Pattern.compile(regex);
        Matcher m;
        List<Boolean> booleanList = new ArrayList<>();
        for (String s : returnString) {
            if (s == null) booleanList.add(false);
            else {
                m = p.matcher(s);
                booleanList.add(Boolean.valueOf(m.replaceAll("true")));
            }
        }
        return String.valueOf(booleanList);
    }

    public static void main(String[] args){
        List<String> listIp = new ArrayList<>();
        listIp.add("000.12.12.034");
        listIp.add("121.234.12.12");
        listIp.add("23.45.12.56");
        listIp.add("00.12.123.123123.123");
        listIp.add("122.23");
        listIp.add("Hello.IP");
        System.out.println(MyRegrex.isValidIPAddres(listIp));
    }
}