package my.task.extra.API_Kanye_Rest;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        Set<String> stringSet = new HashSet<>();
        stringSet.add(KanyeRest.getQuote());
        stringSet.add(KanyeRest.getQuote());
        stringSet.add(KanyeRest.getQuote());
        stringSet.add(KanyeRest.getQuote());
        stringSet.add(KanyeRest.getQuote());

        for (String list: stringSet) {
            System.err.println(list);
        }
    }
}