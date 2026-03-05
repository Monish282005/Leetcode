class Solution {
    public int minOperations(String s) {
        int minOp = 0;
        boolean flag = true;
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (flag && c != '0')
                sum++;
            else if (!flag && c != '1')
                sum++;
            flag = !flag;
        }

        flag = true;
        for (char c : s.toCharArray()) {
            if (flag && c != '1')
                minOp++;
            else if (!flag && c != '0')
                minOp++;

            flag = !flag;
        }

        return Math.min(minOp, sum);

    }
}