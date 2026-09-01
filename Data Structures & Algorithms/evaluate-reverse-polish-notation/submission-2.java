class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String c : tokens) {
            if(c.equals("+")) {
                int pop1 = stack.pop();
                int pop2 = stack.pop();
                stack.push(pop1 + pop2);
            }
            else if(c.equals("-")) {
                int pop1 = stack.pop();
                int pop2 = stack.pop();
                stack.push(pop2 - pop1);
            }
            else if(c.equals("*")) {
                int pop1 = stack.pop();
                int pop2 = stack.pop();
                stack.push(pop1*pop2);
            }
            else if(c.equals("/")) {
                int pop1 = stack.pop();
                int pop2 = stack.pop();
                stack.push(pop2/pop1);
            }
            else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }
}
