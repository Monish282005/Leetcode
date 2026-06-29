class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;

        for (String s : patterns) {
            int n = s.length();

            for (int j = 0; j < word.length(); j++) {
                int i = 0;
                while (i < n && i + j < word.length()) {
                    if (s.charAt(i) == word.charAt(i + j)) {
                        i++;
                    } else
                        break;
                }

                    if (i >= n) {
                        count++;
                        break;
                    }
            }

        }

        return count;
    }
}