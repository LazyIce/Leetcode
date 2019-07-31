public class _484_FindPermutation {
    /**
     * time: O(n)
     * space: O(n)
     */
    public int[] findPermutation(String s) {
        int len = s.length();
        int[] res = new int[len + 1];
        for (int i = 0; i <= len; i++) {
            res[i] = i + 1;
        }
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'D') {
                int start = i;
                while (i < len && s.charAt(i) == 'D') {
                    i++;
                }
                reverse(res, start, i);
            }
        }

        return res;
    }

    public void reverse(int[] array, int left, int right) {
        while (left < right){
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
