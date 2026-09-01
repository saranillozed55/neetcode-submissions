class Solution {
    public int findMin(int[] nums) {
        int min = 999;

        for(int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }
}
