import java.util.*;

public class FavoriteGenre {
    public static void main(String[] args) {
        Map<String, List<String>> userMap = new HashMap<>();
        List<String> user1 = Arrays.asList(new String[] {"song1", "song2", "song3", "song4", "song8"});
        List<String> user2 = Arrays.asList(new String[] {"song5", "song6", "song7"});
        userMap.put("David", user1);
        userMap.put("Emma", user2);

        Map<String, List<String>> genreMap = new HashMap<>();
        List<String> genre1 = Arrays.asList(new String[] {"song11", "song13"});
        List<String> genre2 = Arrays.asList(new String[] {"song7"});
        List<String> genre3 = Arrays.asList(new String[] {"song12", "song14"});
        List<String> genre4 = Arrays.asList(new String[] {"song5", "song6"});
        List<String> genre5 = Arrays.asList(new String[] {"song18", "song9"});
        genreMap.put("Rock", genre1);
        genreMap.put("Dubstep", genre2);
        genreMap.put("Techno", genre3);
        genreMap.put("Pop", genre4);
        genreMap.put("Jazz", genre5);

        Map<String, List<String>> res = favoritegenre(userMap, genreMap);
        for (Map.Entry<String, List<String>> pair : res.entrySet()) {
            System.out.print(pair.getKey() + ": ");
            System.out.print(Arrays.toString(pair.getValue().toArray(new String[0])));
            System.out.print("\n");
        }
    }

    /**
     * time: O(number of users * number of songs)
     * space: O(number of all the songs)
     */
    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        Map<String, List<String>> res = new HashMap<>();
        // inverse the map: song -> genre
        Map<String, String> songs2Genre = new HashMap<>();
        for (String genre: genreMap.keySet()) {
            List<String> songs = genreMap.get(genre);
            for(String song : songs) {
                songs2Genre.put(song, genre);
            }
        }
        // group the user
        for (String user : userMap.keySet()) {
            // count the number of each genre
            Map<String, Integer> count = new HashMap<>();
            // record the maximum number of the genre
            int max = 0;
            res.put(user, new ArrayList<>());
            List<String> songs = userMap.get(user);
            for (String song : songs) {
                String genre = songs2Genre.get(song);
                // consider that some songs may not belong to any genre
                if (genre == null) {
                    continue;
                }
                int cnt = count.getOrDefault(genre, 0) + 1;
                count.put(genre, cnt);
                max = Math.max(cnt, max);
            }
            for (String key : count.keySet()) {
                if (count.get(key) == max) {
                    res.get(user).add(key);
                }
            }
        }

        return res;
    }
}
