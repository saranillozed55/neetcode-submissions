class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        myset = set(nums)
        res = 0

        for num in myset:
            if num - 1 not in myset:
                streak = 1
                while num + streak in myset:
                    streak += 1
                res = max(streak, res)
        return res