class Solution {
    public int maxNumberOfBalloons(String text) {
        int fre[] = new int[26];

        for(char c: text.toCharArray()){
            fre[c - 'a']++;
        }

        int min = Integer.MAX_VALUE;
        
        String bal = "balloon";

        for(char c: bal.toCharArray()){
            if(c == 'l' || c == 'o'){
                min = Math.min(fre[c - 'a']/2, min);
            }else min = Math.min(fre[c - 'a'], min);
        }
        return min;
    }
}