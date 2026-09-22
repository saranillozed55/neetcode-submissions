class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        #Because this is sorted:
        #idea is that we will calculate the sum of two pointers
        #left and right pointers
        #left points to the first element and right points to the last

        #After calculating the sum, we then check if it is greater than
        #or less than the target
        #if the sum is less than the target then we have to increment left 
        #since it is sorted. Then just decrement right if its greater than

        left = 0
        right = len(numbers) - 1

        while left < right:
            currentSum = numbers[left] + numbers[right]
            if currentSum == target:
                return [left + 1,right + 1] # add 1 because of 1-indexed array
            elif currentSum < target:
                left += 1
            else:
                right -= 1

        return []