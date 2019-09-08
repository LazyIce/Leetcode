import java.util.HashMap;
import java.util.Map;

public class AuthenticationToken {
    public static void main(String[] args) {
        int expiryLimit = 4;
        int[][] commands = new int[][] {{0, 1, 1}, {0, 2, 2}, {1, 1, 5}, {1, 2, 7}};
        System.out.println(numberOfTokens(expiryLimit, commands));
    }

    public static int numberOfTokens(int expiryLimit, int[][] commands) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] command : commands) {
            if (command[0] == 0 && !map.containsKey(command[1])) {
                map.put(command[1], expiryLimit + command[2]);
            }
            if (command[0] == 1 && map.containsKey(command[1])) {
                if (command[2] <= map.get(command[1])) {
                    map.put(command[1], expiryLimit + command[2]);
                }
            }
        }


        int res = 0;
        for (Integer expiry : map.values()) {
            if (expiry > commands[commands.length - 1][2]) {
                res++;
            }
        }

        return res;
    }
}
