class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            //Since we sorted the array, if the value at i is 0 then the 
            //rest of the array cannot sum to 0
            if(nums[i] > 0) break;
            //Skip duplicate values for the first element to avoid duplicate triplets
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0) {
                    right--;
                }
                else if (sum < 0) {
                    left++;
                }
                else {
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    //skip all duplicate values to avoid duplicate triplets
                    while(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }

        return result;
        
    }
}
