class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        left = 0
        maxArray = 0
        maxChange = k
        for right in range(len(nums)):
            if nums[right] == 0:
                maxChange -= 1
            while maxChange < 0:
                if nums[left] == 0:
                    maxChange += 1
                left += 1
            currentLength = (right - left + 1)
            maxArray = max(maxArray, currentLength)
        return maxArray
