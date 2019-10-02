import java.util.HashSet;

public class BrokenKeyboard {
    public static void main(String[] args) {
        String[] words = new String[] {"hEllo##", "This^^"};
        char[] validLetters = new char[] {'h', 'e', 'l', 'o', 't', 'h', 's'};
        HashSet<Character> validLettersSet = new HashSet<>();
        for (char ch : validLetters) {
            validLettersSet.add(ch);
        }

        int res = 0;
        for (String word : words) {
            word = word.toLowerCase();
            boolean valid = true;
            for (Character ch : word.toCharArray()) {
                if (Character.isLetter(ch) && !validLettersSet.contains(ch)) {
                    valid = false;
                    break;
                } else {
                    continue;
                }
            }
            if (valid) {
                res++;
            }
        }

        System.out.println(res);
    }
}
