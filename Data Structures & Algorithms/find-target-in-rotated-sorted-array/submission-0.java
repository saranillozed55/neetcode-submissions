class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low < high) {
            int mid = (low + high) / 2;

            if(nums[mid] > nums[high]) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        int pivot = low;

        int result = binarySearch(nums, target, 0, pivot - 1);

        if(result != -1) {
            return result;
        }
        return binarySearch(nums, target, pivot, nums.length - 1);
    }
    public int binarySearch(int[] nums, int target, int left, int right) {
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
