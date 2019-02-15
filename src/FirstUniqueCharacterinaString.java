public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        if (s.length() == 0 || s == null)
            return -1;
        int[] nums = new int[26];
        char[] arr = s.toCharArray();
        for (char c : arr) {
            nums[c - 'a']++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (nums[arr[i] - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
