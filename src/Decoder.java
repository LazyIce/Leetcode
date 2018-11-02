public class Decoder {
    public static String decode(String encoded) {
        if (encoded == null || encoded.length() == 0)
            return null;

        StringBuilder sb = new StringBuilder(encoded);
        String input = sb.reverse().toString();

        StringBuilder res = new StringBuilder();
        int start = 0;
        int end = 2;
        while (start < input.length() && end <= input.length()) {
            String substr = input.substring(start, end);
            int value = Integer.parseInt(substr);
            if (value >= 65 && value <= 90) {
                res.append((char) value);
            } else if (value >= 97 && value <= 122) {
                res.append((char) value);
            } else if (value == 32) {
                res.append(' ');
            } else {
                end++;
                continue;
            }
            start = end;
            end = start + 2;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String input = "23511011501782351112179911801562340161171141148";
        String decode  = decode(input);
        System.out.print(decode);
    }
}
