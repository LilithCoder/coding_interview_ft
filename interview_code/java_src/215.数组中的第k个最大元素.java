/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start

class Solution {
    // 本题思路：
    // 堆排序
    // 实现最大堆，优先队列，不调用函数库
    public int findKthLargest(int[] nums, int k) {
        int heap_size = nums.length;
        // 堆排序
        // 1.建立最大堆
        build_max_heap(nums, heap_size);
        // 2.从最后一个结点遍历到第二个结点
        //   每次遍历交换当前结点和根结点，将堆的大小减少1去掉最后的那个结点，并max_heapify
        for (int i = nums.length - 1; i >= 1; i--) {
            swap(nums, 0, i);
            heap_size--;
            max_heapify(nums, 0, heap_size);
        }
        // 得到的nums是从小到大排序的数组
        return nums[nums.length - k];
    }
    private void build_max_heap(int[] nums, int heap_size) {
        // n/2-1是后一个非叶子节点，从后一个非叶子节点开始max_heapify
        // 因为将每个叶结点看成只包含一个元素的堆，叶结点不需要max_heapify
        for (int i = heap_size / 2 - 1; i >= 0; i--) {
            max_heapify(nums, i, heap_size);
        }
    }
    // 以nums[i]结点为根结点，执行max_heapify，致使生成以nums[i]为根结点的最大堆
    private void max_heapify(int[] nums, int i, int heap_size) {
        // 左孩子的index
        int left_child = i * 2 + 1;
        // 右孩子的index
        int right_child = i * 2 + 2;
        // 初始化最大的结点为根结点
        int largest = i;
        // 根结点和左右孩子比较大小，三者当中最大的index为largest
        if (left_child < heap_size && nums[left_child] > nums[largest]) {
            largest = left_child;
        }
        if (right_child < heap_size && nums[right_child] > nums[largest]) {
            largest = right_child;
        }
        // 如果根结点不是最大的结点，就交换根结点和那个三者当中最大的结点
        // 交换结点过后，需要以largest那个结点为根结点继续max_heapify
        if (largest != i) {
            swap(nums, i, largest);
            max_heapify(nums, largest, heap_size);
        }
    }
    // 交换结点i和结点j
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


class Solution {
    // 优先队列
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        for (int num : nums) {
            pqueue.add(num);
            if (pqueue.size() > k) pqueue.remove();
        }
        return pqueue.peek();
    }
}

class Solution {
    // 基于快速排序的选择
    public int findKthLargest(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        return quick_select(nums, low, high, nums.length - k);
    }
    public int quick_select(int[] nums, int low, int high, int k) {
        int pivot_index = partition(nums, low, high);
        if (pivot_index == k) return nums[pivot_index];
        return pivot_index > k ? quick_select(nums, low, pivot_index - 1, k) : quick_select(nums, pivot_index + 1, high, k);
    }
    public int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (nums[j] < pivot) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[i + 1];
        nums[i + 1] = nums[high];
        nums[high] = temp;
        return i + 1;
    }
}
// @lc code=end

