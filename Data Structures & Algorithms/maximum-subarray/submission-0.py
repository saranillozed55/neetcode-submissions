class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        curMaxSum = nums[0]
        sumEndingHere = nums[0]

        for val in range(1, len(nums)):
            if sumEndingHere < 0:
                sumEndingHere = nums[val]
            else:
                sumEndingHere += nums[val]
            if sumEndingHere > curMaxSum:
                curMaxSum = sumEndingHere

        return curMaxSum
            