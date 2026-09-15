class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        mymap = {0: 1}

        currSum = 0
        ans = 0
        for num in nums:
            currSum += num
            diff = currSum - k
            if diff in mymap:
                val = mymap.get(diff)
                ans += val
            #update the hashmap
            mymap[currSum] = mymap.get(currSum, 0) + 1
            
        return ans




        
