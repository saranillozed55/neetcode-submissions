class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        
        maxOnes = 0
        currentMax = 0
        for num in nums:
            if num == 0:
                currentMax = 0
                continue
            currentMax += 1
            maxOnes = max(maxOnes, currentMax)
        return maxOnes;
            
            