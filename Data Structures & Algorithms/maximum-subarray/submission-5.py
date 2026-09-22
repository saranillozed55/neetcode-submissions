class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        #kadanes algorithm

        #Idea:
        #we want to have two values
        #want to have the currentSum of the subarray
        #and maximum sum so far because that is what we want to return
        #must set these to nums[0] to account for negative values

        #iterate through the array
        #when we iterate through the array we add the current num value to currentSum
        #if the currentSum becomes <= 0 then we want to set the currentSum to 0 because a negative sum will only hurt more
        
        #else:
        #we want to check if the currentSum is greater than the maximumSum, 
        #if so then we want to set maximumSum to the currentSum

        currentSum = nums[0]
        maximumSum = nums[0]

        for i in range(1, len(nums)):
            if currentSum <= 0:
                currentSum = 0
            currentSum += nums[i]
            maximumSum = max(currentSum,maximumSum)

        return maximumSum 