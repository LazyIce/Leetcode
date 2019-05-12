public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length <= 1)
            return 0;
        if (words.length == 2)
            return 1;
        int first = -1;
        int second = -1;
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)) {
                first = i;
                if(first != -1 && second != -1) answer = Math.min(answer, Math.abs(second-first));
            }
            if(words[i].equals(word2)) {
                second = i;
                if(first != -1 && second != -1) answer = Math.min(answer, Math.abs(second-first));
            }
        }
        return answer;
    }
}
