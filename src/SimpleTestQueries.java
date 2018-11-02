import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class SimpleTestQueries {
    public static void textQueries(List<String> sentences, List<String> queries) {
        List<Map<String, Integer>> list = new ArrayList<Map<String, Integer>>();
        for (String sentence : sentences) {
            String[] words = sentence.split(" ");
            Map<String, Integer> map = new HashMap<String, Integer>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            list.add(map);
        }

        List<String> res = new ArrayList<String>();
        for (String query : queries) {
            int index = 0;
            StringBuilder sb = new StringBuilder();
            String[] words = query.split(" ");
            for (Map<String, Integer> sentence : list) {
                int min = Integer.MAX_VALUE;
                for (String word : words) {
                    if (sentence.containsKey(word)) {
                        int num = sentence.get(word);
                        min = Math.min(num, min);
                    } else {
                        min = Integer.MAX_VALUE;
                        break;
                    }
                }
                while (min != Integer.MAX_VALUE && min > 0) {
                    sb.append(index);
                    sb.append(" ");
                    min--;
                }
                index++;
            }
            if (sb.length() == 0) {
                sb.append("-1");
            }
            res.add(sb.toString());
        }
        for (String result : res) {
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        List<String> sentences = new ArrayList<>();
        sentences.add("how it was done");
        sentences.add("it goes to");
        sentences.add("goes done are it");
        List<String> phrases = new ArrayList<>();
        phrases.add("it");
        textQueries(sentences, phrases);
    }

}
