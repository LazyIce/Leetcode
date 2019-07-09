public class _307_RangeSumQueryMutable {
    /**
     * Binary Indexed Trees (BIT or Fenwick tree):
     * https://www.topcoder.com/community/data-science/data-science-tutorials/binary-indexed-trees/
     */
    class NumArray1 {
        private int[] nums;
        private int[] BIT;
        private int n;

        public NumArray1(int[] nums) {
            this.nums = nums;
            n = nums.length;
            BIT = new int[n + 1];   // BIT's index start from 1.
            for (int i = 0; i < n; i++)
                init(i, nums[i]);
        }

        // update current node and parent node
        public void init(int i, int val) {
            i++;
            while (i <= n) {
                BIT[i] += val;
                i += (i & -i); // extract the last bit (least significant non-zero bit): i & -i
            }
        }

        // update current node and change parent node
        void update(int i, int val) {
            int diff = val - nums[i];
            nums[i] = val;
            init(i, diff);
        }

        // calculate the sum
        public int getSum(int i) {
            int sum = 0;
            i++;
            while (i > 0) {
                sum += BIT[i];
                i -= (i & -i);
            }
            return sum;
        }

        public int sumRange(int i, int j) {
            return getSum(j) - getSum(i - 1);
        }
    }

    /**
     * Segment Tree
     */
    class NumArray2 {
        class SegmentTreeNode{
            int start;
            int end;
            SegmentTreeNode left;
            SegmentTreeNode right;
            int sum;

            public SegmentTreeNode(int start, int end){
                this.start = start;
                this.end = end;
            }
        }

        private SegmentTreeNode buildSegmentTree(int[] nums, int start, int end){
            if(start > end) return null;
            SegmentTreeNode cur = new SegmentTreeNode(start, end);
            if(start == end) cur.sum = nums[start];
            else{
                int mid = (start + end) / 2;
                cur.left = buildSegmentTree(nums, start, mid);
                cur.right = buildSegmentTree(nums, mid+1, end);
                cur.sum = cur.left.sum + cur.right.sum;
            }
            return cur;
        }

        private SegmentTreeNode root;
        public NumArray2(int[] nums) {
            this.root = buildSegmentTree(nums, 0, nums.length-1);
        }

        public void update(int i, int val) {
            update(root, i, val);
        }

        private void update(SegmentTreeNode root, int position, int val){
            if(root.start == root.end){
                root.sum = val;
            }else{
                int mid = (root.start + root.end) / 2;
                if(position <= mid){
                    update(root.left, position, val);
                }else{
                    update(root.right, position, val);
                }
                root.sum = root.left.sum + root.right.sum;
            }
        }

        public int sumRange(int i, int j) {
            return sumRange(root, i, j);
        }

        public int sumRange(SegmentTreeNode root, int i, int j){
            if(root.start==i && root.end==j){
                return root.sum;
            }
            int mid = (root.start + root.end )/2;
            if(j<=mid){
                return sumRange(root.left, i, j);
            }else if(i>mid){
                return sumRange(root.right, i, j);
            }else{
                return sumRange(root.left, i, mid) + sumRange(root.right, mid+1, j);
            }
        }
    }
}
