public class _383_RansomNote {
    /**
     * time: O(n)
     * space: O(1)
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[256];
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i)]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--count[ransomNote.charAt(i)] < 0)
                return false;
        }

        return true;
    }
}
