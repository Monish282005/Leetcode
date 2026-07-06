class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int count = 0;

        for(int[] i: intervals){
            int x1 = i[0];
            int y1 = i[1];
            for(int[] j: intervals){
                int x2 = j[0];
                int y2 = j[1];

                if(x1 == x2 && y1 == y2)
                    continue;
                
                if(x2 <= x1 && y1 <= y2){
                    count++;
                    break;
                }
            }
        }
        return intervals.length - count;
    }
}