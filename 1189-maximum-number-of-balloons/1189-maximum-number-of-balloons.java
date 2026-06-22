class Solution {
    public int maxNumberOfBalloons(String text) {
        int fre[] = new int[26];

        for(char c: text.toCharArray()){
            fre[c - 'a']++;
        }

        int min = Integer.MAX_VALUE;
        
        String bal = "balloon";

        for(char c: bal.toCharArray()){
            int val = fre[c - 'a'];
            if(c == 'l' || c == 'o'){
               val /= 2;
            }
            min = Math.min(val, min);
        }
        return min;
    }
}