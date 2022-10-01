package my.task.extra.API_Kanye_Rest;

import java.io.*;
import java.net.*;

public class SaveText {

    public static void main(String[] args) throws IOException {
        getAndPutQuote();
    }

    public static void getAndPutQuote() throws IOException {
        //Put
        String url = "https://api.kanye.rest/";
        URL obj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
//        conn.setRequestProperty("Content-Type", "application/xml");
        conn.setDoOutput(true);
        conn.setRequestMethod("PUT");
        OutputStreamWriter out = new OutputStreamWriter(
                conn.getOutputStream());
        out.write("Resource content");
        out.flush();

        // Get the response
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            System.err.println(line);
        }
        out.close();
        rd.close();
    }

//    private static boolean isUrlValid(String url) {
//        try {
//            URL obj = new URL(url);
//            obj.toURI();
//            return true;
//        } catch (MalformedURLException | URISyntaxException e) {
//            return false;
//        }
//    }
//
//    private static void getQuote() throws IOException {
//        String url = "https://api.kanye.rest/";
//        StringBuilder builder = new StringBuilder();
//        if(isUrlValid(url)) {
//            URL obj = new URL(url);
//            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
//            conn.setRequestMethod("GET");
//            int response = conn.getResponseCode();
//            if (response == 200) {
//                Scanner responseReader = new Scanner(conn.getInputStream());
//                while (responseReader.hasNext()) {
//                    builder.append(responseReader.nextLine());
//                }
//                responseReader.close();
//                System.err.println(builder);
//            }
//        }
//    }
//
//    public static void putQuote() throws IOException {
//        URL url = new URL("https://api.kanye.rest/");
//        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
//        httpCon.setDoOutput(true);
//        httpCon.setRequestMethod("PUT");
//        OutputStreamWriter out = new OutputStreamWriter(
//                httpCon.getOutputStream());
//        out.write("Resource content");
//        out.close();
//        httpCon.getInputStream();
//    }
}