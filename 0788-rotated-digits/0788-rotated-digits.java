class Solution {
    public boolean find(Map<Integer, Integer> mp, int n, Map<Integer, Integer> inValid) {
        boolean unique = false;
        while (n > 0) {
            int num = n % 10;
            if (inValid.containsKey(num))
                return false;

            if (mp.containsKey(num)) {
                unique = true;
            }
            n /= 10;
        }

        return unique;
    }

    public int rotatedDigits(int n) {
        int ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        Map<Integer, Integer> inValid = new HashMap<>();
        mp.put(2, 1);
        mp.put(5, 1);
        mp.put(6, 1);
        mp.put(9, 1);

        inValid.put(3, 1);
        inValid.put(4, 1);
        inValid.put(7, 1);

        for (int i = 1; i <= n; i++) {
            if (find(mp, i, inValid)) {
                ans++;
            }
        }
        return ans;
    }
}