class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        left = 0

        #only incerement this once we reach a 0 for first
        #want to find next non-zero element

        for right in range(len(nums)):
            #find a non zero element
            if nums[right] != 0:
                nums[left], nums[right] = nums[right], nums[left]
                left += 1

        

    
        