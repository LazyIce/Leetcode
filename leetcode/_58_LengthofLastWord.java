public class _58_LengthofLastWord {
    /**
     * time: O(n)
     * space: O(1)
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;

        s = s.trim(); // 'a ' returns 1
        int lastIndex = s.lastIndexOf(' ') + 1;
        return s.length() - lastIndex;
    }
}
