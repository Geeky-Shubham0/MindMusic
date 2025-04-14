import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class BrainStateDetector {

    //Stressed
    //private static final String API_URL = "https://run.mocky.io/v3/590806bc-e2da-46f1-8a22-906d7c570980";
    //relaxed
    //private static final String API_URL = "https://run.mocky.io/v3/5980161d-3b42-4ddc-b487-e57b62af0355";
    //Focused
    private static final String API_URL = "https://run.mocky.io/v3/ebd6de31-6848-44ab-8426-10d8fa3c2f0b";
    // Method to detect the brain state
    public static String detectState() {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                return "Failed to connect to API. Response code: " + responseCode;
            }

            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }

            if (response.length() == 0) {
                return "No data received from API.";
            }

            JSONObject obj = new JSONObject(response.toString());
            String state = obj.getString("state");

            return state;

        } catch (Exception e) {
            e.printStackTrace();
            return "unknown";
        }
    }

    public static void main(String[] args) {
        String brainState = detectState();
        System.out.println("Detected Brain State: " + brainState);
    }
}