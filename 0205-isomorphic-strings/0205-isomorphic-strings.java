class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mps = new HashMap<>();
        Map<Character, Character> mpt = new HashMap<>();

        int i = 0;

        while (i < s.length()) {
            char a = s.charAt(i), b = t.charAt(i);

            if (mps.containsKey(a) && mps.get(a) != b)
                return false;

            if (mpt.containsKey(b) && mpt.get(b) != a)
                return false;

            mps.put(a, b);
            mpt.put(b, a);
            i++;
        }

        return true;
    }
}