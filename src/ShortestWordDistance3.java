public class ShortestWordDistance3 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int first = -1;
        int second = -1;
        int answer = Integer.MAX_VALUE;

        if (word1.equals(word2)) {
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    first = second;
                    second = i;
                    if (first != -1 && second != -1)
                        answer = Math.min(answer, Math.abs(second - first));
                }
            }
        } else {
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    first = i;
                    if (first != -1 && second != -1)
                        answer = Math.min(answer, Math.abs(second - first));
                }

                if (words[i].equals(word2)) {
                    second = i;
                    if (first != -1 && second != -1)
                        answer = Math.min(answer, Math.abs(second - first));
                }
            }
        }

        return answer;
    }
}
