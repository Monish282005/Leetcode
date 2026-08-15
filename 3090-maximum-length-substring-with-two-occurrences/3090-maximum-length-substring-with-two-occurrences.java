class Solution {
    public int maximumLengthSubstring(String s) {
        int maxLen = 0;
        int left = 0;
        Map<Character, Integer> mp = new HashMap<>();

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            mp.put(c, mp.getOrDefault(c, 0) + 1);

            while(mp.get(c) > 2){
                char c2 = s.charAt(left);
                mp.put(c2, mp.get(c2) - 1);
                if(mp.get(c2) == 0){
                    mp.remove(c2);
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}