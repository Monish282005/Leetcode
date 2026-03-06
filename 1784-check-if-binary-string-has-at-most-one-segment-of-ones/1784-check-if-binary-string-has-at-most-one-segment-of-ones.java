class Solution {
    public boolean checkOnesSegment(String s) {
        int count = 0;
        boolean isOne = false;
        for (char c : s.toCharArray()) {
            if (c == '1')
                isOne = true;
            else {
                if (isOne)
                    count++;
                isOne = false;
            }
        }
        if (isOne)
            count++;

        return count <= 1;
    }
}