class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        mapS = {}
        mapT = {}

        for c in s:
            mapS[c] = mapS.get(c,0) + 1

        for c in t:
            mapT[c] = mapT.get(c, 0) + 1

        if(mapS == mapT):
            return True
        
        return False