class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for(int num : nums) {
            int size = res.size();
            for(int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(res.get(i));
                subset.add(num);
                Collections.sort(subset);
                
                if(set.contains(subset)) {
                    continue;
                }
                res.add(subset);
                set.add(subset);
            }
        }
        return res;
    }
}
