public class _1170_CompareStringsbyFrequencyoftheSmallestCharacter {
    /**
     * time: O(m*n)
     * space: O(m+n)
     */
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] queriesFrequency = new int[queries.length];
        int[] wordsFrequency = new int[words.length];

        for (int i = 0; i < queries.length; i++) {
            queriesFrequency[i] = smallestCharacterFrequency(queries[i]);
        }

        for (int i = 0; i < words.length; i++) {
            wordsFrequency[i] = smallestCharacterFrequency(words[i]);
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int num = 0;
            for (int j = 0; j < words.length; j++) {
                if (queriesFrequency[i] < wordsFrequency[j]) {
                    num++;
                }
            }
            res[i] = num;
        }

        return res;
    }

    public int smallestCharacterFrequency(String word) {
        int max = 1;
        char cur = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) < cur) {
                cur = word.charAt(i);
                max = 1;
            } else if (word.charAt(i) == cur) {
                max++;
            }
        }

        return max;
    }
}
