public class _302_SmallestRectangleEnclosingBlackPixels {
    /**
     * DFS
     * time: O(m*n)
     * space: O(m*n)
     */
    public int minArea1(char[][] image, int x, int y) {
        int[] res = new int[]{image.length - 1, 0, image[0].length - 1, 0};
        dfs(image, x, y, res);
        return (res[1] - res[0] + 1) * (res[3] - res[2] + 1);
    }

    public void dfs(char[][] image, int x, int y, int[] res) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] == '0')
            return;
        image[x][y] = '0';
        res[0] = Math.min(res[0], x);
        res[1] = Math.max(res[1], x);
        res[2] = Math.min(res[2], y);
        res[3] = Math.max(res[3], y);
        dfs(image, x - 1, y, res);
        dfs(image, x + 1, y, res);
        dfs(image, x, y - 1, res);
        dfs(image, x, y + 1, res);
    }

    /**
     * Binary Search
     * time: O(mlogn+nlogm)
     * space: O(1)
     */
    public int minArea2(char[][] image, int x, int y) {
        int left = binarySearchLeft(image, 0, y, true);
        int right = binarySearchRight(image, y, image[0].length - 1, true);

        int top = binarySearchLeft(image, 0, x, false);
        int bottom = binarySearchRight(image, x, image.length - 1, false);

        return (right - left + 1) * (bottom - top + 1);
    }

    private int binarySearchLeft(char[][] image, int left, int right, boolean isHor) {
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (hasBlack(image, mid, isHor)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (hasBlack(image, left, isHor)) {
            return left;
        }
        return right;
    }

    private int binarySearchRight(char[][] image, int left, int right, boolean isHor) {
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (hasBlack(image, mid, isHor)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (hasBlack(image, right, isHor)) {
            return right;
        }
        return left;
    }

    private boolean hasBlack(char[][] image, int x, boolean isHor) {
        if (isHor) {
            for (int i = 0; i < image.length; i++) {
                if (image[i][x] == '1')
                    return true;
            }
        } else {
            for (int i = 0; i < image[0].length; i++) {
                if (image[x][i] == '1')
                    return true;
            }
        }
        return false;
    }
}
