public class _12_IntegertoRoman {
    /**
     * time complexity: O(n)
     * sapce complexity: O(n)
     *
     consider the special cases: 4, 9, 40, 90, 400 and 900
     */
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                res.append(strs[i]);
                num -= values[i];
            }
        }

        return res.toString();
    }
}
