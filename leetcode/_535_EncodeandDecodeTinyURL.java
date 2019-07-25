import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class _535_EncodeandDecodeTinyURL {
    public class Codec {
        private Map<String, String> map = new HashMap<>();
        private String mapping = "abcdefghijklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            Random rand = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int idx = rand.nextInt(mapping.length());
                sb.append(mapping.charAt(idx));
            }
            String url = "https://tinyurl.com/" + sb.toString();
            if (!map.containsKey(url)) {
                map.put(url, longUrl);
            }

            return url;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return map.get(shortUrl);
        }
    }

}
