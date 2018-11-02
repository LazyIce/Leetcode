/**
 * time:
 * space:
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class RevorControl {
    public static int roverMove(int matrixSize, List<String> cmds) {
        int[] start = {0, 0};
        Map<String, int[]> map = new HashMap<String, int[]>();
        map.put("UP", new int[]{0, -1});
        map.put("RIGHT", new int[]{1, 0});
        map.put("DOWN", new int[]{0, 1});
        map.put("LEFT", new int[]{-1, 0});

        for (String cmd : cmds) {
            int[] move = map.get(cmd);
            if (start[0] + move[0] <0 || start[0] + move[0] >= matrixSize
                    || start[1] + move[1] < 0 || start[1] + move[1] >= matrixSize) {
                continue;
            } else {
                start[0] = start[0] + move[0];
                start[1] = start[1] + move[1];
            }
        }

        return start[0] + start[1] * matrixSize;
    }

    public static void main(String[] args) {
        String[] cmds = {"RIGHT", "DOWN", "LEFT", "LEFT", "DOWN"};
        String[] cmds2 = {"RIGHT", "UP", "DOWN", "LEFT", "LEFT", "DOWN", "DOWN"};
        List<String> cmdlist = new ArrayList<>();
        for (String cmd : cmds)
            cmdlist.add(cmd);
        List<String> cmdlist2 = new ArrayList<>();
        for (String cmd : cmds2)
            cmdlist2.add(cmd);
        System.out.println(roverMove(4, cmdlist));
        System.out.println(roverMove(4, cmdlist2));
    }
}
