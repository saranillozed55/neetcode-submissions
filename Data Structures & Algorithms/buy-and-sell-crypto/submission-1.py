class Solution:
    def maxProfit(self, prices: List[int]) -> int:

        curMax = 0
        curBuy = 100

        for num in prices:
            if num < curBuy:
                curBuy = num
            
            curMax = max(curMax, num - curBuy)
            
        return curMax