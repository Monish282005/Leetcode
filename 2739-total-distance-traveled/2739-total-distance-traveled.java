class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int maxDis = 0;
        while(true){
            

            if(mainTank >= 5 && additionalTank > 0){
                maxDis += 50;
                mainTank -= 5;
                mainTank++;
                additionalTank--;
            }else{
            maxDis += (mainTank * 10);
            break;
            }
            
   
        }

        return maxDis;
    }
}