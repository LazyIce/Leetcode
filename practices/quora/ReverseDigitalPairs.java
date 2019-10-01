public class ReverseDigitalPairs {
    public static void main(String[] args) {
        int num = 12345;
        System.out.println(getReversedDigitalPair(num));
    }

    public static int getReversedDigitalPair(int num) {
        char[] digits = String.valueOf(num).toCharArray();

        for (int i = 0; i < digits.length; i += 2) {
            if (i + 1 < digits.length) {
                char temp = digits[i];
                digits[i] = digits[i + 1];
                digits[i + 1] = temp;
            }
        }

        return Integer.parseInt(String.valueOf(digits));
    }
}
