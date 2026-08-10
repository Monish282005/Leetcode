class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String c : tokens) {
                int ans = 0;
            if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
                int b = st.pop();
                int a = st.pop();
                if (c.equals("+")) {
                    ans = (a + b);
                } else if (c.equals("-")) {
                    ans = (a - b);
                } else if (c.equals("*")) {
                    ans = (a * b);
                } else {
                    ans = (a / b);
                }
            } else {
                ans = Integer.parseInt(c);
            }
            st.push(ans);
        }

        return st.pop();
    }
}