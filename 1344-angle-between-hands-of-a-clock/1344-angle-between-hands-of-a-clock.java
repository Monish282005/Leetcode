class Solution {
    public double angleClock(int hour, int minutes) {
        double firstHalf = 360 - Math.abs((minutes * 6) - (hour * 30 + minutes/2.0));
        double secondHalf = Math.abs((minutes * 6) - (hour * 30 + minutes/2.0));

        return Math.min(firstHalf, secondHalf);

    }
}