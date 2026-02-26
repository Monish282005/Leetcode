class Solution {
    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;

        while (sb.length() > 1) {
            count++;
            if (sb.charAt(sb.length() - 1) == '0')
                sb.deleteCharAt(sb.length() - 1);
            else {
                char carry = '1';
                int i = sb.length() - 1;
                while (i >= 0 && carry != '0') {
                    if (sb.charAt(i) == '1' && carry == '1') {
                        sb.replace(i, i + 1, "0");
                    } else {
                        sb.replace(i, i + 1, "1");
                        carry = '0';
                    }
                    i--;
                }
                if (carry != '0')
                    sb.insert(0, "1");
            }
        }

        return count;
    }
}