import java.util.PriorityQueue;
import java.util.Random;

public class _215_KthLargestElementinanArray {
    /**
     * PriorityQueue
     * time: (nlogk)
     * space: O(k)
     */
    public int findKthLargest1(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }

    /**
     * QuickSelect
     * time: O(n)
     * space: O(1)
     */
    public int findKthLargest2(int[] nums, int k) {
        //shuffle to gurantee O(N)
        shuffle(nums);
        //quickselect
        return partition(nums, k, 0, nums.length - 1);
    }

    //two-way paritioning
    //large > pivot > small
    private int partition(int[] nums, int k, int begin, int end){

        int pivot = nums[begin];
        int left = begin, right = end;

        //break when right < left
        while(left <= right){
            //find the first num that smaller than pivot
            while(left <= right && nums[left] >= pivot)
                left++;
            //find the first num that larger than pivot
            while(left <= right && nums[right] <= pivot)
                right--;
            if(left < right)
                swap(nums, left, right);
        }

        swap(nums, begin, right);
        //now right is the pivot point

        if(k == right + 1)
            return nums[right];
        else if(k < right + 1)
            return partition(nums, k, begin, right - 1);
        else
            return partition(nums, k, right + 1, end);
    }

    private void shuffle(int[] nums){
        Random ran = new Random();
        for(int i = 1; i < nums.length; i++){
            int j = ran.nextInt(i+1);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
