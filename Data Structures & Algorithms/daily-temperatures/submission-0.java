class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++) {
            
            int t = temperatures[i];
            while(!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            //[30,0]
            //pair = [30,0]
            //res[0] = 1
            
            //[38,1]
            //[30,2] => t = 36 => pair = [30,2], res[2] = 3 - 2
            stack.push(new int[]{t,i});
        }
        return res;
    }
}
