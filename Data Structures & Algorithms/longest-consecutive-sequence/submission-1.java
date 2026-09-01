class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();

        for(int n : nums) {
            set.add(n);
        }

        for(int num : nums) {
            if(!set.contains(num - 1)) {
                int current = num;
                int length = 1;
                while(set.contains(current + 1)) {
                    current++;
                    length++;
                }
            res = Math.max(res, length);
            }
        }
        return res;

    }
}
