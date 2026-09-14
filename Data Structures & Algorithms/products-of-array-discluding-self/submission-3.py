class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [0] * n # asterisk is the repetition operator when used with lists.
        #repeastes elements of the list n times
        pre = [0] * n
        suff = [0] * n

        #make sure that we set the end of both arrays as 1 because the product of 0 is always 0
        #Ex: pre = [1,0,0,0] suff = [0,0,0,1]
        pre[0] = 1
        suff[n - 1] = 1

        #iterate through nums array and multiply
        for val in range(1, n):
            pre[val] = nums[val-1] * pre[val-1]
        for val in range(n-2, -1, -1):
            suff[val] = nums[val+1] * suff[val + 1]
        for val in range(len(res)):
            res[val] = pre[val] * suff[val]
        return res

         

