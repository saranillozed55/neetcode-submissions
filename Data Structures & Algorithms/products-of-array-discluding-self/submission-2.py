class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # #brute force solution
        # res = []

        # for i in range(len(nums)):
        #     prod = 1
        #     for j in range(len(nums)):
        #         #only get the product if we are not currently at ith index
        #         if i != j:
        #             prod *= nums[j]
        #     res.append(prod)
        # return res
        n = len(nums)
        res = [0] * n
        pref = [0] * n
        suff = [0] * n

        #make sure that the values at where it starts is 1 or else the entire array will just be 0
        pref[0] = 1
        suff[n-1] = 1

        for i in range(1,n):
            pref[i] = nums[i - 1] * pref[i - 1]
        for j in range(n-2, -1, -1):
            suff[j] = nums[j+1] * suff[j+1]
        for c in range(n):
            res[c] = pref[c] * suff[c]
        return res
         

