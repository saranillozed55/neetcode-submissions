class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        baskets = {}
        
        left = 0
        max_window = 0

        for i in range(len(fruits)):
            baskets[fruits[i]] = baskets.get(fruits[i], 0) + 1

            while len(baskets) > 2:
                baskets[fruits[left]] -= 1
                if baskets[fruits[left]] <= 0:
                    baskets.pop(fruits[left], None)
                left += 1
            max_window = max(max_window, sum(baskets.values()))
        return max_window
