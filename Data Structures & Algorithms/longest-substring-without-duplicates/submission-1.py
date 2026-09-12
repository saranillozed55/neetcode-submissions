class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        curMax = 0
        left = 0
        window = 0
        mySet = set()

        for c in range(len(s)):
            while s[c] in mySet:
                mySet.remove(s[left])
                left += 1
            
            mySet.add(s[c])
            curMax = max(curMax, c - left + 1)

        return curMax
            

            
            