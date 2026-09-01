class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1; // last index
        int maximumArea = 0;

        while(left < right) {
            int width = right - left;
            //Want to check the height by using Math.min because we can't overflow our container 
            //So whichever one is the smallest is the height we will keep as the hieght. 
            int height = Math.min(heights[left], heights[right]);
            //Calculate the currentArea of where are left and right pointers are
            int currentArea = width  * height;
            //Then we want to check which one is greater currentArea or our current maximumArea
            maximumArea = Math.max(maximumArea, currentArea);

            //Checking if the height of our left pointer is less than right so we can move our 
            //left pointer forward while still checking the same right pointer.
            if(heights[left] < heights[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return maximumArea;
    }
}
