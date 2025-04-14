import java.awt.Desktop;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class SpotifyMusicPlayer {

    private static final Map<String, String> STATE_TO_QUERY = new HashMap<>();

    static {
        STATE_TO_QUERY.put("relaxed", "chill lofi");
        STATE_TO_QUERY.put("focused", "instrumental focus");
        STATE_TO_QUERY.put("stressed", "calm piano");
    }

    public static void play(String state) {
        String query = STATE_TO_QUERY.getOrDefault(state, "relaxing music");
        String url = "https://open.spotify.com/search/" + query.replace(" ", "%20");

        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
