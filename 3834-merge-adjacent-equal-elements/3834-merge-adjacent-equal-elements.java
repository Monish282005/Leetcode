class Solution {
    public List<Long> mergeAdjacent(int[] nums) {

        Stack<Long> st = new Stack<>();

        for (int x : nums) {
            long num = x;   // 🔑 promote to long immediately

            while (!st.isEmpty() && st.peek() == num) {
                num += st.pop();   // safe now
            }

            st.push(num);
        }

        List<Long> arr = new ArrayList<>();
        while (!st.isEmpty()) {
            arr.add(st.pop());
        }

        Collections.reverse(arr);
        return arr;
    }
}
