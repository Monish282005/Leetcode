class Solution {
    public boolean hasAlternatingBits(int n) {

            int ans = -1;
            while (n > 0) {
            int x = n % 2;
            n /= 2;
            
            if(ans != -1 && x == ans)
                return false;
            ans = x;
        }
            return true;
    
    }
}