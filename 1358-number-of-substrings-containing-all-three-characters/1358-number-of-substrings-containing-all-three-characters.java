class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int n = s.length();

        int left = 0;
        int right = 0;
        int[] fre = new int[3];
        for (right = 0; right < n; right++) {
            fre[s.charAt(right) - 'a']++;

            while (fre[0] > 0 && fre[1] > 0 && fre[2] > 0) {
                count += n - right;
                fre[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return count;
    }
}