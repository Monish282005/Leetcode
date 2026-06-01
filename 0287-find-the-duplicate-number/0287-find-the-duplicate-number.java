class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> st = new HashSet<>();

        for(int i: nums){
            int size = st.size();
            st.add(i);
            if(st.size() <= size)
                return i;
        }

        return 0;
    }
}