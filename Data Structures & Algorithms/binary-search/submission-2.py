class Solution:
    def search(self, nums: List[int], target: int) -> int:
        lo = 0
        hi = len(nums) - 1

        while lo <= hi:
            mid = lo + (hi - lo) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target: # target is in right subarray
                #move lo pointer to be mid + 1
                lo = mid + 1
            else:
                hi = mid - 1 
        return -1