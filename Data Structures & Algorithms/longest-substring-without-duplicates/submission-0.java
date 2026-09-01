class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        int maxLength = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while(map.get(c) > 1) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }
            maxLength = Math.max(maxLength, i-start + 1);
        }
        return maxLength;
    }
}
