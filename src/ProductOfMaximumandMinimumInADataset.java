import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ProductOfMaximumandMinimumInADataset {
    public static List<Long> maxMin(List<String> operations, List<Integer> x) {
        List<Long> res = new ArrayList<>();
        if (operations.size() == 0 || x.size() == 0)
            return res;
        TreeSet<Integer> elements = new TreeSet<>();
        for (int i = 0; i < operations.size(); i++) {
            if (operations.get(i).equals("push")) {
                elements.add(x.get(i));
            } else {
                elements.remove(x.get(i));
            }
            res.add((long)(Integer)elements.toArray()[0] * (Integer)elements.toArray()[elements.size()-1]);
        }
        return res;
    }
}
