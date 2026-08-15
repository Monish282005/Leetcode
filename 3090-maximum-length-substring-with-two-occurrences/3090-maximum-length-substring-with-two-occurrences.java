class Solution {
    public int maximumLengthSubstring(String s) {
        int maxLen = 0;
        int left = 0;
        int[] fre = new int[26];

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            fre[c - 'a']++;

            while(fre[c - 'a'] > 2){
                char c2 = s.charAt(left);
                fre[c2 - 'a']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}