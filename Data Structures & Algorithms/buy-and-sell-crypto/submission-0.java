class Solution {
    public int maxProfit(int[] prices) {
        int minimumValue = Integer.MAX_VALUE;
        int maximumProfit = 0;

        for(int price : prices) {
            if(price < minimumValue) {
                minimumValue = price;
            }
            else {
                maximumProfit = Math.max(maximumProfit, price - minimumValue);
            }
        }
        return maximumProfit;
    }
}
