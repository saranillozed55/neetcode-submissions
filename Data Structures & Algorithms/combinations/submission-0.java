class Solution {

    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        backtrack(k, arr, cur, 0);
        return res;
    }
    public void backtrack(int k, int[] arr, List<Integer> cur, int index) {
        if(k == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if(index >= arr.length) {
            return;
        }

        cur.add(arr[index]);
        backtrack(k - 1, arr, cur, index + 1);
        cur.remove(cur.size() - 1);
        backtrack(k, arr, cur, index + 1);

    }
}