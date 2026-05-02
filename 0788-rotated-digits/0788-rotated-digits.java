class Solution {
    public boolean isGood(int n){
        boolean isUnique = false;

        while(n != 0){
            int rem = n % 10;

            if(rem == 3 || rem == 7 || rem == 4)
                return false;

            if(rem == 2 || rem == 5 || rem == 6 || rem == 9)
                isUnique = true;

            n /= 10;
        }

        return isUnique;
    }
    public int rotatedDigits(int n) {
        int res = 0;
        for(int i = 2; i <= n; i++){
            if(isGood(i)){
                res++;
            }
        }

        return res;
    }
}