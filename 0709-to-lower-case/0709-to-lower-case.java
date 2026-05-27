class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()){
            int val = c;

            if(val >= 65 && val <= 90){
                sb.append((char) (c + 32));
            }else sb.append(c);
        }

        return sb.toString();
    }
}