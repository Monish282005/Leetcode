class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        List<Integer> ans = new ArrayList<>();

        for (int len = 2; len <= 9; len++) {

            for (int start = 0; start + len <= 9; start++) {

                int num = Integer.parseInt(s.substring(start, start + len));

                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }

        return ans;
    }
}