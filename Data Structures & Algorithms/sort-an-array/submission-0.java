class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        // Step 1: Build max-heap (rearrange array)
        // Start from the last non-leaf node: (n / 2) - 1 down to 0
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        // Step 2: One by one extract elements from the heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root (maximum element) to the end
            swap(nums, 0, i);

            // Sift-down the new root on the reduced heap [0 .. i-1]
            heapify(nums, i, 0);
        }

        return nums;
    }

    // Iterative sift-down to maintain O(1) space with no recursion stack overhead
    private void heapify(int[] nums, int n, int i) {
        while (true) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n && nums[left] > nums[largest]) {
                largest = left;
            }

            if (right < n && nums[right] > nums[largest]) {
                largest = right;
            }

            // If largest is not the current root, swap and continue sifting down
            if (largest != i) {
                swap(nums, i, largest);
                i = largest;
            } else {
                break;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}