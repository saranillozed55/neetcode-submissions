class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        map = {}

        #create the frequency map, key = number, value = frequency
        for num in nums:
            map[num] = map.get(num,0) + 1
        
        arr = []
        for num, count in map.items():
            #put the frequency at the 0th index and the number at the 1st index
            #after sorting the array, it will now be in ascending order
            #therefore, it will allow us to pop the values from the end of the array
            #which will be the most frequent value(s) after sorting
            arr.append([count,num])
        arr.sort()

        res = []

        #We must iterate through the arr until res is not less than k anymore
        #because then there will be that many k elements in the res array
        while len(res) < k:
            res.append(arr.pop()[1])
        
        return res
            