public class TwitterSocialNetwork {
    public static void main(String[] args) {
        String[] related = new String[] {"1100", "1110", "0110", "0001"};
        System.out.println(countGroups(related));
    }

    public static int countGroups(String[] related) {
        int[][] M = new int[related.length][related.length];
        for (int i = 0; i < related.length; i++) {
            for (int j = 0; j < related[i].length(); j++) {
                M[i][j] = related[i].charAt(j) - '0';
            }
        }

        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    public static void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}
