class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();

        for(String s: words){
            int sum = 0;
            for(char c: s.toCharArray()){
                int val = c - 'a';
                sum += weights[val];
            }
            sum %= 26;
            sb.append((char) ('z' - sum));
        }

        return sb.toString();
    }
}