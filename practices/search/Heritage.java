import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Heritage {
    Map<String, List<String>> tree;
    Set<String> dead;
    String root;

    public Heritage() {
        tree = new HashMap<>();
        dead = new HashSet<>();
        root = "king";
        tree.put("king", new ArrayList<>());
    }

    public void birth(String parent, String name) throws Exception {
        if(!tree.containsKey(parent)) {
            throw new Exception("No parent");
        } else {
            tree.get(parent).add(name);
            tree.put(name, new ArrayList<>());
        }
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getOrder(){
        List<String> res = new ArrayList<>();
        dfs(root, res);
        return res;

    }

    private void dfs(String curr, List<String> res) {
        if(!dead.contains(curr)) {
            res.add(curr);
        }

        for(String child : tree.get(curr)) {
            dfs(child, res);
        }

    }
}
