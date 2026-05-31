class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> st = new HashSet<>();

        for(int i : candyType){
            if(st.size() < candyType.length/2)
            st.add(i);
            else break;
        }

        return st.size();
    }
}