class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        lo = 0
        hi = len(nums) - 1

        while lo <= hi:
            mid = lo + (hi - lo) // 2

            #check if the current middle is the target
            if target == nums[mid]:
                return mid
            elif target > nums[mid]:
                #if target > nums[mid] we would like to only check the 
                #right side of the array so we update the lo pointer
                #to be mid + 1
                lo = mid + 1
            else:
                hi = mid - 1
        return lo