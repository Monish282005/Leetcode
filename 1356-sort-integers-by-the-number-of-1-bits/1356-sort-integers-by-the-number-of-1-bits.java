class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] mat = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++)
            mat[i] = arr[i];

        Comparator<Integer> comparator = new Comparator<Integer>() {

            public int compare(Integer o1, Integer o2) {
                int x = Integer.bitCount(o1);
                int y = Integer.bitCount(o2);
                if (x == y)
                    return o1 - o2;
                return x - y;
            }
        };

        Arrays.sort(mat, comparator);
        for (int i = 0; i < arr.length; i++)
            arr[i] = mat[i];

        return arr;
    }
}