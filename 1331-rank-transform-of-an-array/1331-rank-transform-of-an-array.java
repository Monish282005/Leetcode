class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        
        Arrays.sort(temp);
        Map<Integer, Integer> mp = new HashMap<>();
        int k = 0;
        int n = arr.length;

        for(int i : temp){
            // int val = temp[i];
            if(!mp.containsKey(i)){
                k++;
                mp.put(i, k);
            }
        }
        System.out.println(mp);
        for(int i = 0; i < n; i++){
            arr[i] = mp.get(arr[i]);
        }

        return arr;
    }
}