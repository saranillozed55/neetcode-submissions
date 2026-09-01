class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //Create a list to the store an array of ints. List<int[]> arr
        List<int[]> arr = new ArrayList<>();
        //Iterate through the HashMap and add the value first into the list rather than the key
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }

        //Sort by descending order
        arr.sort((a,b) -> b[0] - a[0]);

        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            //Get the second element of the array inside the list
            //This is because it is the key and we want to return the number 
            //that appeared the most, since the first value is the "value"
            //it is just the number of times it appeared in the integer parameter.
            result[i] = arr.get(i)[1];
        }
        return result;
    }
}
