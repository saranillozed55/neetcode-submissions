class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        # when a value is not greater than +1 in the nums list then we create a new list
        #map?
        #brute force solution
        myset = set(nums)
        res = 0

        for num in nums:
            streak = 1
            if (num - 1) not in myset:
                while (num + 1) in myset:
                    streak += 1
                    num += 1
            res = max(res, streak)
            
        return res