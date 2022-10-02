package my.task.extra.API_Kanye_Rest;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class KanyeRest {

    private static boolean isUrlValid(String url) {
        try {
            URL obj = new URL(url);
            obj.toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }

    public static String getQuote() throws IOException {
        String url = "https://api.kanye.rest/";
        StringBuilder builder = new StringBuilder();
        if(isUrlValid(url)) {
            URL obj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestMethod("GET");
            int response = conn.getResponseCode();
            if (response == 200) {
                Scanner responseReader = new Scanner(conn.getInputStream());
                while (responseReader.hasNext()) {
                    builder.append(responseReader.nextLine());
                }
                responseReader.close();
            }
        }
        return String.valueOf(builder);
    }
}