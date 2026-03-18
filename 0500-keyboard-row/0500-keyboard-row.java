class Solution {
    public String[] findWords(String[] words) {
        int[] fre = new int[26];

        String[] s = new String[3];
        s[0] = "qwertyuiop";
        s[1] = "asdfghjkl";
        s[2] = "zxcvbnm";

        int row = 1;
        for (String it : s) {
            for (char c : it.toCharArray()) {
                fre[c - 'a'] = row;
            }
            row++;
        }

        List<String> list = new ArrayList<>();

        for(String word: words){
            int prev = fre[Character.toLowerCase(word.charAt(0)) - 'a'];
            boolean isPossible = true;
            for(char c: word.toCharArray()){
                if(prev != fre[Character.toLowerCase(c) - 'a']){
                    isPossible = false;
                    break;
                }
            }

            if(isPossible)
                list.add(word);
        }

        String[] res = new String[list.size()];
        int i = 0;
        for(String st: list)
            res[i++] = st;

        return res;
    }
}