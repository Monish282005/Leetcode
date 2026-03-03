class Solution {
    public StringBuilder reverse(StringBuilder s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            char c = s.charAt(i);
            s.setCharAt(i, s.charAt(j));
            s.setCharAt(j, c);
            i++;
            j--;
        }
        return s;
    }

    public StringBuilder invert(String s) {
        StringBuilder temp = new StringBuilder("");
        for (char c : s.toCharArray()) {
            if (c == '0')
                temp.append("1");
            else
                temp.append("0");
        }
        return temp;
    }

    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");

        while (n-- > 1) {
            String s = sb.toString();
            s += "1" + reverse(invert(s));
            sb.delete(0, sb.length());
            sb.append(s);
        }

        return sb.charAt(k - 1);

    }
}