class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        leftval = self.binarySearch(nums, target, True)
        rightval = self.binarySearch(nums, target, False)
        return [leftval,rightval]

        
    def binarySearch(self, nums, target, leftBias) -> int:
        #implement the binary search here
        lo = 0
        hi = len(nums) -1 
        index = -1

        while lo <= hi:
            mid = lo + (hi - lo) // 2

            #check the right side
            if target > nums[mid]:
                lo = mid + 1
            elif target < nums[mid]:
                hi = mid - 1
            else:
                index = mid
                if leftBias:
                    hi = mid - 1
                else:
                    lo = mid + 1
            
        return index