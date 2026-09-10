class Solution:
    def findMin(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1

        while left < right:

            if nums[left] < nums[right]: # found the smallest value in the array
                return nums[left]

            mid = (left + right) // 2 # floor division

            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid
        
        return nums[left]